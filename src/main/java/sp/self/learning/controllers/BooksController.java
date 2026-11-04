package sp.self.learning.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import sp.self.learning.commands.CommandContext;
import sp.self.learning.commands.CreateBookCommand;
import sp.self.learning.commands.DeleteBookCommand;
import sp.self.learning.commands.GetAllBooksCommand;
import sp.self.learning.commands.GetBookByIdCommand;
import sp.self.learning.commands.UpdateBookCommand;
import sp.self.learning.persistence.BooksRepository;
import sp.self.learning.persistence.entities.Book;

import java.util.List;

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
        validateTitle(request.title());

        Book book = new CreateBookCommand().execute(commandContext, request.title());

        // Return the generated id in the JSON response
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateBookResponse(book.getId()));
    }

    @GetMapping("/books")
    public List<BookResponse> getAllBooks()
    {
        return new GetAllBooksCommand().execute(commandContext).stream()
                .map(this::toBookResponse)
                .toList();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable("id") Integer id)
    {
        return ResponseEntity.of(new GetBookByIdCommand().execute(commandContext, id)
                .map(this::toBookResponse));
    }

    @Transactional
    @PutMapping("/books/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable("id") Integer id,
                                                   @RequestBody UpdateBookRequest request)
    {
        validateTitle(request.title());

        return ResponseEntity.of(new UpdateBookCommand().execute(commandContext, id, request.title())
                .map(this::toBookResponse));
    }

    @Transactional
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Integer id)
    {
        if(new DeleteBookCommand().execute(commandContext, id))
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }

    private void validateTitle(String title)
    {
        if(title == null || title.isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book title is required");
    }

    private BookResponse toBookResponse(Book book)
    {
        return new BookResponse(book.getId(), book.getTitle());
    }

    public record CreateBookRequest(String title)
    {
    }

    public record CreateBookResponse(Integer id)
    {
    }

    public record UpdateBookRequest(String title)
    {
    }

    public record BookResponse(Integer id, String title)
    {
    }
}
