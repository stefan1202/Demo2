package ro.sda.java64.demo2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ro.sda.java64.demo2.entities.BookEntity;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
    List<BookEntity> findAllByAuthorStartingWith(String author);
}
