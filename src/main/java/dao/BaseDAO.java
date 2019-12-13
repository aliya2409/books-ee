package dao;

import java.util.List;

public interface BaseDAO<T> {

    T create(T entity);

    T findById(Long id);

    List<T> findAll();

    void delete(T entity);

    T update(T entity);
}
