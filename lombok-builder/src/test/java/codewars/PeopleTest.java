package codewars;public class People {

    public static class PeopleBuilder {
        People people;

        public PeopleBuilder() {
            this.people = new People();
        }

        public PeopleBuilder name(String name) {
            this.people.name = name;
            return this;
        }

        public PeopleBuilder age(int age) {
            this.people.age = age;
            return this;
        }

        public PeopleBuilder lastName(String lastName) {
            this.people.lastName = lastName;
            return this;
        }

        public PeopleBuilder city(String city) {
            this.people.city = city;
            return this;
        }

        public PeopleBuilder job(String job) {
            this.people.job = job;
            return this;
        }

        public People build() {
            return people;
        }
    }

    private int age;
    private String name;
    private String lastName;
    private String city;
    private String job;
    public String greet = "hello";

    public String greet() {
        return greet + " my name is " + name;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getJob() {
        return job;
    }

    public static PeopleBuilder builder() {
        return new PeopleBuilder();
    }
}

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runners.JUnit4;

import java.security.SecureRandom;
import java.math.BigInteger;
import java.lang.reflect.*;

public class PeopleTest {

    @Test
    public void testSample() {
        People person = People.builder().name("Adam").lastName("Savage").age(25).city("San Francisco").job("Unchained Reaction").build();
        assertEquals(
                "Adam",
                person.getName()
        );
        assertEquals(
                "hello my name is Adam",
                person.greet()
        );
    }
}
