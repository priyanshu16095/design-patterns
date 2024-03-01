import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    private List<Book> books = new ArrayList<>();

    private Library() {
    }

    public static Library getInstance() {
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void addBook(String bookTitle) {
        Book book = new Book(bookTitle);
        books.add(book);
        System.out.println("Book added: " + bookTitle);
        notifyObservers("New book added: " + bookTitle);
    }

    public void listBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle());
        }
        System.out.println();
    }

    public void checkoutBook(String bookTitle) {
        Book book = findBook(bookTitle);
        if (book != null) {
            book.checkout();
        } else {
            System.out.println("Book not found: " + bookTitle);
        }
    }

    public void reserveBook(String bookTitle) {
        Book book = findBook(bookTitle);
        if (book != null) {
            book.reserve();
        } else {
            System.out.println("Book not found: " + bookTitle);
        }
    }

    private Book findBook(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                return book;
            }
        }
        return null;
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

    public String getTitle() {
        return title;
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

public class full {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        User user1 = new User("User 1");
        User user2 = new User("User 2");
        library.addObserver(user1);
        library.addObserver(user2);

        library.addBook("Introduction to Java");
        library.addBook("Design Patterns");
        library.addBook("Data Structures and Algorithms");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. List Books");
            System.out.println("2. Checkout Book");
            System.out.println("3. Reserve Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    library.listBooks();
                    break;
                case 2:
                    System.out.print("Enter the book title to checkout: ");
                    String checkoutTitle = scanner.nextLine();
                    library.checkoutBook(checkoutTitle);
                    break;
                case 3:
                    System.out.print("Enter the book title to reserve: ");
                    String reserveTitle = scanner.nextLine();
                    library.reserveBook(reserveTitle);
                    break;
                case 4:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
