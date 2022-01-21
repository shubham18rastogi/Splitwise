package splitStrategy;

import java.util.ArrayList;
import java.util.List;

public class EqualSplit implements SplitStrategy {

	@Override
	public List<Double> calculateShare(Double totalAmount, Integer totalUsers, List<Double> shares) {
		List<Double> shareAmount = new ArrayList<>();
		Double amount = totalAmount / totalUsers;
		for(int i=0;i< totalUsers;i++) {
			shareAmount.add(amount);
		}
		return shareAmount;
	}

}
