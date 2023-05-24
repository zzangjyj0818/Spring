package Mission1;

public abstract class AbstractPerson implements Person {
    private String name;
    private int age;

    public AbstractPerson() {
    }

    public AbstractPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void speak() {
        System.out.println(String.format("Hi, my name is %s.", this.name));
    }
}
