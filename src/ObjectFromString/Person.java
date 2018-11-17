package ObjectFromString;

public class Person {

    private String name;
    private String surename;
    private int age;
    private String fullName;

    public Person(String name, String surename, int age) {
        this.name = name;
        this.surename = surename;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "objectFromString.Person{" +
                "name='" + name + '\'' +
                ", surename='" + surename + '\'' +
                ", age=" + age +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
