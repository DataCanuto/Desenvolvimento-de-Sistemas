#include <DHT.h>
#include <WiFi.h>
#include <PubSubClient.h>
#include <ESP32Servo.h> // Include the Servo library
#include <FastLED.h> // Include the FastLED library

// Defining Pins
#define DHTPIN 12
#define LED 26
#define SERVO_PIN 2 // Servo motor pin
#define LED_PIN 4 // WS2812 LED strip pin
#define NUM_LEDS 16 // Number of LEDs in the strip

// DHT parameters
#define DHTTYPE    DHT22     // DHT 11
DHT dht(DHTPIN, DHTTYPE);

// Servo motor
Servo servo;

// WS2812 LED strip
CRGB leds[NUM_LEDS];

// MQTT Credentials
const char* ssid = "Wokwi-GUEST"; // Setting your AP SSID
const char* password = ""; // Setting your AP PSK
const char* mqttServer = "broker.hivemq.com";
// const char* mqttUserName = "bqzbdodo";
// const char* mqttPwd = "5oU2W_QN2WD8";
const char* clientID = "ESP32_Pedro_001"; // Client ID
const char* topic = "Tempdata"; // Publish topic

// Parameters for using non-blocking delay
unsigned long previousMillis = 0;
long interval = 1000;
String msgStr = "";      // MQTT message buffer
float temp, hum;

// Setting up WiFi and MQTT client
WiFiClient espClient;
PubSubClient client(espClient);

void setup_wifi() {
  delay(10);
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);

  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
}

void callback(char* topic, byte* payload, unsigned int length) {
  Serial.print("Message arrived [");
  Serial.print(topic);
  Serial.print("] ");

  String message = "";
  for (int i = 0; i < (int)length; i++) {
    message += (char)payload[i];
  }
  Serial.println(message);

  // Control the simple LED based on received message
  if (message == "ON") {
    digitalWrite(LED, HIGH);
    Serial.println("LED ON");
  } else if (message == "OFF") {
    digitalWrite(LED, LOW);
    Serial.println("LED OFF");
  }

  // Control servo position (0-180) based on numeric message
  int servoPos = message.toInt();
  if (servoPos >= 0 && servoPos <= 180) {
    servo.write(servoPos);
  }
}

void reconnect() {
  while (!client.connected()) {
    Serial.print("Attempting MQTT connection...");
    if (client.connect(clientID)) {
      Serial.println("MQTT connected");
      client.subscribe(topic);
      Serial.println("Topic Subscribed");
    } else {
      Serial.print("failed, rc=");
      Serial.print(client.state());
      Serial.println(" try again in 5 seconds");
      delay(5000);
    }
  }
}

void setup() {
  Serial.begin(115200);
  // Initialize device.
  dht.begin();

  pinMode(LED, OUTPUT);
  digitalWrite(LED, LOW);

  // Setup servo
  servo.attach(SERVO_PIN, 500, 2400);
  servo.write(0);

  // Setup WS2812 LED strip
  FastLED.addLeds<WS2812, LED_PIN, GRB>(leds, NUM_LEDS);

  setup_wifi();
  client.setServer(mqttServer, 1883);
  client.setCallback(callback);
}

void loop() {
  if (!client.connected()) {
    reconnect();
  }
  client.loop();

  unsigned long currentMillis = millis();
  if (currentMillis - previousMillis >= (unsigned long)interval) {
    previousMillis = currentMillis;

    temp = dht.readTemperature();
    hum = dht.readHumidity();

    if (isnan(temp)) {
      Serial.println(F("Error reading temperature!"));
    } else {
      Serial.print(F("Temperature: "));
      Serial.print(temp);
      Serial.println(F("°C"));
    }

    if (isnan(hum)) {
      Serial.println(F("Error reading humidity!"));
    } else {
      Serial.print(F("Humidity: "));
      Serial.print(hum);
      Serial.println(F("%"));
    }

    // Build MQTT message string: "temp,hum,"
    msgStr = String(temp) + "," + String(hum) + ",";
    byte arrSize = msgStr.length() + 1;
    char msg[arrSize];

    Serial.print("PUBLISH DATA: ");
    Serial.println(msgStr);
    msgStr.toCharArray(msg, arrSize);
    client.publish(topic, msg);
    msgStr = "";

    // Update WS2812 LED strip with temperature color
    // Blue (cold) <-> Red (hot) gradient: 0-50°C
    int r = 0, g = 0, b = 0;
    if (!isnan(temp)) {
      float ratio = temp / 50.0;
      if (ratio > 1.0) ratio = 1.0;
      if (ratio < 0.0) ratio = 0.0;
      r = (int)(ratio * 255);
      b = (int)((1.0 - ratio) * 255);
    }
    for (int i = 0; i < NUM_LEDS; i++) {
      leds[i] = CRGB(r, g, b);
    }
    FastLED.show();

    // Move servo based on humidity (0-100% → 0-180°)
    if (!isnan(hum)) {
      int servoPos = (int)(hum * 1.8);
      servo.write(servoPos);
    }
  }
}
