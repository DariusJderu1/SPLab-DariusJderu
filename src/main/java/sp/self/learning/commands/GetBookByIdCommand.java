package sp.self.learning.commands;

import sp.self.learning.persistence.entities.Book;

import java.util.Optional;

public class GetBookByIdCommand
{
    public Optional<Book> execute(CommandContext context, Integer id)
    {
        return context.booksRepository().findById(id);
    }
}
