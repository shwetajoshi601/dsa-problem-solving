public class BuyAndSellStockII {
    public int maxProfit(int[] prices) {
        // take sum of profits in consecutive transactions
        int maxProfit=0;
        
        for(int i=0; i<prices.length-1; i++) {
            // compare the next day price
            if(prices[i+1] > prices[i])
                // if the difference is positive
                // add to the profit
                maxProfit+=(prices[i+1] - prices[i]);
        }
        
        return maxProfit;
    }
}