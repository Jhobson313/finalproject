package co.grandcircus.dreamsetter.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.grandcircus.dreamsetter.dao.GoalDao;
import co.grandcircus.dreamsetter.model.Goal;

/**
 * Handles requests for the goals dashboard page.
 */
@Controller
public class GoalsDashboardController {
	
	@Autowired
	private GoalDao goalDao;
	
	private static final Logger logger = LoggerFactory.getLogger(GoalsDashboardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/goalsdashboard", method = RequestMethod.GET)
	public String goalsdashboard( Model model) {
		List<Goal> goals;
			
			goals = goalDao.getAllGoals();
			model.addAttribute("goals", goals);

			logger.info("/goalsdashboard -> goalsdashboard.jsp");
			return "goalsdashboard";
	}
	
}
