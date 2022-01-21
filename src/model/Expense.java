package model;

import java.util.List;

//No setters to make object immutable
public class Expense {
	private ExpenseType expenseType;
	private Double totalAmount;
	private Integer payingUserId;
	private List<Integer> userIds; // We can take complete user object instead of id
	private List<Double> shares; // will be null for equal

	public Expense() {
		super();
	}

	public Expense(ExpenseType expenseType, Double totalAmount, Integer payingUserId, List<Integer> userIds,
			List<Double> shares) {
		super();
		this.expenseType = expenseType;
		this.totalAmount = totalAmount;
		this.payingUserId = payingUserId;
		this.userIds = userIds;
		this.shares = shares;
	}

	public ExpenseType getExpenseType() {
		return expenseType;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public Integer getPayingUserId() {
		return payingUserId;
	}

	public List<Integer> getUserIds() {
		return userIds;
	}

	public List<Double> getShares() {
		return shares;
	}

}
