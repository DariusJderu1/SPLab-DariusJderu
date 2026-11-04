package sp.self.learning.commands;

import sp.self.learning.persistence.entities.Book;

import java.util.Optional;

public class UpdateBookCommand
{
    public Optional<Book> execute(CommandContext context, Integer id, String title)
    {
        return context.booksRepository().findById(id).map(book ->
        {
            // Update the existing book so its id and relationships are preserved
            book.setTitle(title);
            return context.booksRepository().save(book);
        });
    }
}
