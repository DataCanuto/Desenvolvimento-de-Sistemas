public class Pet {
    private String name;
    private int age;
    private boolean clean;

    public Pet() {
    }

    public Pet(String name, int age, boolean clean) {
        this.name = name;
        this.age = age;
        this.clean = clean;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    

    


}
