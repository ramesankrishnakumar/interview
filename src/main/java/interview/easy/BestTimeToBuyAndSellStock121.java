package interview.easy;

public class BestTimeToBuyAndSellStock121 {
	class Solution {
		public int calculateMaxProfitNew(int[] prices) {
			int maxProfits = 0;
			int minPrice = 0;

			if (prices.length > 0)
				minPrice = maxProfits = 0;

			if (prices.length > 1) {
				maxProfits = prices[1] - prices[0];
				minPrice = Math.min(prices[1], prices[0]);
			}

			if (prices.length > 2) {
				for (int i = 2; i < prices.length; i++) {
					maxProfits = Math.max(maxProfits, prices[i] - minPrice);
					minPrice = Math.min(minPrice, prices[i]);
				}
			}
			return maxProfits > 0 ? maxProfits : 0;
		}
	}
}
