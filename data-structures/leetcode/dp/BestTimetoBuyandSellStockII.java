package dp;

//LC-122
public class BestTimetoBuyandSellStockII {

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public int maxProfit(int[] prices) {
        int i = 0, buy, sell, profit = 0, N = prices.length - 1;
        while (i < N) {
            while (i < N && prices[i + 1] <= prices[i]) // find next local minimum
                i++;
            buy = prices[i];

            while (i < N && prices[i + 1] > prices[i]) // find next local maximum
                i++;
            sell = prices[i];

            profit += sell - buy;
        }
        return profit;
    }
}
