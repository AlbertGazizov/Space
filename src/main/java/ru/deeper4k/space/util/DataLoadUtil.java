package ru.deeper4k.space.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.deeper4k.space.entity.Story;

import javax.persistence.*;

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
		Story story = new Story();
        story.setTitle("As a user I'd like to comment my stories");
        story.setDescription("So that I can communicate with a story's owner");
        em.persist(story);

        story = new Story();
        story.setTitle("As a story's owner I'd like to attach files to my stories");
        story.setDescription("So that I can share story's files with a story's developer");
        em.persist(story);

        story = new Story();
        story.setTitle("As a story's owner I'd like to remove my stories");
        story.setDescription("So that I can remove unnecessary stories");
        em.persist(story);

	}

	private static void deleteAllExistingData(EntityManager em) {
		log.info("Deleting existing stories");
		Query bookQuery = em.createQuery("delete from Story");
		bookQuery.executeUpdate();
	}
}
