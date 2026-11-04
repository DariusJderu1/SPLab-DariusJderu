package sp.self.learning.commands;

import sp.self.learning.persistence.entities.Book;

public class DeleteBookCommand
{
    public boolean execute(CommandContext context, Integer id)
    {
        Book book = context.booksRepository().findById(id).orElse(null);
        if(book == null)
            return false;

        context.booksRepository().delete(book);
        return true;
    }
}
