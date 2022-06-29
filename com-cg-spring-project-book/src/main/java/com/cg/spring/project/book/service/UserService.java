package com.cg.spring.project.book.service;

	import java.util.List;
	import java.util.Optional;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.cg.spring.project.book.exception.UserAlreadyExistsException;
	import com.cg.spring.project.book.exception.UserNotFoundException;
import com.cg.spring.project.book.model.Book;
import com.cg.spring.project.book.model.User;
	import com.cg.spring.project.book.repository.UserRepository;

	@Service
	public interface UserService {
		
		public List<User> getAllUsers();
			
		public User registerUser(User User); 
			
		public User loginUser(User User);
					
		public String logoutUser(String userName);
			
		public User updateUser(User appUser);
			
		public List<Book> getAllBooks();
		

		public Book getUserById(int userid);
	}
