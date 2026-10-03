class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = 0;
        int max = 1;
        int sum = 0;
        while(max<n)
        {
            if(prices[max]<=prices[min])
            {
                min = max;
            }
            else if(prices[max]>prices[min] && max>min)
            {
                int hold = prices[min];
                int sell = prices[max];
                int profit = sell - hold;
                sum+=profit;
                min++;
            }
            max++;
        }
        return sum;
    }
}