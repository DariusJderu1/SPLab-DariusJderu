package sp.self.learning.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// Maps this class to a database table
@Entity
public class Author {
    // @Column explicitly names the database column for each field below
    // Marks this field as the primary key: the unique identifier of each author
    @Id
    // Lets JPA generate the identifier when an author is saved
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


    // JPA needs a no-argument constructor to create objects when loading data
    public Author()
    {
    }

    public Author(String name) {
        this.name = name;
    }


    public String getName()
    {
        return name;
    }

    public void print() {
        System.out.println("Author: " + name);
    }
}
