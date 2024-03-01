package Builder;

public class Person {
    String name;
    String email;
    String title;
    String phone;
    String address;
    String gender;

    private Person() {}

    static class PersonBuilder {
        private Person person = new Person();

        public PersonBuilder(String name, String email) {
            person.name = name;
            person.email = email;
        }
        public PersonBuilder setAddress(String address) {
            person.address = address;
            return this;
        }
        public PersonBuilder setTitle(String title) {
            person.title = title;
            return this;
        }
        public PersonBuilder setPhone(String phone) {
            person.phone = phone;
            return this;
        }
        public PersonBuilder setGender(String gender) {
            person.gender = gender;
            return this;
        }
        public Person build() {
            return person;
        }
    }
}
