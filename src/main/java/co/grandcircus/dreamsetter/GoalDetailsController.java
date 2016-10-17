package co.grandcircus.dreamsetter;

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
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.dreamsetter.dao.FakeDao;
import co.grandcircus.dreamsetter.model.Deposit;

/**
 * Handles requests for this goal's details page.
 */
@Controller
public class GoalDetailsController {
	
	private static final Logger logger = LoggerFactory.getLogger(GoalDetailsController.class);
	
	@Autowired
	private FakeDao fakeDao;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/goaldetails", method = RequestMethod.GET)
	public String goaldetails(Locale locale, Model model) {
		List<Deposit> deposits;
		
		 
			
			deposits = fakeDao.getDeposits();
		
		
		logger.info("Welcome! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		logger.info("/goaldetails -> goaldetails.jsp");
		return "goaldetails";
	}
	
}
