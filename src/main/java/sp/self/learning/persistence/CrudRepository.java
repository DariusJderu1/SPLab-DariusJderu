package sp.self.learning.persistence;

import java.util.List;
import java.util.Optional;

// Defines the operations commands need from the persistence layer
public interface CrudRepository<T, ID>
{
    T save(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    void delete(T entity);
}
