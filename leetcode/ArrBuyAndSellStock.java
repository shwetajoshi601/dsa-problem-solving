class BuyAndSellStock {
    // brute force solution
    public int maxProfitBrute(int[] prices) {

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

    // O(n) solution
    public int maxProfitBetter(int[] prices) {

        int max_profit = 0, min_price = Integer.MAX_VALUE;

        // max profit - min buying price, max selling price
        for(int i=0; i< prices.length; i++) {
            // find min price so far
            min_price = Math.min(min_price, prices[i]);
            // find max profit so far
            max_profit = Math.max(max_profit, prices[i] - min_price); 
        }
        return max_profit;
    }
}