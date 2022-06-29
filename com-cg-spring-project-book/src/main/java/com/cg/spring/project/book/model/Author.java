package com.cg.spring.project.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue
	@Column(name = "author_Id")
	private int authorId;

	@Column(name = "book_name")
	private String bookName;

	@Column(name = "author_name")
	private String authorName;

	@Column(name = "category")
	private String category;

	public Author() {
		super();
	}

	public Author(int authorId, String bookName, String authorName, String category) {
		super();
		this.authorId = authorId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.category = category;

	}

	public String getBookName() {
		return bookName;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Author [authorId = " + authorId + ", bookName = " + bookName + ", authorName = " + authorName
				+ ", Category = " + category + "]";
	}

}
