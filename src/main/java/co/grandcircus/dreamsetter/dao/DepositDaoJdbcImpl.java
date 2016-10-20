package co.grandcircus.dreamsetter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.grandcircus.dreamsetter.model.Deposit;
import co.grandcircus.dreamsetter.exception.NotFoundException;

/**
 * @author Administrator, Yolanda Gandy
 * 
 * Provides access to dreamsetter database by connecting to the Deposit table in a
 * MySQL database.
 */
@Repository
public class DepositDaoJdbcImpl implements DepositDao {

	private static final Logger logger = LoggerFactory.getLogger(DepositDao.class);

	@Autowired
	private JdbcConnectionFactory connectionFactory;

	@Override
	public Double getTotalDeposits() {
		String sql = "SELECT SUM(deposit_amount) as 'DEPOSIT' from ebdb.deposit_table";

		Double depositAmount = 0.00;
		try (Connection connection = connectionFactory.getConnection()) {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				depositAmount = result.getDouble("DEPOSIT");
			}
			return depositAmount;

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		// return depositAmount;
	}

	@Override
	public List<Deposit> getAllDeposits() {
		String sql = "SELECT * FROM ebdb.deposit_table";
		try (Connection connection = connectionFactory.getConnection();
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql)) {

			List<Deposit> deposit = new ArrayList<Deposit>();
			while (result.next()) {
				Integer depositId = result.getInt("deposit_id");
				Double depositAmount = result.getDouble("deposit_amount");
				Date currentDate = result.getDate("current_date");

				deposit.add(new Deposit(depositId, depositAmount, currentDate));				
			}
			return deposit;

		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	
	 @Override
	 public Double getDepositAmount(int depositId) {
	 String sql = "SELECT * FROM ebdb.deposit_table WHERE id = ?";
	 Double depositAmount = 0.00;
	 try (Connection connection = connectionFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql)) {
		 	statement.setInt(1, depositId);
		 	ResultSet result = statement.executeQuery();
		 	while (result.next()) {
		 		depositAmount = result.getDouble("deposit_amount"); 
		 	}
		 		return depositAmount;
		 		
	 	} catch (SQLException ex) {
	 		throw new RuntimeException(ex);
	 	}
	}

 
	/** The method java.sql.Date.valueOf(java.lang.String) received a string representing a date in the format yyyy-[m]m-[d]d. e.g.:
		 ps.setDate(2, java.sql.Date.valueOf("2013-09-04");
		 java.util.Date

		 Suppose you have a variable endDate of type java.util.Date, you make the conversion thus:
		 ps.setDate(2, new java.sql.Date(endDate.getTime());
		 Current

		 If you want to insert the current date:
		 ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
		 **********************************************************************************************/	 
	 
	
	@Override
	public Integer addDeposit(Deposit depositAmount) {
		String sql = "INSERT INTO ebdb.deposit_table (goal_id, deposit_amount, `current_date`) VALUES (?,?,?)";
		//String sql = "INSERT INTO ebdb.deposit_table (deposit_amount) VALUES (?)";
		try (Connection connection = connectionFactory.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setInt	(1, depositAmount.getGoalId());
			statement.setDouble	(2, depositAmount.getDepositAmount());
			statement.setDate	(3, new java.sql.Date(System.currentTimeMillis()));
			//statement.setDate(3, depositAmount.getCurrentDate());
			
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Creating Deposit failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					depositAmount.setDepositId(generatedKeys.getInt(1));	
				} else {
					throw new SQLException("Creating Deposit failed, no ID obtained.");
				}
			}

			return depositAmount.getDepositId();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void deleteDeposit(int id) throws NotFoundException {
		String sql = "DELETE FROM Deposit WHERE id = ?";
		try (Connection conn = connectionFactory.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, id);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated != 1) {
				throw new NotFoundException("No such Deposit");
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	@Override
	public List<Deposit> getDepositsByGoal(int goal) {
		// TODO Auto-generated method stub
		return null;
	}

	
}// The End GoalDetailsDao

	// @Override
	// public List<Deposit> getDepositsByGoal(int goal) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public Deposit getDeposit(int depositId) throws
	// co.grandcircus.dreamsetter.exception.NotFoundException {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public int addDeposit(Deposit deposit) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// @Override
	// public void updateDeposit(int id, Deposit deposit)
	// throws co.grandcircus.dreamsetter.exception.NotFoundException {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public void deleteDeposit(int id) throws
	// co.grandcircus.dreamsetter.exception.NotFoundException {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// @Override
	// public int addDeposit(Deposit deposit, Date currentDate) {
	// // TODO Auto-generated method stub
	// return 0;
	// }

	// @Override
	// public List<Deposit> getAllDeposits() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	

//}
// @Override
// public Deposit getDeposit(int depositId) throws NotFoundException {
// // TODO Auto-generated method stub
// return null;
// }
//
// @Override
// public int addDeposit(Deposit depositAmount, Date currentDate) {
// // TODO Auto-generated method stub
// return 0;
// }
//
// @Override
// public int addDeposit(Deposit deposit) {
// // TODO Auto-generated method stub
// return 0;
// }
//
// @Override
// public void updateDeposit(int depositId, Deposit deposit) throws
// NotFoundException {
// // TODO Auto-generated method stub
//
// }
//
// @Override
// public void deleteDeposit(int depositId) throws NotFoundException {
// // TODO Auto-generated method stub
//
// }
//
// @Override
// public Deposit getDepositAmount(int depositId) {
// // TODO Auto-generated method stub
// return null;
// }
//
// }