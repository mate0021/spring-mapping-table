package rnd.mate00.springmappingtable.dao;

import org.springframework.stereotype.Component;
import rnd.mate00.springmappingtable.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

@Component
public class BookDaoHibernateImpl implements BookDao {

    private final EntityManagerFactory emf;

    public BookDaoHibernateImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Book findBookByTitle(String title) {
        final EntityManager em = getEntityManager();

        String query = "SELECT b FROM Book b WHERE b.title = :title";
        TypedQuery<Book> q = em.createQuery(query, Book.class);
        q.setParameter("title", title);

        Book result = q.getSingleResult();

        em.close();

        return result;
    }

    @Override
    public Book findBookById(String id) {
        return null;
    }

    @Override
    public Book saveBook(Book book) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        em.persist(book);
        em.flush();                   // <- with those two lines uncommented
        em.getTransaction().commit(); // i would write "physically" to a DB

        em.close();

        return book;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
