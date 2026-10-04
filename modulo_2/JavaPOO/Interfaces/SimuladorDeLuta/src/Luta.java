import java.util.Random;

public class Luta {
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;

    public Luta() {}

    public Luta(Lutador desafiado, Lutador desafiante) {
        this.desafiado = desafiado;
        this.desafiante = desafiante;       
        
    }

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }

    public void marcarLuta(Lutador l1, Lutador l2) {
        if (l1.getCategoria().equals(l2.getCategoria()) && l1 != l2) {
            setAprovada(true);
            setDesafiado(l1);
            setDesafiante(l2);
        } else {
            setAprovada(false);
            setDesafiado(null);
            setDesafiante(null);
        }
    }

    public void Lutar() {
        if (isAprovada()) {
            System.out.println("### DESAFIADO ###");
            getDesafiado().apresentar();
            System.out.println("### DESAFIANTE ###");
            getDesafiante().apresentar();

            Random aleatorio = new Random();
            int vencedor = aleatorio.nextInt(3); // 0, 1 ou 2

            switch(vencedor){
                case 0 -> {
                    System.out.println("Empate!");
                    getDesafiado().empatarLuta();
                    getDesafiante().empatarLuta();

                }
                case 1 -> {
                    System.out.println("Vitória do " + getDesafiado().getNome());
                    getDesafiado().vencerLuta();
                    getDesafiante().perderLuta();
                }
                case 2 -> {
                    System.out.println("Vitória do " + getDesafiante().getNome());
                    getDesafiante().vencerLuta();
                    getDesafiado().perderLuta();
                }
            }
            setRounds(getRounds() + 1);


        }else{
            System.out.println("A luta não pode acontecer");
        }
    }

        public void statusLuta() {
            if(isAprovada()) {
                System.out.println("### DESAFIADO ###");
                getDesafiado().status();
                System.out.println("### DESAFIANTE ###");
                getDesafiante().status();
                System.out.println("Total de rounds: " + getRounds());
            }
        }
    




}
