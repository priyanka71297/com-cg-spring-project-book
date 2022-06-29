package com.cg.spring.project.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_Id")
	private int bookId;

	@Column(name = "book_name")
	private String bookName;

	@ManyToMany
	@JoinColumn(name = "author_name")
	private Author author;

	@Column(name = "catgory")
	private String category;

	@Column(name = "rating")
	private float rating;

	public Book() {
		super();
	}

	public Book(int bookId, String bookName, Author author, String category, float rating) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.category = category;
		this.rating = rating;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book [BookId = " + bookId + ", BookName = " + bookName + ", Author = " + author + ", Category = "
				+ category + ", Rating = " + rating + "]";
	}
}