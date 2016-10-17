package co.grandcircus.dreamsetter.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.grandcircus.dreamsetter.model.Goal;


/**
 * Handles requests for the add goal page.
 */
@Controller
public class AddGoalController {
	
	private static final Logger logger = LoggerFactory.getLogger(AddGoalController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/addgoal", method = RequestMethod.GET)
	public String addGoal(Goal goal, Model model) {
		
		model.addAttribute("goal",new Goal() );
		
		return "addgoal";
	}
	
}
