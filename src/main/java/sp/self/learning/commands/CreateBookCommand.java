package sp.self.learning.commands;

import sp.self.learning.persistence.entities.Book;

public class CreateBookCommand
{
    public Book execute(CommandContext context, String title)
    {
        Book book = new Book(title);

        // Returns the saved book with its generated id
        return context.booksRepository().save(book);
    }
}
