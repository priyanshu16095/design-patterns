import java.util.*;

interface Observer {
    void update(String message);
}
class User implements Observer {
    private String name;
    public User(String name) {
        this.name = name;
    }
    @Override
    public void update(String message) {
        System.out.println(name + " received notfication: " + message);
    }
}

class Book {
    String title;
    BookState bookstate;
    public Book(String title) {
        this.title = title;
    }
}

class Library {
    private static Library instance;
    private Library() {}
    public static Library getInstance() {
        if(instance == null) {
            return new Library();
        }
        return instance;
    }

    private List<Observer> observers = new ArrayList<>();
    private List<Book> books = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void addBook(String title) {
        Book book = new Book(title);
        books.add(book);
        System.out.println("Book added: " + title);
        notifyObservers("New book added: " + title);
    }
    public void listBooks() {
        System.out.println("Available Books:");
        for(Book book : books) {
            System.out.println("- " + book.title);
        }
        System.out.println();
    }
    public void checkOutBook(String title) {
        Book book = findBook(title);
        if(book != null) {
            book.checkOut();
            return;
        }
        System.out.println("Book not found: " + title);
    }
    public void reserveBook(String title) {
        Book book = findBook(title);
        if(book != null) {
            reserveBook(title);
            return;
        }
        System.out.println("Book not found: " + title);
    }
    private Book findBook(String title) {
        for(Book book : books) {
            if(book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    private void notifyObservers(String message) {
        for(Observer observer : observers) {
            observer.update(message);
        }
    }
}







public class system {
    
}
