class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        // for buying price
        for(int i=0; i< prices.length; i++) {
            
            // for selling price - we can sell only after we buy
            // hence, j begins after ith index
            for(int j=i+1; j<prices.length; j++) {
                
                // calculate profit
                int curr_profit = prices[j] - prices[i];
                
                // if greater than previous profit
                if(curr_profit > profit)
                    profit = curr_profit;
            }
        }
        
        return profit;
    }
}