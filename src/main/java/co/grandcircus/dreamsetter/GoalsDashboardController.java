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

/**
 * Handles requests for the goals dashboard page.
 */
@Controller
public class GoalsDashboardController {
	
	private static final Logger logger = LoggerFactory.getLogger(GoalsDashboardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/goalsdashboard", method = RequestMethod.GET)
	public String goalsdashboard(Locale locale, Model model) {
		logger.info("Welcome! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "/goalsdashboard";
	}
	
}
