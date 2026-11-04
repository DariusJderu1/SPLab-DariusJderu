package sp.self.learning.persistence;

import org.springframework.stereotype.Repository;
import sp.self.learning.persistence.entities.Book;

import java.util.List;
import java.util.Optional;

// Connects our CRUD interface to the Spring Data repository
@Repository
public class BooksRepositoryAdapter implements CrudRepository<Book, Integer>
{
    private final BooksRepository booksRepository;

    public BooksRepositoryAdapter(BooksRepository booksRepository)
    {
        this.booksRepository = booksRepository;
    }

    @Override
    public Book save(Book book)
    {
        return booksRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Integer id)
    {
        return booksRepository.findById(id);
    }

    @Override
    public List<Book> findAll()
    {
        return booksRepository.findAll();
    }

    @Override
    public void delete(Book book)
    {
        booksRepository.delete(book);
    }
}
