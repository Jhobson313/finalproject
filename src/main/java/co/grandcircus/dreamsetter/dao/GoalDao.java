package co.grandcircus.dreamsetter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import co.grandcircus.dreamsetter.model.Deposit;
import co.grandcircus.dreamsetter.model.Goal;

public class GoalDao<JdbcConnectionFactory> extends Goal {
	
	private static final Logger logger = LoggerFactory.getLogger(Goal.class);

	
	@Autowired
	private JdbcConnectionFactory connectionFactory;

	
	public int addGoal(Goal goal) {
		String sql = "INSERT INTO AddGoal (goalAmount, goalId) VALUES (?, ?)";
		try (Connection connection = ((Statement) connectionFactory).getConnection();
				PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Creating movie failed, no rows affected.");
			}

			try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					goal.setGoalId(generatedKeys.getInt(1));
				} else {
					throw new SQLException("Creating movie failed, no ID obtained.");
				}
			}

			return goal.getGoalId();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}


}
