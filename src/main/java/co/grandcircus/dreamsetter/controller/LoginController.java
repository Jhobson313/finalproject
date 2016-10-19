package co.grandcircus.dreamsetter.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.dreamsetter.exception.NotFoundException;

/**
 * Handles requests for the login page.
 * @param <User>
 */

@Controller
public class LoginController<User> {
	
	@Autowired
	co.grandcircus.dreamsetter.dao.UserDao userDao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submitLoginForm(Model model, HttpSession session, @RequestParam("email") String email, @RequestParam("password") String password) throws NotFoundException {
		co.grandcircus.dreamsetter.model.User user = userDao.getUserByEmailAndPassword(email, password);
		session.setAttribute("currentUser", user);
		
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
