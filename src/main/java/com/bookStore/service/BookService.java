package com.bookStore.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBooks;
import com.bookStore.repository.BookRepository;
import com.bookStore.repository.MyBookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private MyBookRepository myRepo;
	
	public void save(Book b)
	{
		bookRepo.save(b);
	}
	
	public List<Book> getAllBooks()
	{
		return bookRepo.findAll();
	}
	
	public List<MyBooks> getMyBooks()
	{
		return myRepo.findAll();
	}
	public void addMyBook(MyBooks b)
	{
		myRepo.save(b);
	}
	public Book findBookById(int id)
	{
		return bookRepo.findById(id).get();
	}
	public void deleteMyBook(int id)
	{
		myRepo.deleteById(id);
	}
}
