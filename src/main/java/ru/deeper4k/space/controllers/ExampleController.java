package ru.deeper4k.space.controllers;

import ru.deeper4k.space.dao.BookDAO;
import ru.deeper4k.space.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ExampleController {
	
	private static Logger log = LoggerFactory.getLogger(ExampleController.class);

	@Inject
	private BookDAO bookDAO;
	
	@RequestMapping(method=RequestMethod.GET, value={"/home"})
	public String showHomePage (ModelAndView mv) {
		log.info("Hit controller");
		
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/listbooks")
	public String listBooks (Model model) {
		List<Book> books = bookDAO.getAllBooks();
		
		model.addAttribute("books", books);
		
		return "listResults";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getbook")
	public String getBook (String title, Model model) {
		List<Book> books = bookDAO.getBooksByTitle(title);
		
		model.addAttribute("books", books);
		
		return "listResults";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/upload")
	public String uploadFile(String description, @RequestParam(value="myFile")MultipartFile uploadedFile, Model model) {
		
		Long fileSize = uploadedFile.getSize();
		log.info("File size received = " + fileSize);
		log.info("Description = " + description);
		
		model.addAttribute("desc", description);
		model.addAttribute("fileSize", fileSize);
		return "uploadSuccess";
	}
}
