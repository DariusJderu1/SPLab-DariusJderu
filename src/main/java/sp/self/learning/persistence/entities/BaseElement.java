package sp.self.learning.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

// Makes this class the root of the element entity
@Entity
// Each mapped subclass gets its own table linked to the base table by id
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseElement implements Element
{
    // The generated primary key is shared by all element subclasses
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
}
