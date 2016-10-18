package co.grandcircus.dreamsetter.model;



import java.util.Date;

/**
 * Responsibility: Hold information about Deposits.
 */
public class Deposit {
	private Integer depositId;
	private Integer  goalId;
	private Double depositAmount;
	private Date currentDate;
	
	public Deposit() {
	}
	// Constructor
	
	public Deposit(Integer depositId, Double depositAmount) {
		}
	
	public Deposit(Integer depositId, Double depositAmount, Date currentDate) {
		super();
		this.depositId = depositId;
		this.depositAmount = depositAmount;
		this.currentDate = currentDate;
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
	
	public void setDepositId(Integer goalId) {
		this.goalId = goalId;
	}

	// getter
	public Double getDepositAmount() {
		return depositAmount;
	}
	
	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}
	
//	public Date getCurrentDate(){
//		return currentDate;
//	}
	
	public java.sql.Date getCurrentDate() {
		return (java.sql.Date) currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	@Override
	public String toString() {
		return "Deposit [depositId=" + depositId + ", goalId=" + goalId + ", depositAmount=" + depositAmount
				+ ", currentDate=" + currentDate + "]";
	}


	}
