public enum EnumConta {
    CC_123974(123974),
    CC_147890(147890),
    CC_132789(132789);

    private final int numeroConta;

    EnumConta(int numeroConta){
        this.numeroConta = numeroConta;
    }

    public int getNumeroConta(){
        return numeroConta;
    }
}
