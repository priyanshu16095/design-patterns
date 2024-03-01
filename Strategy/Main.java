public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCard("priyanshu@gmail.com"));
        cart.checkOut(100);
    }
}