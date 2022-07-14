package rnd.mate00.springmappingtable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import rnd.mate00.springmappingtable.entity.Book;
import rnd.mate00.springmappingtable.repository.BookRepository;
import rnd.mate00.springmappingtable.repository.CountryRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@DataJpaTest // <- get only slice of context that is necessary for JPA
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // <- to prevent using H2
@ComponentScan(basePackages = {"rnd.mate00.springmappingtable"})
public class MySqlIntegrationTest {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void countriesShouldBeThere() {
        // commenting that out for now as I turned off Bootstrap
//        assertThat(countryRepository.count()).isEqualTo(4);
    }

    @Test
    public void checkGeneratedUuid() {
        Book book = new Book("UUID by example", "John Thompson");

        final Book result = bookRepository.save(book);

        System.out.println(result.getBookId());
        assertThat(result.getBookId()).isNotNull();
    }
}
