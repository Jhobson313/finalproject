package co.grandcircus.dreamsetter.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import co.grandcircus.dreamsetter.model.Deposit;
import co.grandcircus.dreamsetter.model.Goal;

@Service
public class FakeDao {
	/**
	 * Get a list that contains every available deposit.
	 */
	
	public List<Deposit> getDeposits() {
		List<Deposit> deposits = new ArrayList<Deposit>();
		deposits.add(new Deposit(1, 0.0, new Date(2016, 1, 1)));
		deposits.add(new Deposit(2, 10.0, new Date(2016, 1, 7)));
		deposits.add(new Deposit(3, 10.0, new Date(2016, 2, 3)));
		return deposits;

	}

	 
	public static List<Deposit> getDepositAmount(double depositAmount) {
		
		return null;
	}


	public static void addGoal(Goal goal) {
		// TODO Auto-generated method stub
		
	}

}
