public class CreditCard implements PaymentStrategy {
    String email;

    public CreditCard(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid: " + amount + " using credit card.");
    }
    
}
