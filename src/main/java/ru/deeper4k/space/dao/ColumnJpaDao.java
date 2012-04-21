package ru.deeper4k.space.dao;

import org.springframework.stereotype.Repository;
import ru.deeper4k.space.entity.Column;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Columns DAO JPA implementation
 *
 * @author Albert Gazizov
 */
@Repository
public class ColumnJpaDao implements ColumnDao {

    /** Entity manager */
    @PersistenceContext
    private EntityManager _em;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Column> getAll() {
        return _em.createQuery("SELECT p FROM Column p").getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Column getById(Long aId) {
        return _em.find(Column.class, aId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Column> getByProjectId(Long aProjectId) {
        Query query = _em.createQuery("SELECT c FROM Column c WHERE c.project.id = :projectId");
        query.setParameter("projectId", aProjectId);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Column create(Column aColumn) {
        _em.persist(aColumn);
        return aColumn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Column aColumn) {
        _em.merge(aColumn);    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Long aId) {
        Column column = getById(aId);
        _em.remove(column);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Column aColumn) {
        _em.remove(aColumn);
    }
}
