public class BuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        
        if(prices.length == 1)
            return maxProfit;
        
        for(int i=0; i<prices.length-1; i++) {
            // compare the nexy day price
            if(prices[i+1] > prices[i])
                // if the difference is positive
                // add to the profit
                maxProfit+=(prices[i+1] - prices[i]);
        }
        
        return maxProfit;
    }
}