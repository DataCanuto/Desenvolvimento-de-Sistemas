public enum EnumAgencia {
    AG_3466(3466),
    AG_0001(0001),
    AG_0808(808);

    private final int numeroAgencia;

    EnumAgencia(int numeroAgencia){
        this.numeroAgencia = numeroAgencia;
    }

    public int getNumeroAgencia(){
        return numeroAgencia;
    }
}
