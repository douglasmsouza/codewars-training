package codewars;

public class People {

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
    private static final String GREET = "hello";

    public String greet() {
        return GREET + " my name is " + name;
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