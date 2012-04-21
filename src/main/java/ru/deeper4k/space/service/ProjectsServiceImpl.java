package ru.deeper4k.space.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.deeper4k.space.dao.ProjectDao;
import ru.deeper4k.space.dao.StoryDao;
import ru.deeper4k.space.entity.Project;
import ru.deeper4k.space.entity.Story;

import java.util.List;

/**
 * Stories service implementation
 *
 * @author Albert Gazizov
 */
@Service
@Transactional(readOnly = true)
public class ProjectsServiceImpl implements ProjectsService {

    /** Stories DAO */
    @Autowired
    private StoryDao _storyDao;

    /** Stories DAO */
    @Autowired
    private ProjectDao _projectDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Project> getProjectsByUserId(Long aUserId) {
        return _projectDao.getByOwnerId(aUserId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Project getProjectById(Long aId) {
        return _projectDao.getById(aId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Project createProject(Project aProject) {
        return _projectDao.create(aProject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateProject(Project aProject) {
        _projectDao.update(aProject);    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void removeProject(Long aId) {
        _projectDao.remove(aId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Story> getStories() {
        return _storyDao.getAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Story getStoryById(Long aId) {
        return _storyDao.getById(aId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Story createStory(Story aStory) {
        return _storyDao.create(aStory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateStory(Story aStory) {
        _storyDao.update(aStory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void removeStory(Long aId) {
        _storyDao.remove(aId);
    }
}
