package com.udemy.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.udemy.bean.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByAuthor(String author);
	
	List<Book> findByAuthorAndStatus(String author, int status);
	
	List<Book> findByDescriptionEndsWith(String description);
	
//	@Query("select b from Book b where len(b.name) > ?1")
	@Query(value = "select * from book where len(name) > ?1", nativeQuery = true)
	List<Book> findByJPQL(long len);
	
	@Transactional
	@Modifying
	@Query("update Book set status = ?1 where id = ?2")
	int updateByJPQL(int status, long id);
	
	@Transactional
	@Modifying
	@Query("delete from Book where id = ?1")
	int deleteByJPQL(long id);
}
