package ensat.dca.dao;

import java.util.List;

public interface IDao<T> {
    boolean create(T o);
    boolean delete(T o);
    boolean update(T o);
    T findById(String id);
    List<T> findAll();
}
