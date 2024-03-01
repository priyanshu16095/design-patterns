import java.util.ArrayList;
import java.util.List;

public class Newspaper implements Subject {
    private List<Observer> subscribers = new ArrayList<>();
    private String lastestNews;
    @Override
    public void addObserver(Observer observer) {
        subscribers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        subscribers.remove(observer);
    }
    @Override
    public void notifyObservers(String news) {
        lastestNews = news;
        for(Observer observer : subscribers) {
            observer.update(lastestNews);
        }
    }
    public void publishNews(String news) {
        notifyObservers(news);
    }   
}
