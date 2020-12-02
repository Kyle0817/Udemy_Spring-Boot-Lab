package com.udemy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.bean.Book;
import com.udemy.dao.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	/**
	 * 查詢所有的書單列表
	 * @return
	 */
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
	
	/**
	 * 獲取一條書單訊息
	 * @param id
	 * @return
	 */
	public Book findOne(long id) {
		return bookRepository.findById(id).get();
	}
	
	/**
	 * 提交一個書單訊息
	 * @param book
	 * @return
	 */
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	/**
	 * 刪除一條書單訊息
	 * @param id
	 */
	public void delete(long id) {
		 bookRepository.deleteById(id);
	}
	
	/**
	 * 根據author查詢一個書單列表
	 * @param author
	 * @return
	 */
	public List<Book> findByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}
	
	/**
	 * 根據author and status 查詢一個書單列表
	 * @param author
	 * @return
	 */
	public List<Book> findByAuthorAndStatus(String author, int status) {
		return bookRepository.findByAuthorAndStatus(author, status);
	}
	
	/**
	 * 
	 * @param description
	 * @return
	 */
	public List<Book> findByDescription(String description) {
		return bookRepository.findByDescriptionEndsWith(description);
	}
	
	/**
	 * 自定義查詢
	 * @param len
	 * @return
	 */
	public List<Book> findByJPQL(long len) {
		return bookRepository.findByJPQL(len);
	}
	
	/**
	 * 自定義更新
	 * @param status
	 * @param id
	 * @return
	 */
	@Transactional
	public int updateByJPQL(int status, long id) {
		return bookRepository.updateByJPQL(status, id);
	}
	
	/**
	 * 自定義刪除
	 * @param id
	 * @return
	 */
	@Transactional
	public int deleteByJPQL(long id) {
		return bookRepository.deleteByJPQL(id);
	}
	
	@Transactional
	public int deleteAndUpdate(long delId, int status, long updateId) {
		int delCount = bookRepository.deleteByJPQL(delId);
		int updateCount = bookRepository.updateByJPQL(status, updateId);
		
		return updateCount + delCount;
	}
}
