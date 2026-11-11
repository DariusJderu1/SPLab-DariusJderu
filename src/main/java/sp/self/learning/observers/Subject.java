package sp.self.learning.observers;

import sp.self.learning.persistence.entities.Book;

public interface Subject
{
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Book book);
}
