package ejb;

import entity.Book;

import javax.ejb.Remote;
import javax.validation.constraints.NotNull;
import java.util.List;

@Remote
public interface BookServiceRemote {

    List<Book> findBooks();

    Book createBook(@NotNull Book book);

    void deleteBook(@NotNull Book book);

    Book updateBook(@NotNull Book book);

    Book findById(@NotNull Long id);
}
