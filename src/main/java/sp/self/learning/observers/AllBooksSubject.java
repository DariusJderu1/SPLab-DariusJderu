package sp.self.learning.observers;

import org.springframework.stereotype.Component;
import sp.self.learning.persistence.entities.Book;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject implements Subject
{
    private final List<Book> books = new CopyOnWriteArrayList<>();
    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    @Override
    public void attach(Observer observer)
    {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer)
    {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Book book)
    {
        for(Observer observer : observers)
            observer.update(book);
    }

    public void add(Book book)
    {
        books.add(book);
        notifyObservers(book);
    }
}
