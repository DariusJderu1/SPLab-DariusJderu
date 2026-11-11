package sp.self.learning.observers;

import sp.self.learning.persistence.entities.Book;

public interface Observer
{
    void update(Book book);
}
