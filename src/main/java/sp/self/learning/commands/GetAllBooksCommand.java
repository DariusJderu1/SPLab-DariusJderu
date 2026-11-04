package sp.self.learning.commands;

import sp.self.learning.persistence.entities.Book;

import java.util.List;

public class GetAllBooksCommand
{
    public List<Book> execute(CommandContext context)
    {
        return context.booksRepository().findAll();
    }
}
