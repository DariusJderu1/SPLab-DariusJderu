package sp.self.learning.commands;

import sp.self.learning.persistence.CrudRepository;
import sp.self.learning.persistence.entities.Book;

// Holds the repository that book commands use
public record CommandContext(CrudRepository<Book, Integer> booksRepository)
{
}
