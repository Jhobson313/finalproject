package co.grandcircus.dreamsetter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.NestedCheckedException;
import org.springframework.stereotype.Repository;

import co.grandcircus.dreamsetter.exception.NotFoundException;
import co.grandcircus.dreamsetter.model.Deposit;
import co.grandcircus.dreamsetter.model.Goal;

@Primary
@Repository
public class GoalDao {

	private static final Logger logger = LoggerFactory.getLogger(Goal.class);

	@Autowired
	private JdbcConnectionFactory connectionFactory;
	
	
    
	public List<Goal> getAllGoals() {
		String sql = "SELECT * from goals_table";

		try (Connection connection = (connectionFactory).getConnection();
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql)) {

			List<Goal> goal = new ArrayList<Goal>();
			while (result.next()) {
				Date dueDate = result.getDate("due_Date");
				Date startDate = result.getDate("start_Date");
				Double goalAmount = result.getDouble("goal_Amount");
				String goalDescription= result.getString("goal_description");
				
				goal.add(new Goal(goalAmount, startDate, dueDate, goalDescription));
			}

			return goal;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

	public double addGoal(Goal goal) {
		String sql = "INSERT INTO AddGoal (goalAmount, goalDescription , startDate, dueDate) VALUES (?, ?, ? ,?)";
		try (Connection connection = (connectionFactory).getConnection();
				PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			java.sql.Date sqlstartDate = goal.getStartDate()==null ? null : new java.sql.Date(goal.getStartDate().getTime());
			java.sql.Date sqldueDate = goal.getDueDate()==null ? null : new java.sql.Date(goal.getDueDate().getTime());
			statement.setDouble(1, goal.getGoalAmount());
			statement.setString(2, goal.getGoalDescription());
			statement.setDate(3,  sqlstartDate);
			statement.setDate(4, sqldueDate);
			
			
			
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Creating goal failed, no rows affected.");
			}
			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					goal.setGoalId(generatedKeys.getInt(1));
				} else {
					throw new SQLException("Creating goal failed, no ID obtained.");
				}
			}

			return goal.getGoalId();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}
