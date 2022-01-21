package splitStrategy;

import java.util.List;

public class CustomSplit implements SplitStrategy {

	@Override
	public List<Double> calculateShare(Double totalAmount, Integer totalUsers, List<Double> shares) throws Exception {
		Double total = 0d;
		for(Double amount : shares) 
			total+=amount;
		if(!total.equals(totalAmount)) throw new IllegalArgumentException("Sum of Custom amounts("+total+") should be equal to total amount("+totalAmount+")");
		return shares;
	}

}
