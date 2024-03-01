public class Main {
    public static void main(String[] args) {
        Database db = new Database();

        User user1 = User.UserBuilder("Priyanshu Gupta", "priyanshu@gmail.com")
                            .setPhone("+91-9027644034")
                            .setAddress("India")
                            .build();

        db.addObserver(user1);

        
    }
}