package ru.deeper4k.space.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String title;
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	private Author author;
	
	private Date publicationDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	
}
