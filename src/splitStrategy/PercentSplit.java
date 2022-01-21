package splitStrategy;

import java.util.ArrayList;
import java.util.List;

public class PercentSplit implements SplitStrategy {

	@Override
	public List<Double> calculateShare(Double totalAmount, Integer totalUsers, List<Double> percentages) throws Exception {
		Double total = 0d;
		List<Double> percentShares = new ArrayList<>();		
		for(Double percentShare : percentages) {
			total+=percentShare;
			percentShares.add((totalAmount/100)*percentShare);
		}
		if(!total.equals(100d)) throw new IllegalArgumentException("Sum of percentages("+total+") should be equal to 100");
		return percentShares;
	}

}
