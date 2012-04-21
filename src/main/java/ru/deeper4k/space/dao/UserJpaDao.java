package ru.deeper4k.space.dao;

import org.springframework.stereotype.Repository;
import ru.deeper4k.space.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Users DAO JPA implementation
 *
 * @author Albert Gazizov
 */
@Repository
public class UserJpaDao implements UserDao {

    /** Entity manager */
    @PersistenceContext
    private EntityManager _em;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAll() {
        return _em.createQuery("SELECT p FROM User p").getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getById(Long aId) {
        return _em.find(User.class, aId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User create(User aUser) {
        _em.persist(aUser);
        return aUser;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(User aUser) {
        _em.merge(aUser);    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Long aId) {
        User user = getById(aId);
        _em.remove(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(User aUser) {
        _em.remove(aUser);
    }
}
