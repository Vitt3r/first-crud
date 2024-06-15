package br.com.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entities.User;
import br.com.entities.DTOs.UserDTO;
import br.com.repositories.UserRepository;
import br.com.services.exceptions.InvalidUserException;
import br.com.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	public List<User> listAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		try{
		return repository.findById(id).orElseThrow();
		}
		catch(NoSuchElementException e) {
			throw new ResourceNotFoundException("User not found id " + id);
		}
	}
	
	//implementar uma verificação de email
	public User create(User user){
		if(user.getEmail() != null && user.getName() != null && user.getHeight() != null) {
			return repository.save(user);	
		}
		else {
			throw new InvalidUserException("Name, email and height must be informed");
		}	
	}
	
	public User updateName(UserDTO obj, Long id){
		if(repository.existsById(id) == true) {
			User user = repository.findById(id).get();
			user.setName(obj.getName());
			return repository.save(user);
		}
		else {
			throw new ResourceNotFoundException("User not found id " + id);
		}
	}
	
	public User updateEmail(UserDTO obj, Long id){
		if(repository.existsById(id) == true) {
			User user = repository.findById(id).get();
			user.setEmail(obj.getEmail());
			return repository.save(user);
		}
		else {
			throw new ResourceNotFoundException("User not found id " + id);		}
	}
	
	public User updateHeight(UserDTO obj, Long id){
		if(repository.existsById(id) == true) {
			User user = repository.findById(id).get();
			user.setHeight(obj.getHeight());
			return repository.save(user);
		}
		else {
			throw new ResourceNotFoundException("User not found id " + id);
		}
	}
	
	public void delete(Long id){
		if(repository.existsById(id) == true) {
			repository.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("User not found id " + id);
		}
	}
	
}
