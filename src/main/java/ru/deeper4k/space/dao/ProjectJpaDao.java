package ru.deeper4k.space.dao;

import org.springframework.stereotype.Repository;
import ru.deeper4k.space.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Projects DAO JPA implementation
 *
 * @author Albert Gazizov
 */
@Repository
public class ProjectJpaDao implements ProjectDao {

    /** Entity manager */
    @PersistenceContext
    private EntityManager _em;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Project> getAll() {
        return _em.createQuery("SELECT p FROM Project p").getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Project getById(Long aId) {
        return _em.find(Project.class, aId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Project> getByOwnerId(Long aOwnerId) {
        Query query = _em.createQuery("SELECT p FROM Project p WHERE p.owner.id = :ownerId");
        query.setParameter("ownerId", aOwnerId);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Project create(Project aProject) {
        _em.persist(aProject);
        return aProject;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Project aProject) {
        _em.merge(aProject);    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Long aId) {
        Project project = getById(aId);
        _em.remove(project);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Project aProject) {
        _em.remove(aProject);
    }

}
