import java.util.ArrayList;
import java.util.List;

// Observer pattern
interface Observer {
    void update(String message);
}

// Concrete observer
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
}

// Singleton pattern
class Library {
    private static Library instance = new Library();
    private List<Observer> observers = new ArrayList<>();

    private Library() {
    }

    public static Library getInstance() {
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void addBook(String bookTitle) {
        System.out.println("Book added: " + bookTitle);
        notifyObservers("New book added: " + bookTitle);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Strategy pattern
interface CheckoutStrategy {
    void checkoutBook(String bookTitle);
}

// Concrete strategies
class SingleCheckoutStrategy implements CheckoutStrategy {
    @Override
    public void checkoutBook(String bookTitle) {
        System.out.println("Checking out book: " + bookTitle);
    }
}

class MultipleCheckoutStrategy implements CheckoutStrategy {
    @Override
    public void checkoutBook(String bookTitle) {
        System.out.println("Checking out multiple books: " + bookTitle);
    }
}

// State pattern
interface BookState {
    void reserveBook();
    void checkoutBook();
}

// Concrete states
class AvailableState implements BookState {
    @Override
    public void reserveBook() {
        System.out.println("Book reserved");
    }

    @Override
    public void checkoutBook() {
        System.out.println("Book checked out");
    }
}

class ReservedState implements BookState {
    @Override
    public void reserveBook() {
        System.out.println("Book is already reserved");
    }

    @Override
    public void checkoutBook() {
        System.out.println("Book checked out");
    }
}

class Book {
    private String title;
    private BookState state;

    public Book(String title) {
        this.title = title;
        this.state = new AvailableState();
    }

    public void setState(BookState state) {
        this.state = state;
    }

    public void reserve() {
        state.reserveBook();
    }

    public void checkout() {
        state.checkoutBook();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Singleton
        Library library = Library.getInstance();

        // Observer
        User user1 = new User("User 1");
        User user2 = new User("User 2");
        library.addObserver(user1);
        library.addObserver(user2);

        // Strategy
        CheckoutStrategy singleCheckout = new SingleCheckoutStrategy();
        CheckoutStrategy multipleCheckout = new MultipleCheckoutStrategy();

        // State
        Book book = new Book("Design Patterns");

        // Adding a book triggers observer notification
        library.addBook("Introduction to Java");

        // Checkout using different strategies
        singleCheckout.checkoutBook("Introduction to Java");
        multipleCheckout.checkoutBook("Introduction to Java");

        // Reserve and checkout a book with different states
        book.reserve();
        book.checkout();
        book.setState(new ReservedState());
        book.reserve();
        book.checkout();
    }
}
