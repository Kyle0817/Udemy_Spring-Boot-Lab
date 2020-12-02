package com.udemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.bean.Book;
import com.udemy.service.BookService;

@RestController
@RequestMapping("/v1")
public class BookApp {

	@Autowired
	private BookService bookService;

	/**
	 * 獲取讀書清單列表
	 * 
	 * @return
	 */
	@GetMapping("/books")
	public List<Book> getAll() {
		return bookService.findAll();
	}

	/**
	 * 新增一個書單
	 * @return
	 */
	@PostMapping("/books")
	public Book post(Book book) {
		return bookService.save(book);
	}

	/**
	 * 獲取一條書單
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/books/{id}")
	public Book getOne(@PathVariable long id) {
		return bookService.findOne(id);
	}

	/**
	 * 更新一個書單
	 * @param id
	 * @param name
	 * @param author
	 * @param description
	 * @param status
	 * @return
	 */
	@PutMapping("/books")
	public Book update(@RequestParam long id,
					   @RequestParam String name,
					   @RequestParam String author,
					   @RequestParam String description,
					   @RequestParam int status) {
			Book book = new Book();
			book.setId(id);
			book.setName(name);
			book.setAuthor(author);
			book.setDescription(description);
			book.setStatus(status);
		return bookService.save(book);
	}
	
	/**
	 * 刪除一個書單
	 * @param id
	 */
	@DeleteMapping("/books/{id}")
	public void deleteOne(@PathVariable long id) {
		 bookService.delete(id);
	}
	
	@PostMapping("/books/author")
	public List<Book> finByAuthor(@RequestParam String author) {
		return bookService.findByAuthor(author);
	}
	
	@PostMapping("/books/authorAndStatus")
	public List<Book> finByAuthorAndStatus(@RequestParam String author, @RequestParam int status) {
		return bookService.findByAuthorAndStatus(author, status);
	}
	
	@PostMapping("/books/description")
	public List<Book> findByDescription(@RequestParam String description) {
		return bookService.findByDescription(description);
	}
	
	@PostMapping("/books/len")
	public List<Book> findByJPQL(@RequestParam long len) {
		return bookService.findByJPQL(len);
	}
	
	@PostMapping("/books/update")
	public int updateByJPQL(@RequestParam int status, @RequestParam long id) {
		return bookService.updateByJPQL(status, id);
	}
	
	@PostMapping("/books/delete")
	public int deleteByJPQL(@RequestParam long id) {
		return bookService.deleteByJPQL(id);
	}
	
	@PostMapping("/books/updateDel")
	public int updateDelByJPQL(@RequestParam long delId,
							@RequestParam int status,
							@RequestParam long updateId) {
		return bookService.deleteAndUpdate(delId, status, updateId);
	}
}
