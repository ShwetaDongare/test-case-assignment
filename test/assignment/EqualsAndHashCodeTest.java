package assignment;

import assignment.Person;
import assignment.WrongPerson;
import org.junit.Assert;
import org.junit.Test;

public class EqualsAndHashCodeTest {
    @Test
    public void testToCheckEqualsWhenTwoStringsAreNotEqualGivesFalse() throws Exception {
        String hello = "hello";
        String world = new String("world");
        Assert.assertEquals(false, hello.equals(world));
    }

    @Test
    public void testToCheckEqualsWhenTwoStringsAreEqualGivesTrue() throws Exception {
        String hello1 = "hello";
        String hello2 = new String("hello");
        Assert.assertEquals(true, hello1.equals(hello2));
    }

    @Test
    public void testToCheckEqualsWhenTwoStringsAreEqualGivesTrueUsingLiterals() throws Exception {
        String hello1 = "hello";
        String hello2 = "hello";
        Assert.assertEquals(true, hello1.equals(hello2));
    }

    @Test
    public void testToCheckEqualsWhenTwoStringsAreNotEqualGivesFalseUsingLiterals() throws Exception {
        String hello1 = "hello";
        String world = "world";
        Assert.assertEquals(false, hello1.equals(world));
    }

    @Test
    public void testToCheckEqualsWhenTwoStringsAreEqualGivesTrueUsingStringConstructor() throws Exception {
        String hello1 = new String("hello");
        String hello2 = new String("hello");
        Assert.assertEquals(true, hello1.equals(hello2));
    }

    @Test
    public void testToCheckEqualsWhenTwoStringsAreNotEqualGivesFalseUsingStringConstructor() throws Exception {
        String hello1 = new String("hello");
        String world = new String("world");
        Assert.assertEquals(false, hello1.equals(world));
    }

    @Test
    public void testHashCodeWhenImplementedIncorrectly() throws Exception {
        WrongPerson p1 = new WrongPerson("Sayali", 18);
        int first = p1.hashCode();
        int second = p1.hashCode();
        Assert.assertEquals(false, first == second);
    }

    @Test
    public void testHashCodeWhenImplementedCorrectly() throws Exception {
        Person p1 = new Person("Sayali", 18);
        int first = p1.hashCode();
        int second = p1.hashCode();
        Assert.assertEquals(true, first == second);
    }

    @Test
    public void testEqualWhenImplementedCorrectlyGivesTrue() throws Exception {
        Person p1 = new Person("Sayali", 18);
        Person p2 = new Person("Sayali", 18);
        Assert.assertEquals(true, p1.equals(p2));
    }

    @Test
    public void testEqualWhenImplementedCorrectlyWhenObjectsAreNotEqualGivesFalse() throws Exception {
        Person p1 = new Person("Sayali", 18);
        Person p2 = new Person("Mritunjay", 17);
        Assert.assertEquals(false, p1.equals(p2));
    }

    @Test
    public void testEqualWhenImplementedIncorrectlyWhenObjectsAreNotEqualGivesFalse() throws Exception {
        WrongPerson p1 = new WrongPerson("Sayali", 18);
        WrongPerson p2 = new WrongPerson("Mritunjay", 17);
        Assert.assertEquals(true, p1.equals(p2));
    }

    @Test
    public void testEqualWhenImplementedIncorrectlyWhenObjectsAreEqualGivesFalse() throws Exception {
        WrongPerson p1 = new WrongPerson("Sayali", 18);
        WrongPerson p2 = new WrongPerson("Sayali", 18);
        Assert.assertEquals(false, p1.equals(p2));
    }
}