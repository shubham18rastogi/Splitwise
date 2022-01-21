package model;

import java.util.HashMap;
import java.util.Map;

public class User {
	Integer userId;
	String userName;
	Map<Integer, Double> balances;

	public User() {
		super();
	}

	public User(Integer userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.balances = new HashMap<>();
	}

	public static boolean validUser(User user) {
		// TODO check if all required values are present
		return true;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<Integer, Double> getBalances() {
		return balances;
	}

	public void setBalances(Map<Integer, Double> balances) {
		this.balances = balances;
	}

	public Integer getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "[userId=" + userId + ", userName=" + userName + "]";
	}

}
