package com.example.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.dto.UserDTO;
import com.example.workshopmongo.repository.UserRepository;
import com.example.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findBy(String id) {
		Optional<User> user= userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return userRepository.insert(obj);				
	}
	
	public void delete(String id) {
		this.findBy(id);
		userRepository.deleteById(id);
	}
	
	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
	public User update(User user) {
		Optional<User> obj = userRepository.findById(user.getId());
		updateData(obj, user);
		return userRepository.save(obj.get());
	}

	private void updateData(Optional<User> obj, User user) {
		
		obj.get().setName(user.getName());
		obj.get().setEmail(user.getEmail());
		
	}

}
