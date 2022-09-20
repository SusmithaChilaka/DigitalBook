package com.cg.service;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.AuthorListRepository;
import com.cg.AuthorRepository;
import com.cg.LoginRepository;
import com.cg.model.Author;
import com.cg.model.Book;
import com.cg.model.User;

@Service
public class AuthorService { 
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	AuthorListRepository repository;
	
	@Autowired
	LoginRepository loginrepository;
	
	
	public Iterable<Book> getBooks(){
		return authorRepository.findAll();
	}
	
	public Book save(@Valid Book books) {
			authorRepository.save(books);
		return books; 
	}

	public Optional<Book> findBookById(Integer id) {
		return authorRepository.findById(id);
	}
	
	public Iterable<Author> getAuthors(){
		return repository.findAll();
	}

	public Author saveAuthor(@Valid Author authors) {
		return repository.save(authors);
	}

	public void deleteBook(Integer id) {
		authorRepository.deleteById(id);
	}
	
	public ResponseEntity<User> userlogin(@RequestBody User userdata) {
		User user = loginrepository.findByUsername(userdata.getUsername());
		if(user.getPassword().equals(userdata.getPassword()))
			return ResponseEntity.ok(user);
		return (ResponseEntity<User>) ResponseEntity.internalServerError();
	} 

	public User register(@Valid User user) {
		return loginrepository.save(user);	
	}
}