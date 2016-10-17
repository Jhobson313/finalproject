package co.grandcircus.dreamsetter.model;

import java.util.Date;

public class Goal extends Deposit {
	
	public class Deposit {
		private Integer depositId;
		private Integer goalId;
		private Double goalAmount;
		private Date startDate;
		private Date dueDate;
		
		
		public Deposit() {
		}

		// Constructor
		public Deposit(Integer depositId, Double goalAmount) {
			}

		public Deposit(Integer depositId, Integer  goalId,
				Double goalAmount, Date startDate,Date dueDate) {
			super();
			this.depositId = depositId;
			this.goalAmount = goalAmount;
			this.startDate = startDate;
			this.dueDate = dueDate;
			this.goalId = goalId;
		}

		public Integer getGoalId() {
			return goalId;
		}

		public void setGoalId(Integer goalId) {
			this.goalId = goalId;
		}

		// getter
		public Integer getDepositId() {
			return depositId;
		}
		
		public void setDepositId(Integer depositId) {
			this.depositId = depositId;
		}

		// getter
		public Double getGoalAmount() {
			return goalAmount;
		}
		
		public void setGoalAmount(Double goalAmount) {
			this.goalAmount = goalAmount;
		}
		
		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getDueDate() {
			return dueDate;
		}

		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
		}


	}


}
