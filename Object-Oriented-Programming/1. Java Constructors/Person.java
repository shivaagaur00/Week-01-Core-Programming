public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    public static void main(String[] args) {
        Person p1 = new Person("John", 25);
        Person p2 = new Person(p1);
        System.out.println(p1);
        System.out.println("Cloned: " + p2);
    }
}
