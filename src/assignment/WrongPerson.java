package assignment;

public class WrongPerson extends Person {
    private String name;
    private int age;

    public WrongPerson(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean equals(Object o) {
        boolean answer = super.equals(o);
        return !answer;
    }

    @Override
    public int hashCode() {
        return (int) (Math.random() * 100);
    }
}