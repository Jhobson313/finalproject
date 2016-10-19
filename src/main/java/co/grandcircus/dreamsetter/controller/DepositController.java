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
 * Handles requests for this goal's details page.
 */
@Controller
public class DepositController {
	
	private static final Logger logger = LoggerFactory.getLogger(DepositController.class);
	
	
	@Autowired
	
	private DepositDao depositDao;
	
	/**
	 * Display Total of deposit amounts for one goal 
	 */
	@RequestMapping(value = "/deposit-details", method = RequestMethod.GET)
	public String getTotalDeposits(Model model, @RequestParam (value= "depositAmount", required = false)Double depositAmount){
		
		model.addAttribute("depositAmount", depositDao.getTotalDeposits());
		
		logger.info("GET /deposit/" + depositAmount + " -> deposit-details.jsp");
		
		return "deposit-details";
	}


	/**
	 * Add/Redirect to save new deposit
	 */
	@RequestMapping(value = "/deposit-details", method = RequestMethod.POST)
	//public String createDeposit(Model model, @RequestParam (value= "depositAmount", required = false)Double depositAmount){
	public String createDeposit(Deposit depositAmount, Model model) {
		depositAmount.setGoalId(1);
		//depositAmount.setCurrentDate("");
		depositDao.addDeposit(depositAmount);
		//model.addAttribute("depositAmount", depositAmount);
		model.asMap().clear();
	
		logger.info("POST /deposit-details -> redirect to /deposit-details.jsp");
		return "redirect:/deposit-details";
		
	}
	
}//the end!

//	/**
//	 * Display one deposit
//	 * @throws Exception 
//	 */
//	@RequestMapping(value = "/deposit-details{depositId}", method = RequestMethod.GET)
//	public String displayDeposit(@PathVariable int depositId, Model model){
//		model.addAttribute("depositId", depositId);
//		model.addAttribute("depositAmount", depositDao.getDepositAmount(depositId));
//		
//		logger.info("GET /deposit/" + depositId + " -> deposit-details.jsp");
//		//logger.info("GET /deposit/" + depositId + " -> goalsdashboard.jsp");
//		return "deposit-details";
//	}
	
	/**
	 * Selects the deposit view and display all deposits
	 *  
	 */
//	double depositAmount = 0;
//	@RequestMapping(value = "/deposit-details", method = RequestMethod.GET)
//	public String listDeposit(Model model, @RequestParam(value="depositAmount")int depositAmount){
//		List<Deposit> deposits;
//		if (depositAmount >0) {
//			deposits = depositDao.getAllDeposits();
//			model.addAttribute("depositAmount", depositAmount);
//		} else {
//			deposits= depositDao.getAllDeposits();
//			//throw new NotFoundException("Must enter an amount");
//		}
//	
//		model.addAttribute("deposits", deposits);
//		
//	logger.info("/deposit -> deposit-details.jsp");
//	return "deposit-details";
//	}
//
	
	
		
	
	

