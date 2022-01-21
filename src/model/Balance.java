package model;

public class Balance {
	Integer userId1;
	Integer userId2;
	Double balance;

	public Balance(Integer userId1, Integer userId2, Double balance) {
		super();
		this.userId1 = userId1;
		this.userId2 = userId2;
		this.balance = balance;
	}

	public Integer getUserId1() {
		return userId1;
	}

	public Integer getUserId2() {
		return userId2;
	}

	public Double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "\nuserId " + userId2 + " owes userId " + userId1 + " a balance of Rs " + balance + "\n";
	}
	
	

}
