package com.udemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.udemy.bean.Book;
import com.udemy.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	/**
	 * 獲取書單列表
	 * @param model
	 * @return
	 */
	@GetMapping("/books")
	public String list(Model model) {
		List<Book> books = bookService.findAll();
		model.addAttribute("books", books);
		return "books";
	}
	
	/**
	 * 獲取書單詳情
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/books/{id}")
	public String detail(@PathVariable long id, Model model) {
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);
		return "book";
	}
}
