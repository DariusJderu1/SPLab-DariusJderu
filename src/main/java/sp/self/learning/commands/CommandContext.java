package sp.self.learning.commands;

import sp.self.learning.persistence.BooksRepository;

// Holds the repository that book commands use
public record CommandContext(BooksRepository booksRepository)
{
}
