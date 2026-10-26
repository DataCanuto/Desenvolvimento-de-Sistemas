import http from "http";
import rotas from "./routes.js";
import app from "./app.js";

const PORT = 3000;

/*const server = http.createServer((req, res) => {
res.writeHead(200, { "Content-Type": "text/plain" });
res.end(rotas[req.url]);
});*/

app.listen(PORT, () => {
    console.log(`Servidor escutando em http:localhost/${PORT}`);
})