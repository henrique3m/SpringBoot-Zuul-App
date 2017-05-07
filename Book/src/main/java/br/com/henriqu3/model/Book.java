package br.com.henriqu3.model;

import java.util.Collection;


public class Book {
	int bookId;
	String isbn;
	String title;
	Collection<String> authors;
	Collection<String> keyWords;
	Collection<Review> reviews;
	int publishYear;
	String edition;
	String publisher;
	String bookDescription;

	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Collection<String> getAuthors() {
		return authors;
	}
	public void setAuthors(Collection<String> authors) {
		this.authors = authors;
	}
	public Collection<String> getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(Collection<String> keyWords) {
		this.keyWords = keyWords;
	}
	public Collection<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Collection<Review> reviews) {
		this.reviews = reviews;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
}
