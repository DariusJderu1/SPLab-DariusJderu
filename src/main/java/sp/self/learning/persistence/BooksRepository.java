package sp.self.learning.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sp.self.learning.persistence.entities.Book;

@Repository
// Spring Data provides CRUD operations for Book entities with Integer ids
public interface BooksRepository extends JpaRepository<Book, Integer>
{
}
