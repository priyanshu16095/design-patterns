import java.util.*;

public class Database implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers(String message) {
        for(Observer observer : observers) {
            observer.update(message);
        }
    }
    public void provideMessage(String message) {
        notifyObservers(message);
    }    
}
