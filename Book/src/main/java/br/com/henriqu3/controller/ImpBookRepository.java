package br.com.henriqu3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import br.com.henriqu3.model.Book;
import br.com.henriqu3.model.Review;

@Repository
public class ImpBookRepository implements BookRepository {

	private final List<Book> books = new ArrayList<>();
	
	public ImpBookRepository() {
		Book book = new Book();
		book.setBookId(1);
		book.setIsbn("978-0596805821");
		book.setTitle("REST in Practice: Hypermedia and Systems Architecture");
		List<String> authors = new ArrayList<String>();
		authors.add("Jim Webber");
		authors.add("Savas Parastatidis");
		authors.add("Ian Robinson");
		book.setAuthors(authors);
		
		List<String> keyWords = new ArrayList<String>();
		keyWords.add("Web development & Design Programming");
		keyWords.add("Computer Systems Analysis");
		keyWords.add("Software Architecture");
		book.setKeyWords(keyWords);
		
		book.setPublishYear(2010);
		book.setEdition("1st");
		book.setPublisher("O REILLY");
		book.setBookDescription("In this insightful book, three SOA experts provide a down-to-earth explanation of REST and demonstrate how you can develop simple and elegant distributed hypermedia systems by applying the Web's guiding principles to common enterprise computing problems. You'll learn techniques for implementing specific Web technologies and patterns to solve the needs of a typical company as it grows from modest beginnings to become a global enterprise.");
	
		List<Review> reviews = new ArrayList<Review>();
		Review review = new Review();
		review.setAuthor("Reviewer 1");
		review.setSubject("Great REST / hypermedia architectural book");
		review.setDescription("This is a good introduction how to build a solid REST API and implement hypermedia. ");
		review.setDate("September 14, 2014");
		review.setRating(4);
		reviews.add(review);
		
		Review review2 = new Review();
		review2.setAuthor("Reviewer 2");
		review2.setSubject("Conceptual survey of REST and related technologies...");
		review2.setDescription("This was the right book for me at this time. Using Google to on this REST buzz-word, and the SOAP/WSDL vs. REST  was not enough.");
		review2.setDate("April 26, 2011");
		review2.setRating(5);
		reviews.add(review2);
		
		book.setReviews(reviews);					
		this.books.add(book);	
		
		
		Book book2 = new Book();
		book2.setBookId(2);
		book2.setIsbn("978-0321127426");
		book2.setTitle("Patterns of Enterprise Application Architecture");
		List<String> authors2 = new ArrayList<String>();
		authors2.add(" Martin Fowler ");
		book2.setAuthors(authors2);
		
		List<String> keyWords2 = new ArrayList<String>();
		keyWords2.add("Computer & Technology");
		keyWords2.add("Computer Programming");
		keyWords2.add("Software Development");
		book2.setKeyWords(keyWords2);
		
		book2.setPublishYear(2010);
		book2.setEdition("1st");
		book2.setPublisher("O REILLY");
		book2.setBookDescription("In this insightful book, three SOA experts provide a down-to-earth explanation of REST and demonstrate how you can develop simple and elegant distributed hypermedia systems by applying the Web's guiding principles to common enterprise computing problems. You'll learn techniques for implementing specific Web technologies and patterns to solve the needs of a typical company as it grows from modest beginnings to become a global enterprise.");
	
		List<Review> reviews2 = new ArrayList<Review>();
		Review review3 = new Review();
		review3.setAuthor("Reviewer 3");
		review3.setSubject("Great REST / hypermedia architectural book");
		review3.setDescription("This is a good introduction how to build a solid REST API and implement hypermedia. ");
		review3.setDate("September 14, 2014");
		review3.setRating(2);
		reviews2.add(review3);
		
		Review review4 = new Review();
		review4.setAuthor("Reviewer 4");
		review4.setSubject("Conceptual survey of REST and related technologies...");
		review4.setDescription("This was the right book for me at this time. Using Google to on this REST buzz-word, and the SOAP/WSDL vs. REST  was not enough.");
		review4.setDate("April 26, 2011");
		review4.setRating(3);
		reviews2.add(review4);
		
		book2.setReviews(reviews2);					
		this.books.add(book2);	
		
	}
	
	@Override
	public List<Book> getAll() {
		return this.books;
	}

	@Override
	public Book getById(int id) {
		for (Book book : this.books) {
			if (ObjectUtils.nullSafeEquals(book.getBookId(), id))
				return book;
		}
		
		return null;
	}

	@Override
	public Book getByTitle(String title) {
		for (Book book : this.books) {
			if (ObjectUtils.nullSafeEquals(book.getTitle(), title))
				return book;
		}
		
		return null;
	}

	@Override
	public Book getByISBN(String isbn) {
		for (Book book : this.books) {
			if (ObjectUtils.nullSafeEquals(book.getIsbn(), isbn))
				return book;
		}
		
		return null;
	}

	@Override
	public List<Review> getReviews(String isbn) {
		for (Book book : this.books) {
			if (ObjectUtils.nullSafeEquals(book.getIsbn(), isbn))
				return (List<Review>) book.getReviews();
		}
		
		return null;
	}

	@Override
	public List<Book> getByAuthor(String author) {
		List<Book> list = new ArrayList<Book>();
		for (Book book : this.books) {
			if (book.getAuthors().contains(author))
				list.add(book);
		}
		
		return list;
	}

	@Override
	public List<Book> getByKeyWord(String word) {
		List<Book> list = new ArrayList<Book>();
		for (Book book : this.books) {
			if (book.getKeyWords().contains(word))
				list.add(book);
		}
		
		return list;
	}

}
