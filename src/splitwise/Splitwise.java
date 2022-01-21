package splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Balance;
import model.Expense;
import model.ExpenseType;
import model.User;
import splitStrategy.SplitStrategy;

public class Splitwise {
	List<User> activeUsers;
	Map<ExpenseType, SplitStrategy> typeStrategy;

	public Splitwise() {
		super();
		activeUsers = new ArrayList<User>();
		typeStrategy = new HashMap<ExpenseType, SplitStrategy>();
		addUser("Admin");
	}

	public User addUser(String name) {
		User user = new User(activeUsers.size(), name);
		activeUsers.add(user);
		return user;
	}

	public void addStrategy(ExpenseType type, SplitStrategy strategy) throws Exception {
		if (typeStrategy.containsKey(type))
			throw new Exception("Expense type already exist!!");
		typeStrategy.put(type, strategy);
	}

	public List<Balance> getBalance() {
		List<Balance> balances = new ArrayList<>();
		for (User user : activeUsers) {
			Map<Integer, Double> userBalances = user.getBalances();
			for (Integer key : userBalances.keySet()) {
				Double balance = userBalances.get(key);
				if (balance > 0) {
					balances.add(new Balance(user.getUserId(), key, balance));
				}
			}
		}
		return balances;
	}

	public List<Balance> getBalance(Integer userId) {
		List<Balance> balances = new ArrayList<>();
		for (User user : activeUsers) {
			if (user.getUserId().equals(userId)) {
				Map<Integer, Double> userBalances = user.getBalances();
				for (Integer key : userBalances.keySet()) {
					Double balance = userBalances.get(key);
					balances.add(new Balance(user.getUserId(), key, balance));

				}
			}
		}
		return balances;
	}

	public void registerExpense(Expense expense) throws Exception {
		ExpenseType expenseType = expense.getExpenseType();
		SplitStrategy strategy = typeStrategy.getOrDefault(expenseType, null);
		if(strategy == null) throw new Exception("No strategy for given expense type found!!");
		int userCount = expense.getUserIds().size();
		int payingUserId = expense.getPayingUserId();
		List<Double> shares = strategy.calculateShare(expense.getTotalAmount(), userCount, expense.getShares());
		System.out.println("Shares of users : "+shares);
		for(int i=0;i<userCount;i++) {
			int currUser = expense.getUserIds().get(i);
			if(payingUserId != currUser) {
				Double currentBalance = activeUsers.get(payingUserId).getBalances().getOrDefault(currUser, 0.0);
				currentBalance += shares.get(i);
				activeUsers.get(payingUserId).getBalances().put(currUser, currentBalance);
				activeUsers.get(currUser).getBalances().put(payingUserId, -currentBalance);
			}
		}
	}

}
