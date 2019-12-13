package dao;

import entity.Book;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class BookDAO implements BaseDAO<Book> {

    @PersistenceContext(unitName = "booksPU")
    EntityManager entityManager;

    public BookDAO() {
    }

    @Override
    public Book create(Book entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> query = entityManager.createNamedQuery("Book.findAllBooks", Book.class);
        return query.getResultList();
    }

    @Override
    public void delete(Book entity) {
        entityManager.remove(entity);
    }

    @Override
    public Book update(Book entity) {
        return entityManager.merge(entity);
    }
}
