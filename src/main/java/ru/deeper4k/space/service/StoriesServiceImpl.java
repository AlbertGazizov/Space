package ru.deeper4k.space.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.deeper4k.space.dao.StoryDao;
import ru.deeper4k.space.entity.Story;

import java.util.List;

/**
 * Stories service implementation
 *
 * @author Albert Gazizov
 */
@Service
@Transactional(readOnly = true)
public class StoriesServiceImpl implements StoriesService {

    /** Stories DAO */
    @Autowired
    private StoryDao _storyDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Story> findAll() {
        return _storyDao.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Story findById(Long aId) {
        return _storyDao.findById(aId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Story create(Story aStory) {
        return _storyDao.create(aStory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(Story aStory) {
        _storyDao.update(aStory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void remove(Long aId) {
        _storyDao.remove(aId);
    }
}
