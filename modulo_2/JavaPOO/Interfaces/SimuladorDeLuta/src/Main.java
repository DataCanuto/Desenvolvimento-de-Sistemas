import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Lutador l[] = new Lutador[6];
        Scanner leitor = new Scanner(System.in);

        l[0] = new Lutador(1.75f, 0, 0, 28, "Brasileiro", "João", 68.9f, 0);
        l[1] = new Lutador(1.68f, 0, 0, 30, "Americano", "Mike", 68.9f, 0);
        l[2] = new Lutador(1.80f, 1, 0, 25, "Russo", "Ivan", 85.5f, 8);
        l[3] = new Lutador(1.65f, 0, 3, 32, "Mexicano", "Carlos", 60.0f, 15);
        l[4] = new Lutador(1.90f, 4, 1, 29, "Canadense", "David", 95.0f, 20);
        l[5] = new Lutador(1.70f, 2, 2, 27, "Japonês", "Ken", 70.0f, 18);

       
        
        Luta fight[] = new Luta[6];
        fight[0] = new Luta(l[0], l[1]);

        fight[0].marcarLuta(l[0], l[1]);
        fight[0].Lutar();
        fight[0].statusLuta();
        fight[0].Lutar();
        fight[0].statusLuta();
        fight[0].Lutar();
        fight[0].statusLuta();
        fight[0].Lutar();

       

        
       
    }
}