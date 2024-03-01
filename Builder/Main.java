package Builder;

public class Main {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder("Priyanshu Gupta" ,"priyanshu@gmail.com")
                                .setTitle("Software Engineer")
                                .setPhone("+91-9027644034")
                                .setGender("Male")
                                .setAddress("India")
                                .build();
        System.out.println(person);
    }
}