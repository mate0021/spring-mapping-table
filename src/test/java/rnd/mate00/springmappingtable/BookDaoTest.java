package rnd.mate00.springmappingtable;

import liquibase.repackaged.org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import rnd.mate00.springmappingtable.dao.BookDaoHibernateImpl;
import rnd.mate00.springmappingtable.entity.Book;

import static org.assertj.core.api.Assertions.assertThat;


@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"rnd.mate00.springmappingtable"})
public class BookDaoTest {

    @Autowired
    private BookDaoHibernateImpl bookDao;

    @Test
    public void shouldSaveNewBook() {
        String testTitle = "Go by Example" + RandomStringUtils.randomAlphabetic(10);
        String testAuthor = "Google Developers" + RandomStringUtils.randomAlphabetic(10);
        Book book = new Book(testTitle, testAuthor);

        Book savedBook = bookDao.saveBook(book);

        assertThat(savedBook).isNotNull();
        System.out.println(savedBook.getBookId());
    }

    @Test
    public void shouldFindByTitle() {
        String testTitle = "Title" + RandomStringUtils.randomAlphabetic(10);
        String testAuthor = "Author" + RandomStringUtils.randomAlphabetic(10);
        bookDao.saveBook(new Book(testTitle, testAuthor));

        final Book result = bookDao.findBookByTitle(testTitle);

        assertThat(result).isNotNull();
    }
}
