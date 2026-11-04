package sp.self.learning.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sp.self.learning.commands.CommandContext;
import sp.self.learning.commands.CreateBookCommand;
import sp.self.learning.persistence.BooksRepository;
import sp.self.learning.persistence.entities.Book;

@RestController
public class BooksController
{
    private final CommandContext commandContext;

    public BooksController(BooksRepository booksRepository)
    {
        // Spring injects the repository and the context passes it to commands
        commandContext = new CommandContext(booksRepository);
    }

    @PostMapping("/books")
    public ResponseEntity<CreateBookResponse> createBook(@RequestBody CreateBookRequest request)
    {
        if(request.title() == null || request.title().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book title is required");

        Book book = new CreateBookCommand().execute(commandContext, request.title());

        // Return the generated id in the JSON response
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateBookResponse(book.getId()));
    }

    public record CreateBookRequest(String title)
    {
    }

    public record CreateBookResponse(Integer id)
    {
    }
}
