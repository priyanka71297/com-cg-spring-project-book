package com.cg.spring.project.book.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.spring.project.book.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

	public abstract Optional<Book> findById(int bookId);

	public abstract List<Book> findByBookName(String bookName);

	public abstract List<Book> findByAuthorName(String author);

	public abstract List<Book> findByCategory(String category);

	public abstract List<Book> findByRating(String rating);

	public abstract List<Book> findByNameIgnoreCase(String name);
}