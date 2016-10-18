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
				Date dueDate = result.getDate("dueDate");
				Date startDate = result.getDate("startDate");
				Double goalAmount = result.getDouble("goalAmount");

				goal.add(new Goal(goalAmount, startDate, dueDate));
			}

			return goal;
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}

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

	public void updateMovie(int depositAmount, int goalId, Goal goal) throws Exception {
		String sql = "UPDATE AddGoal SET depositAmount = ? WHERE goalid = ?";
		try (Connection conn = ((Statement) connectionFactory).getConnection();
				PreparedStatement statement = conn.prepareStatement(sql)) {

			statement.setInt(1, goal.getGoalId());
			statement.setDouble(2, goal.getGoalAmount());

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated != 1) {
				throw new Exception("No such goal");
			}
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}
