package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBooks;
import com.bookStore.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bService;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/bookregister")
	public String registerBook()
	{
		return "bookRegister";
	}
	
	@GetMapping("/availablebooks")
	public ModelAndView getAllBooks()
	{
		List<Book> list=bService.getAllBooks();
		return new ModelAndView("bookList","book",list);
	}
	
	@GetMapping("/mybooks")
	public ModelAndView myBooks()
	{
		List<MyBooks> list=bService.getMyBooks();
		return new ModelAndView("myBooks","MyBook",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b)
	{
		bService.save(b);
		return "redirect:/availablebooks";
	}
	
	@RequestMapping("/add/{id}")
	public String getMyBooks(@PathVariable("id") int id)
	{
		Book b=bService.findBookById(id);
		MyBooks my=new MyBooks(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		bService.addMyBook(my);
		return "redirect:/mybooks";
	}
	@RequestMapping("/delete/{id}")
	public String deleteMyBooks(@PathVariable("id") int id)
	{
		bService.deleteMyBook(id);
		return "redirect:/mybooks";
	}
}
