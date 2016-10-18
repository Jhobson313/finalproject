package co.grandcircus.dreamsetter.dao;
import java.util.Date;
import java.util.List;
//import java.util.Set;
import co.grandcircus.dreamsetter.exception.NotFoundException;
import co.grandcircus.dreamsetter.model.Deposit;
import co.grandcircus.dreamsetter.model.Goal;
	/**
	 * Responsibility: To provide access to all the movies.
	 */
	public interface DepositDao {
		
		/**
		 * /**
		 * Get a list that contains all the deposits.
		 * 
		 * @param depositAmount
		 * @return list of matching deposits. An empty list if no match.
		 */
		List<Deposit> getAllDeposits();
		
		/**
		 * Get list of deposits by goal id.
		 * 
		 * @param id numeric ID of the goal
		 * @return the deposit amount
		 * @throws NotFoundException if no such goal exists
		 */
		List<Deposit> getDepositsByGoal(int goalId);

//		/**
//		 * Get list of deposits by depositId
//		 * 
//		 * @param depositAmount
//		 * @return the result total of all deposits for the particular goal
//		 */
	//	Object getDepositAmount(int depositId);
		Deposit getDepositAmount(int depositId);
		
		
		/**
		 * get deposit for a particular goal and display on the /goal details screen
		 * 
		 * @param depositAmount
		 * @return the result total of all deposits for the particular goal
		 */	
		Double getTotalDeposits();
		
		/**
		 * Add the given deposit to the list.
		 * 
		 * @param depositAmount the deposit to add
		 * @return the id of the new deposit
		 */
		int addDeposit(Deposit deposit);
		
		
		/**
		 * Add the given deposit to the list using the deposit amount and current date parms.
		 * 
		 * @param depositAmount the deposit to add
		 * @return the id of the new deposit
		 */	
		int addDeposit(Deposit depositAmount, Date currentDate);
		
		
		/**
		 * Update the specified deposit
		 * 
		 * @param id numeric id identifies the deposit to update
		 * @param depositAmount the new values for the deposit
		 * @throws NotFoundException if the deposit does not exist
		 */
		void updateDeposit(int depositId, Deposit deposit) throws NotFoundException;
		
		
		/**
		 * Delete the specified deposit
		 * 
		 * @param id numeric id identifies the deposit to delete
		 * @throws NotFoundException if the deposit does not exist
		 */
		void deleteDeposit(int depositId) throws NotFoundException;

		static void addGoal(Goal goal) {
			// TODO Auto-generated method stub
			
		}
		
		
	}
