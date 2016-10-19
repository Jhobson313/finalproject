package co.grandcircus.dreamsetter.dao;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import co.grandcircus.dreamsetter.exception.NotFoundException;
import co.grandcircus.dreamsetter.model.User;

/**
 * Responsibility: To provide access to all the users.
 */
@Repository
public class UserDaoImpl implements UserDao {
	
	private int nextId = 1;

	private List<User> users = new ArrayList<User>();

	// Constructor
	public UserDaoImpl() {
		users.add(new User("James", "Hobson", "james-hobson@att.net", "james"));
		users.add(new User("Yolanda", "Gandy", "Ygandy@gmail.com", "Yoyo"));
		users.add(new User("Lame", "Duck", "lame@example.com", "quack"));
		for (User user : users) {
			assignId(user);
		}
	}
	
	/**
	 * Get all the users from the array list... every single one.
	 */
	@Override
	public List<User> getAllUsers() {
		return users;
	}
	
	@Override
	public List<User> getAllUsersSortedBy(String sortOrder) throws IllegalArgumentException {
		switch (sortOrder) {
		case "firstName":
			return users.stream().sorted(Comparator.comparing(User::getFirstName)).collect(Collectors.toList());
		case "lastName":
			return users.stream().sorted(Comparator.comparing(User::getLastName)).collect(Collectors.toList());
		case "email":
			return users.stream().sorted(Comparator.comparing(User::getEmail)).collect(Collectors.toList());
		default:
			throw new IllegalArgumentException("users sortOrder cannot be " + sortOrder);	
		}
	}

	@Override
	public User getUser(int id) throws NotFoundException {
		int index = findUser(id);
		return users.get(index);
	}
	
	
	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		for (User user : users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		try {
			throw new Exception("No user " + email + " with given password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addUser(User user) {
		assignId(user);
		users.add(user);
		return user.getId();
	}

	@Override
	public void updateUser(int id, User user) throws NotFoundException {
		int index = findUser(id);
		user.setId(id);
		users.set(index, user);
	}
	
	@Override
	public void deleteUser(int id) throws NotFoundException {
		int index = findUser(id);
		users.remove(index);
	}
	
	/**
	 * Returns the list index of the user with the given ID.
	 * 
	 * @return zero-based index
	 * @throws NotFoundException if no user found with given ID
	 */
	private int findUser(int id) throws NotFoundException {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				return i;
			}
		}
		throw new NotFoundException("No user " + id);
	}
	
	private void assignId(User user) {
		user.setId(nextId++);
	}
	
	
}
