public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Недопустимое значение для возраста.");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() throws IllegalArgumentException {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Недостаточно данных.");
        }
        if (city == null) {
            return new Person(name, surname, age);
        }
        if (age == -1) {
            return new Person(name, surname, city);
        }
        return new Person(name, surname, age, city);
    }
}
