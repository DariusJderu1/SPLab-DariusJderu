package sp.self.learning.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sp.self.learning.persistence.entities.Author;

@Repository
// Spring Data provides CRUD operations for Author entities with Integer ids
public interface AuthorsRepository extends JpaRepository<Author, Integer>
{
}
