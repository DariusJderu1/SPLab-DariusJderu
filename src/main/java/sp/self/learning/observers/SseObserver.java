package sp.self.learning.observers;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import sp.self.learning.persistence.entities.Book;

import java.io.IOException;

public class SseObserver implements Observer
{
    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter)
    {
        this.emitter = emitter;
    }

    @Override
    public void update(Book book)
    {
        try
        {
            emitter.send(book, MediaType.APPLICATION_JSON);
        }
        catch(IOException | IllegalStateException exception)
        {
            emitter.completeWithError(exception);
        }
    }
}
