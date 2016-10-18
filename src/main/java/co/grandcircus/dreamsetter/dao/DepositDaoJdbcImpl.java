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
	import co.grandcircus.dreamsetter.model.Deposit;
	
	/**
	 * Provides access to dreamsetter database by connecting to a Deposit table in a SQL database.
	 */
	@Repository
	public class DepositDaoJdbcImpl implements DepositDao {
		
		private static final Logger logger = LoggerFactory.getLogger(DepositDao.class);

		@Autowired
		private JdbcConnectionFactory connectionFactory;

		
		@Override
		public Double getTotalDeposits(){
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
		//return depositAmount;
		}

	@Override
	public List<Deposit> getAllDeposits() {
		String sql = "SELECT * FROM ebdb.deposit_table";
		try (Connection connection = connectionFactory.getConnection();
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql)) {
	
			List<Deposit> deposits = new ArrayList<Deposit>();
			while (result.next()) {
				Integer depositId = result.getInt("deposit_id");
				Double depositAmount  = result.getDouble("deposit_amount");
				Date currentDate = result.getDate("current_date");
	
				deposits.add(new Deposit(depositId, depositAmount, currentDate));
			}
				return deposits;
				
			} catch (SQLException ex) {
				throw new RuntimeException(ex);
			}
	}

//	@Override
//	public List<Deposit> getDepositsByGoal(Int goalID) {
//		String sql = "SELECT * FROM SimpleDeposit WHERE category = ?";
//		try (Connection connection = connectionFactory.getConnection();
//				PreparedStatement statement = connection.prepareStatement(sql)) {
//			statement.setString(1, cat);
//			ResultSet result = statement.executeQuery();
//
//			List<Deposit> Deposits = new ArrayList<Deposit>();
//			while (result.next()) {
//				Integer id = result.getInt("id");
//				String title = result.getString("title");
//				String category = result.getString("category");
//
//				Deposits.add(new Deposit(id, title, category));
//			}
//
//			return Deposits;
//		} catch (SQLException ex) {
//			throw new RuntimeException(ex);
//		}
//	}

//	@Override
//	public Deposit getDeposit(int depositId) throws NotFoundException {
//		String sql = "SELECT * FROM SimpleDeposit WHERE id = ?";
//		try (Connection connection = connectionFactory.getConnection();
//				PreparedStatement statement = connection.prepareStatement(sql)) {
//			statement.setInt(1, depositId);
//			ResultSet result = statement.executeQuery();
//
//			if (result.next()) {
//				String title = result.getString("title");
//				String category = result.getString("category");
//
//				return new Deposit(depositId, depositAmount, date);
//			} else {
//				throw new NotFoundException("No such Deposit.");
//			}
//		} catch (SQLException ex) {
//			throw new RuntimeException(ex);
//		}
//	}

	@Override
	public int addDeposit(Deposit GoalId, Deposit Deposit, Date currentDate) {
		String sql = "INSERT INTO Deposit (goalId, depositAmount, currentDate) VALUES (?, ?, ?)";
		try (Connection connection = connectionFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			statement.setInt(1, Deposit.getGoalId());
			statement.setDouble(2, Deposit.getDepositAmount());
			statement.setDate(3, new java.sql.Date(currentDate.getTime()));

			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Creating Deposit failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					Deposit.setDepositId(generatedKeys.getInt(1));
				} else {
					throw new SQLException("Creating Deposit failed, no ID obtained.");
				}
			}

			return Deposit.getDepositId();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void updateDeposit(int id, Deposit Deposit) throws NotFoundException {
		String sql = "UPDATE SimpleDeposit SET depositAmount = ?, SET goalid = ? WHERE id = ?";
		try (Connection conn = connectionFactory.getConnection();
				PreparedStatement statement = conn
						.prepareStatement(sql)) {
			statement.setDouble(1, Deposit.getDepositAmount());
			statement.setInt(2, Deposit.getGoalId());
			statement.setInt(3, Deposit.getGoalId());

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated != 1) {
				throw new NotFoundException("No such Deposit");
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void deleteDeposit(int id) throws NotFoundException {
		String sql = "DELETE FROM SimpleDeposit WHERE id = ?";
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
	}// end GoalDetailsDao
	
	
	
//		@Override
//		public List<Deposit> getDepositsByGoal(int goal) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
		@Override
		public Deposit getDeposit(int depositId) throws co.grandcircus.dreamsetter.exception.NotFoundException {
			// TODO Auto-generated method stub
			return null;
		}
//
//		@Override
//		public int addDeposit(Deposit deposit) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//
//		@Override
//		public void updateDeposit(int id, Deposit deposit)
//				throws co.grandcircus.dreamsetter.exception.NotFoundException {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void deleteDeposit(int id) throws co.grandcircus.dreamsetter.exception.NotFoundException {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public int addDeposit(Deposit deposit, Date currentDate) {
//			// TODO Auto-generated method stub
//			return 0;
//		}






//		@Override
//		public List<Deposit> getAllDeposits() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
@Override
		public List<Deposit> getDepositsByGoal(int goal) {
			// TODO Auto-generated method stub
			return null;
		}

@Override
public Deposit getDepositAmount(int depositId) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int addDeposit(Deposit deposit) {
	// TODO Auto-generated method stub
	return 0;
}
}
//		@Override
//		public Deposit getDeposit(int depositId) throws NotFoundException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public int addDeposit(Deposit depositAmount, Date currentDate) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//
//		@Override
//		public int addDeposit(Deposit deposit) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//
//		@Override
//		public void updateDeposit(int depositId, Deposit deposit) throws NotFoundException {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void deleteDeposit(int depositId) throws NotFoundException {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public Deposit getDepositAmount(int depositId) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//	}