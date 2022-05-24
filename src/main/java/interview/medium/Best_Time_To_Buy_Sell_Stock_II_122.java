package interview.medium;

public class Best_Time_To_Buy_Sell_Stock_II_122 {
	class Solution {

		public int maxProfit(int[] prices) {
			return solutionApproach(prices);
		}

		@SuppressWarnings("unused")
		private int myApproach(int[] prices) {
			if (prices.length == 1)
				return 0;
			if (prices.length == 2) {
				if (prices[1] > prices[0])
					return prices[1] - prices[0];
				else
					return 0;
			}
			int maxProfit = 0;
			int buyPrice = prices[0];
			int sellPrice = prices[1];

			for (int i = 2; i < prices.length; i++) {
				if (sellPrice > buyPrice && prices[i] > sellPrice) {
					sellPrice = prices[i];
				} else {
					if (sellPrice > buyPrice)
						maxProfit = maxProfit + (sellPrice - buyPrice);
					buyPrice = sellPrice;
					sellPrice = prices[i];
				}
			}
			if (sellPrice > buyPrice)
				maxProfit = maxProfit + (sellPrice - buyPrice);
			return maxProfit;
		}

		private int solutionApproach(int[] prices) {
			int maxProfit = 0;
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > prices[i - 1]) {
					maxProfit += prices[i] - prices[i - 1];
				}
			}

			return maxProfit;
		}
	}
}
