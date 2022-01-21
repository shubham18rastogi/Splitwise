package splitStrategy;

import java.util.List;

public interface SplitStrategy {
	List<Double> calculateShare(Double totalAmount, Integer totalUsers, List<Double> shares) throws Exception;
}
