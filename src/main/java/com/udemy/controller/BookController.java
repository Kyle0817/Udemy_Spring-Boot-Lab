package com.udemy.controller;

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
	
	@GetMapping("/books")
	public String list() {
		return "TestPage";
	}
	
	@GetMapping("/book/{id}")
	public String detail(@PathVariable long id, Model model) {
		Book book = bookService.findOne(id);
		model.addAttribute("book", book);
		return "book";
	}
}
