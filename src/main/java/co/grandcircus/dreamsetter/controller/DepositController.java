package co.grandcircus.dreamsetter.controller;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.dreamsetter.dao.DepositDao;
import co.grandcircus.dreamsetter.exception.NotFoundException;
import co.grandcircus.dreamsetter.model.Deposit;


/**
 * @author Administrator - Yolanda Gandy
 * Handles requests for the goal's details page.
 */
@Controller
public class DepositController {
	
	private static final Logger logger = LoggerFactory.getLogger(DepositController.class);
	
	
	@Autowired
	
	private DepositDao depositDao;
	
	/**
	 * DISPLAY TOTAL of DEPOSITS/amounts for ONLY ONE goal 
	 */
	@RequestMapping(value = "/deposit-details", method = RequestMethod.GET)
	public String getTotalDeposits(Model model, @RequestParam (value= "depositAmount", required = false)Double depositAmount){
		
		model.addAttribute("depositAmount", depositDao.getTotalDeposits());
	//	model.addAttribute("depositAmount", depositDao.getAllDeposits());
		
		logger.info("GET /deposit/" + depositAmount + " -> deposit-details.jsp");
		
		return "deposit-details";
	}


	/**
	 * ADD/REDIRECT to save new deposit and display to deposit-details view
	 */
	@RequestMapping(value = "/deposit-details", method = RequestMethod.POST)
		public String createDeposit(Deposit depositAmount, Model model) {
		
		depositAmount.setGoalId(1);
		depositDao.addDeposit(depositAmount);
		
		//model.addAttribute("depositAmount", depositAmount);
		model.asMap().clear();
	
		logger.info("POST /deposit-details -> redirect to /deposit-details");
		return "redirect:/deposit-details";
		
	}
	
}//the end!

	
	
	
	
		
	
	

