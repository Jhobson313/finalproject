package co.grandcircus.dreamsetter.model;



import java.util.Date;

/**
 * Responsibility: Hold information about Deposits.
 */
public class Deposit {
	private Integer depositId;
	private Integer  goalId;
	private Double depositAmount;
	private Date date;
	
	public Deposit() {
	}

	// Constructor
	public Deposit(Integer depositId, Double depositAmount) {
		}

	public Deposit(Integer depositId, Double depositAmount, Date date) {
		super();
		this.depositId = depositId;
		this.depositAmount = depositAmount;
		this.date = date;
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
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	}
