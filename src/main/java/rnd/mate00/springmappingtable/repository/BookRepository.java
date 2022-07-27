package rnd.mate00.springmappingtable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rnd.mate00.springmappingtable.entity.Book;

import java.util.UUID;

@Repository
public interface BookRepository {//extends JpaRepository<Book, UUID> {
}
