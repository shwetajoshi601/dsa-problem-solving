class BuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        int max_profit = 0, min_price = Integer.MAX_VALUE;

        for(int i=0; i< prices.length; i++) {
            
            min_price = Math.min(min_price, prices[i]);
            max_profit = Math.max(max_profit, prices[i] - min_price); 
            
        }
        return max_profit;
    }
}