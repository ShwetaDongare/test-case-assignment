package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;

    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

class MyClass {
    public static void main(String[] args) {
        Person swamiji = new Person("Swamiji", 3);
        Person kunal = new Person("Kunal", 50);
        Person digvijay = new Person("Digvijay", 35);
        List<Person> people = addPeopleToList(digvijay, kunal, swamiji);

        Collections.sort(people);
        System.out.println(people);

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().length() - p2.getName().length();
            }
        });
        System.out.println(people);

    }

    public static List addPeopleToList(Person... persons) {
        List<Person> people = new ArrayList<Person>();
        for (Person person : persons) {
            people.add(person);
        }
        return people;
    }
}