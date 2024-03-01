public class Main {
    public static void main(String[] args) {
        Newspaper newspaper = new Newspaper();

        Subscriber subscriber1 = new Subscriber("sub-1");
        Subscriber subscriber2 = new Subscriber("sub-2");

        newspaper.addObserver(subscriber1);
        newspaper.addObserver(subscriber2);

        newspaper.publishNews("Weather 25C, Sunny");
    }
}
