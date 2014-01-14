package assignment;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Comparator;
import java.util.List;

class AddPeople {
    public static List addPeopleToList(Person... persons) {
        List<Person> people = new ArrayList<Person>();
        Collections.addAll(people, persons);
        return people;
    }
}

public class PersonTest {
    Person swamiji = new Person("Swamiji", 3);
    Person kunal = new Person("Kunal", 50);
    Person digvijay = new Person("Digvijay", 35);
    List people = AddPeople.addPeopleToList(digvijay, kunal, swamiji);

    @Test
    public void testCompareToAccordingToNameLength() throws Exception {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().length() - p2.getName().length();
            }
        });
        Assert.assertEquals(true, kunal.equals(people.get(0)));
        Assert.assertEquals(true, swamiji.equals(people.get(1)));
        Assert.assertEquals(true, digvijay.equals(people.get(2)));
    }

    @Test
    public void testCompareToAccordingToName() throws Exception {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
        Assert.assertEquals(true, digvijay.equals(people.get(0)));
        Assert.assertEquals(true, kunal.equals(people.get(1)));
        Assert.assertEquals(true, swamiji.equals(people.get(2)));
    }

    @Test
    public void testCompareToAccordingToAge() throws Exception {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        });
        Assert.assertEquals(true, digvijay.equals(people.get(1)));
        Assert.assertEquals(true, kunal.equals(people.get(2)));
        Assert.assertEquals(true, swamiji.equals(people.get(0)));
    }

    @Test
    public void testCompareToAccordingToNameReverse() throws Exception {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p2.getName().length() - p1.getName().length();
            }
        });
        Assert.assertEquals(true, digvijay.equals(people.get(0)));
        Assert.assertEquals(true, swamiji.equals(people.get(1)));
        Assert.assertEquals(true, kunal.equals(people.get(2)));
    }
}