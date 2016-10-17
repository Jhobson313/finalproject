package co.grandcircus.dreamsetter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.grandcircus.dreamsetter.dao.FakeDao;
import co.grandcircus.dreamsetter.model.Goal;

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
		model.addAttribute("goal", new Goal());
		
		logger.info("GET /addgoal -> addgoal.jsp");
		return "addgoal";
	}
	
	/**
	 * Save new user
	 */
	@RequestMapping(value = "/addgoal", method = RequestMethod.POST)
	public String createUser(Goal goal, Model model) {
		FakeDao.addGoal(goal);
		model.asMap().clear();
		
		logger.info("POST /addgoal -> redirect to /users");
		return "redirect:addgoal";
	}
	
	
}
