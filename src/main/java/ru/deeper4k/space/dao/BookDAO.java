package ru.deeper4k.space.dao;

import ru.deeper4k.space.entity.Book;

import java.util.List;

public interface BookDAO {
	
	List<Book> getAllBooks();
	
	List<Book> getBooksByTitle(String title);
	
	Book getBookById(Long id);
}
