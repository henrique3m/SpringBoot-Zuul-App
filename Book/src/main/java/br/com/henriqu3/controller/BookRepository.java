package br.com.henriqu3.controller;

import java.util.List;

import br.com.henriqu3.model.Book;
import br.com.henriqu3.model.Review;

public interface BookRepository {
	List<Book> getAll();
	Book getById(int id);
	Book getByTitle (String title);
	Book getByISBN (String isbn);
	List<Review> getReviews (String isbn);
	List<Book> getByAuthor (String author);
	List<Book> getByKeyWord (String word);
}
