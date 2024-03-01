public class User implements Observer {
    String name;
    String email;
    String phone;
    String address;

    class UserBuilder {
        private static User user = new User();
        public UserBuilder(String name, String email) {
            user.name = name;
            user.email = email;
        }
        public UserBuilder setPhone(String phone) {
            user.phone = phone;
            return this;
        }
        public UserBuilder setAddress(String address) {
            user.address = address;
            return this;
        }
        public User build() {
            return user;
        }
    }
    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
