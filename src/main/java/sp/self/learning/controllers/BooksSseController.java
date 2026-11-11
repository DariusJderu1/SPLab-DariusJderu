package sp.self.learning.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import sp.self.learning.observers.AllBooksSubject;
import sp.self.learning.observers.SseObserver;

@RestController
public class BooksSseController
{
    private final AllBooksSubject allBooksSubject;

    public BooksSseController(AllBooksSubject allBooksSubject)
    {
        this.allBooksSubject = allBooksSubject;
    }

    @GetMapping("/books-sse")
    public ResponseBodyEmitter getBooksSse()
    {
        final SseEmitter emitter = new SseEmitter(0L);

        SseObserver observer = new SseObserver(emitter);

        // Remove this observer when Spring detects that its connection has ended.
        emitter.onCompletion(() -> allBooksSubject.detach(observer));
        emitter.onTimeout(() -> allBooksSubject.detach(observer));
        emitter.onError(exception -> allBooksSubject.detach(observer));

        allBooksSubject.attach(observer);

        return emitter;
    }
}
