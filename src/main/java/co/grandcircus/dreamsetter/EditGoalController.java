package co.grandcircus.dreamsetter;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.grandcircus.movies.model.User;

/**
 * Handles requests for the add goal page.
 */
@Controller
public class EditGoalController {
	
	private static final Logger logger = LoggerFactory.getLogger(AddGoalController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/addgoal", method = RequestMethod.GET)
	public String createUserForm(Model model) {
		model.addAttribute("depositAmount", new depositAmount());
		
		logger.info("GET /users/create -> user-create.jsp");
		return "user-create";
	}
	
	/**
	 * Save new user
	 */
	@RequestMapping(value = "/users/create", method = RequestMethod.POST)
	public String createUser(User user, Model model) {
		fakeDao.addUser(user);
		model.asMap().clear();
		
		logger.info("POST /users/create -> redirect to /users");
		return "redirect:/users";
	}
	
	
}
