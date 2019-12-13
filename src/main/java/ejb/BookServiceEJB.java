package ejb;

import dao.BookDAO;
import dao.exception.BookNotFoundException;
import entity.Book;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Stateless
@LocalBean
public class BookServiceEJB implements BookServiceRemote {

    private final BookDAO bookDAO;

    @Inject
    public BookServiceEJB(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public BookServiceEJB() {
        this.bookDAO = null;
    }

    @Override
    public List<Book> findBooks() {
        return bookDAO.findAll();
    }

    @Override
    public Book createBook(@NotNull Book book) {
        return bookDAO.create(book);
    }

    @Override
    public void deleteBook(@NotNull Book book) {
        bookDAO.delete(book);
    }

    @Override
    public Book updateBook(@NotNull Book book) {
        return bookDAO.update(book);
    }

    @Override
    public Book findById(@NotNull Long id) {
        return Optional.ofNullable(bookDAO.findById(id)).orElseThrow(() -> new BookNotFoundException("Could not find book with id: " + id));
    }
}
