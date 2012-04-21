package ru.deeper4k.space.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.deeper4k.space.entity.Column;
import ru.deeper4k.space.entity.Project;
import ru.deeper4k.space.entity.Story;
import ru.deeper4k.space.entity.User;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Use this class to reset the database state for the test entities.
 * Execute from command line using : mvnnt -e exec:java -Dexec.mainClass=com.deeper4k.space.util.DataLoadUtil
 * 
 */
public class DataLoadUtil {
	
	private static Logger log = null;
	
	public static void main(String[] args) {
		log = LoggerFactory.getLogger(DataLoadUtil.class);
		
		log.info("Resetting database state");
		resetDatabaseState();
	}

	private static void resetDatabaseState() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exampleHibernateJPA");
		
		EntityManager em = emf.createEntityManager();
		
		log.info("Creating and persisting entity...");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		deleteAllExistingData(em);
		
		populateCannedData(em);
		
		tx.commit();
	}

	private static void populateCannedData(EntityManager em) {
        User user1 = new User();
        user1.setEmail("test1@test.com");
        user1.setPassword("test1");
        user1.setFirstName("test1");
        user1.setLastName("test1");
        em.persist(user1);

        User user2 = new User();
        user2.setEmail("test2@test.com");
        user2.setPassword("test2");
        user2.setFirstName("test2");
        user2.setLastName("test2");
        em.persist(user2);

        Project project = new Project();
        project.setName("Test Project 1");
        project.setOwner(user1);
        project.setMembers(Arrays.asList(user1, user2));
        em.persist(project);

        Column backlogColumn = new Column();
        backlogColumn.setName("Backlog");
        backlogColumn.setPosition(1);
        backlogColumn.setProject(project);
        em.persist(backlogColumn);

        Column inProgressColumn = new Column();
        inProgressColumn.setName("In Progress");
        inProgressColumn.setPosition(2);
        inProgressColumn.setProject(project);
        em.persist(inProgressColumn);

        Column doneColumn = new Column();
        doneColumn.setName("Done");
        doneColumn.setPosition(3);
        doneColumn.setProject(project);
        em.persist(doneColumn);

		Story story = new Story();
        story.setTitle("As a user I'd like to comment my stories");
        story.setDescription("So that I can communicate with a story's owner");
        story.setOwner(user1);
        story.setColumn(backlogColumn);
        story.setPosition(1);
        em.persist(story);

        story = new Story();
        story.setTitle("As a story's owner I'd like to attach files to my stories");
        story.setDescription("So that I can share story's files with a story's developer");
        story.setOwner(user1);
        story.setColumn(inProgressColumn);
        story.setPosition(1);
        em.persist(story);

        story = new Story();
        story.setTitle("As a story's owner I'd like to remove my stories");
        story.setDescription("So that I can remove unnecessary stories");
        story.setOwner(user2);
        story.setColumn(doneColumn);
        story.setPosition(1);
        em.persist(story);

	}

	private static void deleteAllExistingData(EntityManager em) {
		log.info("Deleting existing tables");
		Query storyQuery = em.createQuery("delete from Story");
        storyQuery.executeUpdate();

        Query columnQuery = em.createQuery("delete from Column");
        columnQuery.executeUpdate();
        
        Query projectQuery = em.createQuery("delete from Project");
        projectQuery.executeUpdate();

        Query userQuery = em.createQuery("delete from User");
        userQuery.executeUpdate();
	}
}
