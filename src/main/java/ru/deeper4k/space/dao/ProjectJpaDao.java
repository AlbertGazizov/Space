package ru.deeper4k.space.dao;

import ru.deeper4k.space.entity.Project;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: albert
 * Date: 4/21/12
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProjectJpaDao implements ProjectDao {

    /** Entity manager */
    @PersistenceContext
    private EntityManager _em;

    @Override
    public List<Project> getAll() {
        return _em.createQuery("SELECT p FROM Project p").getResultList();
    }

    @Override
    public Project getById(Long aId) {
        return _em.find(Project.class, aId);
    }

    @Override
    public Project create(Project aStory) {
        _em.persist(aStory);
        return aStory;
    }

    @Override
    public void update(Project aStory) {
        _em.merge(aStory);    }

    @Override
    public void remove(Long aId) {
        Project project = getById(aId);
        _em.remove(project);
    }

    @Override
    public void remove(Project aProject) {
        _em.remove(aProject);
    }
}
