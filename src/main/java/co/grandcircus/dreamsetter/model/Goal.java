package co.grandcircus.dreamsetter.model;

import java.util.Date;

public class Goal  {	
		
		private Integer goalId;
		private Double goalAmount;
		private Date startDate;
		private Date dueDate;
		private String goalDescription;
				
		// Constructor
		public Goal() {
			}

		public Goal(Double goalAmount, Date startDate,Date dueDate,String goalDescription) {
			super();
			
			this.goalDescription= goalDescription;
			this.goalAmount = goalAmount;
			this.startDate = startDate;
			this.dueDate = dueDate;
			}
		// getter
		
		public Integer getGoalId() {
			return goalId;
		}

		public void setGoalId(Integer goalId) {
			this.goalId = goalId;
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
		public String getGoalDescription() {
			return goalDescription;
		}
		
		public void setGoalDescription(String goalDescription) {
			this.goalDescription = goalDescription;
		}

	}


