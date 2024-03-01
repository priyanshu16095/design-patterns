public class Paytm implements PaymentStrategy {
    String email;
    
    public Paytm(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid: " + amount + " using credit card.");
    }

}
