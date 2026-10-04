package model;

public class Space {
    private Integer actual;
    private final int expected;
    private final boolean fixed;

    public Space(final int excpected, final boolean fixed) {
        this.expected = excpected;
        this.fixed = fixed;
        if(fixed){
            actual = excpected;
        }
    }

    public Integer getActual() {
        return actual;
    }

    public void setActual(final Integer actual) {
        if(fixed) return;
        this.actual = actual;
    }

    public void clearSpace(){
        setActual(null);
    }

    public int getExpected() {
        return expected;
    }

    public boolean isFixed(){
        return fixed;
    }

    



    

    

}
