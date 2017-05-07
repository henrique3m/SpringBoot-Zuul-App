package br.com.henriqu3.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.henriqu3.model.Book;
import br.com.henriqu3.model.Review;

@Controller
@ExposesResourceFor(Book.class)
public class BookController {
	
	private final BookRepository repository;
		
	public BookController(BookRepository repository) {
		this.repository = repository;
	}
	
	private Resource<Book> getBookResource(Book book) {
		Resource<Book> resource = new Resource<Book>(book);
        resource.add(linkTo(methodOn(BookController.class).getBook(book.getBookId())).withSelfRel());
		return resource;
	}
	
	@GetMapping(path = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
	HttpEntity<List<Resource<Book>>> getBooks() {
			
		List<Book> list = this.repository.getAll();
		List<Resource<Book>> resources = new ArrayList<Resource<Book>>();
		if (list == null)
			return null;
		
		for (Book b: list)
			resources.add(getBookResource(b));
		
		return new ResponseEntity<>(resources, HttpStatus.OK);
	}

	@GetMapping(path = "/books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	HttpEntity<Resource<Book>> getBook(@PathVariable int id) {
		return new ResponseEntity<>(getBookResource(this.repository.getById(id)), HttpStatus.OK);
	}
	
    @RequestMapping("/books/isbn")
    public HttpEntity<Resource<Book>> GetByIsbn(
            @RequestParam(value = "isbn", required = true, defaultValue = "") String isbn) {
        return new ResponseEntity<>(getBookResource(this.repository.getByISBN(isbn)), HttpStatus.OK);
    }
    
    @RequestMapping("/books/title")
    public HttpEntity<Resource<Book>> GetByTitle(
            @RequestParam(value = "title", required = true, defaultValue = "") String title) {
        return new ResponseEntity<>(getBookResource(this.repository.getByTitle(title)), HttpStatus.OK);
    }
    
    @RequestMapping("/books/reviews")
    public HttpEntity<Resources<Review>> GetByReviews(
            @RequestParam(value = "isbn", required = true, defaultValue = "") String isbn) {
    	List<Review> reviews = this.repository.getReviews(isbn);
    	if (reviews == null)
    		return null;
		Resources<Review> resources = new Resources<>(reviews);
		resources.add(linkTo(methodOn(BookController.class).GetByIsbn(isbn)).withSelfRel());
		return new ResponseEntity<>(resources, HttpStatus.OK);
    }
    
    @RequestMapping("/books/author")
	HttpEntity<List<Resource<Book>>> getByAuthor(
	@RequestParam(value = "author", required = true, defaultValue = "") String author) {
			
		List<Book> list = this.repository.getByAuthor(author);
		List<Resource<Book>> resources = new ArrayList<Resource<Book>>();
		if (list == null)
			return null;
		
		for (Book b: list)
			resources.add(getBookResource(b));
		
		return new ResponseEntity<>(resources, HttpStatus.OK);
	}
    
    @RequestMapping("/books/keyword")
	HttpEntity<List<Resource<Book>>> getByKeyWord(
	@RequestParam(value = "word", required = true, defaultValue = "") String word) {
			
		List<Book> list = this.repository.getByKeyWord(word);
		List<Resource<Book>> resources = new ArrayList<Resource<Book>>();
		
		if (list == null)
			return null;
		

		for (Book b: list)
			resources.add(getBookResource(b));
		
		return new ResponseEntity<>(resources, HttpStatus.OK);
	}
}
