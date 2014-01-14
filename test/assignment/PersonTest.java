package assignment;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Comparator;
import java.util.List;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class AddPeople {
    public static List addPeopleToList(Person... persons) {
        List<Person> people = new ArrayList<Person>();
        Collections.addAll(people, persons);
        return people;
    }
}

public class PersonTest {
    Person swamiji = new Person("Swamiji", 3);
    WrongPerson swamiji1 = new WrongPerson("Swamiji", 3);
    WrongPerson swamiji2 = new WrongPerson("Swamiji", 3);
    Person kunal = new Person("Kunal", 50);
    Person kunal1 = new Person("Kunal", 50);
    Person digvijay = new Person("Digvijay", 35);
    Person digvijay1 = new Person("Digvijay", 35);
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

    //*******************************************************************

    @Test
    public void testInsertsInHashMapShouldOverWriteForSameData(){
        HashMap<Person,Person> people = new HashMap<Person,Person>();
        people.put(digvijay,digvijay);
        people.put(digvijay1,digvijay1);
        Assert.assertEquals(1, people.size());
    }

    @Test
    public void testInsertsBothWrongPersonWhoAreNotEqual(){
        HashMap<WrongPerson,WrongPerson> people = new HashMap<WrongPerson,WrongPerson>();
        people.put(swamiji1,swamiji1);
        people.put(swamiji2,swamiji2);
        Assert.assertEquals(2, people.size());
    }

    @Test
    public void testInsertsAndOverWriteTwoPersonWithSameHashCode(){
        Set<Person> people = new HashSet<Person>();
        people.add(kunal);
        people.add(kunal1);
        Assert.assertEquals(1, people.size());
    }

    @Test
    public void testInsertInSetShouldNotOverWriteIfHashCodeNotImplemented(){
        Set<WrongPerson> people = new HashSet<WrongPerson>();
        people.add(swamiji1);
        people.add(swamiji2);
        Assert.assertEquals(2, people.size());
    }

    //*****************************************************************************

    @Test(expected = ClassCastException.class)
    public void testThrowsClassCastException () {
        ArrayList list = new ArrayList<Person>();
        list.add("hello");
        Person person = (Person) list.get(0);
    }

}