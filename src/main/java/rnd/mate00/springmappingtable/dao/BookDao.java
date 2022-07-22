package rnd.mate00.springmappingtable.dao;

import rnd.mate00.springmappingtable.entity.Book;

public interface BookDao {

    Book findBookByTitle(String title);

    Book findBookById(String id);

    Book saveBook(Book book);
}
