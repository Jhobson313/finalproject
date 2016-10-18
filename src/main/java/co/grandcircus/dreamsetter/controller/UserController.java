package co.grandcircus.dreamsetter.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.dreamsetter.dao.UserDaoImpl;
import co.grandcircus.dreamsetter.exception.NotFoundException;
import co.grandcircus.dreamsetter.model.User;

/**
 * Handles requests for pages related to users
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserDaoImpl userDao;
	
	/**
	 * List all users
	 */
	@RequestMapping("/users")
	public String listUsers(Model model, @RequestParam(value = "sort", required = false) String sort) {
		List<User> users;
		
		if (sort == null) {
			users = userDao.getAllUsers();
		} else {
			try {
				users = userDao.getAllUsersSortedBy(sort);
			} catch (IllegalArgumentException ex) {
				logger.warn(ex.getMessage());
				users = userDao.getAllUsers();
			}
		}
		model.addAttribute("users", users);
		

		logger.info("/users -> user-list.jsp");
		return "user-list";
	}
	
	/**
	 * Display one user
	 * @throws NotFoundException 
	 */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String displayUser(@PathVariable int id, Model model) throws NotFoundException {
		model.addAttribute("id", id);
		model.addAttribute("user", userDao.getUser(id));

		logger.info("GET /users/" + id + " -> user.jsp");
		return "user";
	}
	
	/**
	 * Save one user
	 * @throws NotFoundException 
	 */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.POST)
	public String saveUser(@PathVariable int id, User user, Model model) throws NotFoundException {
		userDao.updateUser(id, user);
		model.addAttribute("id", id);
		model.addAttribute("user", user);
		
		logger.info("POST /users/" + id + " -> user.jsp");
		return "user";
	}
	
	/**
	 * Delete one user
	 * @throws NotFoundException 
	 */
	@RequestMapping(value = "/users/{id}/delete", method = RequestMethod.POST)
	public String deleteUser(@PathVariable int id, Model model) throws NotFoundException {
		userDao.deleteUser(id);
		model.asMap().clear();
		
		logger.info("POST /users/" + id + "/delete -> redirect to /users");
		return "redirect:/users";
	}
	
	/**
	 * Display one user
	 */
	@RequestMapping(value = "/users/create", method = RequestMethod.GET)
	public String createUserForm(Model model) {
		model.addAttribute("user", new User());
		
		logger.info("GET /users/create -> user-create.jsp");
		return "user-create";
	}
	
	/**
	 * Save new user
	 */
	@RequestMapping(value = "/users/create", method = RequestMethod.POST)
	public String createUser(User user, Model model) {
		userDao.addUser(user);
		model.asMap().clear();
		
		logger.info("POST /users/create -> redirect to /users");
		return "redirect:/users";
	}
	
}
