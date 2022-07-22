package rnd.mate00.springmappingtable.dao;

import org.springframework.stereotype.Component;
import rnd.mate00.springmappingtable.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
public class BookDaoHibernateImpl implements BookDao {

    private final EntityManagerFactory emf;

    public BookDaoHibernateImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Book findBookByTitle(String title) {
        return null;
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
//        em.flush();                   // <- with those two lines uncommented
//        em.getTransaction().commit(); // i would write "physically" to a DB

        em.close();

        return book;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
