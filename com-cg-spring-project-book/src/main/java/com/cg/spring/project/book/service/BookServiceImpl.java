package com.cg.spring.project.book.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.project.book.exception.BookNotFoundException;
import com.cg.spring.project.book.model.Book;
import com.cg.spring.project.book.model.BookDTO;
import com.cg.spring.project.book.repository.BookRepository;
import com.cg.spring.project.book.repository.UserRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public List<Book> getAllBooks() {
		logger.info("getAllBooks");
		return bookRepository.findAll();
	}

	public Book getBookById(int bookId) {
		Optional<Book> bookOptional = bookRepository.findById(bookId);
		Book book = null;
		if (bookOptional.isPresent()) {
			book = bookOptional.get();
			logger.info(book.toString());
			return book;
		} else {
			String errorMessage = "Book with id " + bookId + " does not exist.";
			logger.error(errorMessage);
			throw new BookNotFoundException(errorMessage);
		}
	}

	public List<Book> getBookByName(String Name) {
		logger.info(Name);
		List<Book> bookList = bookRepository.findByNameIgnoreCase(Name);
		if (null != bookList)
			return bookList.stream().map(book -> new BookDTO());
		String errorMessage = "Book with Name " + Name + " does not exist.";
		throw new BookNotFoundException(errorMessage);
	}

	public Book addBook(Book book) {
		logger.info(Book.toString());
		if (book.getAuthor() != null)

			AuthorService.getAuthorByBookName(book.getAuthor().getBookName());

		return bookRepository.save(book);
	}

	public Book updateBook(Book book) {
		logger.info(Book.toString());
		this.getBookById(Book.getBookId());

		return bookRepository.save(book);
	}

	public Book deleteBook(int id) {
		logger.info(Integer.toString(id));
		Book bookToDelete = this.getBookById(id);
		bookRepository.delete(bookToDelete);
		return bookToDelete;
	}

}
