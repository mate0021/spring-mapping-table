package rnd.mate00.springmappingtable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import rnd.mate00.springmappingtable.entity.AuthorNameKey;
import rnd.mate00.springmappingtable.entity.AuthorWithCompositeKey;
import rnd.mate00.springmappingtable.entity.Book;
import rnd.mate00.springmappingtable.repository.AuthorCompositeRepository;
import rnd.mate00.springmappingtable.repository.BookRepository;
import rnd.mate00.springmappingtable.repository.CountryRepository;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test suite runs on "local" profile, meaning, it will connect to
 * Docker MySql container. If there is a data in the tables, tests may
 * give unexpected results.
 */
@ActiveProfiles("local")
@DataJpaTest // <- get only slice of context that is necessary for JPA
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // <- to prevent using H2
@ComponentScan(basePackages = {"rnd.mate00.springmappingtable"})
public class MySqlIntegrationTest {
/*
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorCompositeRepository authorCompositeRepository;*/


    @Test
    public void countriesShouldBeThere() {
        // commenting that out for now as I turned off Bootstrap
//        assertThat(countryRepository.count()).isEqualTo(4);
    }

    /*@Test
    public void checkGeneratedUuid() {
        Book book = new Book("UUID by example", "John Thompson");

        final Book result = bookRepository.save(book);

        System.out.println(result.getBookId());
        assertThat(result.getBookId()).isNotNull();
    }

    @Test
    public void checkCompositeKey() {
        AuthorNameKey nameKey = new AuthorNameKey("John", "Thompson");
        AuthorWithCompositeKey author = new AuthorWithCompositeKey(nameKey, "USA");

        final AuthorWithCompositeKey result = authorCompositeRepository.save(author);
        final AuthorWithCompositeKey result2 = authorCompositeRepository.save(new AuthorWithCompositeKey(nameKey, "Poland"));

        assertThat(authorCompositeRepository.count()).isEqualTo(1);
        System.out.println(authorCompositeRepository.findAll());
    }*/
}
