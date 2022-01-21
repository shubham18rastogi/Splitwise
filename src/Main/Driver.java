package Main;

import java.util.ArrayList;
import java.util.List;

import model.Expense;
import model.ExpenseType;
import splitStrategy.CustomSplit;
import splitStrategy.EqualSplit;
import splitStrategy.PercentSplit;
import splitwise.Splitwise;

public class Driver {
	public static void main(String[] args) {
		Splitwise splitwise = new Splitwise();
		System.out.println("User created "+splitwise.addUser("Shubham"));
		System.out.println("User created "+splitwise.addUser("Akshika"));
		System.out.println("User created "+splitwise.addUser("Abhinandan"));
		try {
			splitwise.addStrategy(ExpenseType.EQUAL, new EqualSplit());
			splitwise.addStrategy(ExpenseType.PERCENT, new PercentSplit());
			splitwise.addStrategy(ExpenseType.CUSTOM, new CustomSplit());
		} catch (Exception e) {
			System.out.println("Error : "+e);
			e.printStackTrace();
		}
		List<Integer> users;
		List<Double> shares;
		try {
			users = new ArrayList<>();
			users.add(1);
			users.add(2);
			users.add(3);
			shares = new ArrayList<>();
			splitwise.registerExpense(new Expense(ExpenseType.EQUAL, 300d, 1, users, shares));
			users = new ArrayList<>();
			users.add(1);
			users.add(3);
			shares = new ArrayList<>();
			shares.add(50d);
			shares.add(50d);
			splitwise.registerExpense(new Expense(ExpenseType.PERCENT, 300d, 2, users, shares));
			users = new ArrayList<>();
			users.add(1);
			users.add(3);
			shares = new ArrayList<>();
			shares.add(50d);
			shares.add(50d);
			splitwise.registerExpense(new Expense(ExpenseType.CUSTOM, 100d, 2, users, shares));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("User shares : "+splitwise.getBalance());
		//System.out.println("User 1 shares : "+splitwise.getBalance(1));
		//System.out.println("User 2 shares : "+splitwise.getBalance(2));
		//System.out.println("User 3 shares : "+splitwise.getBalance(3));
	}
}
