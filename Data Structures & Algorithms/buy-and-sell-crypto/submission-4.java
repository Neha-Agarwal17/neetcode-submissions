//Use to 2 pointer technique - 
//one min at 0, max at max+1, if arr[max]<arr[min], min=max, else if profit>0  max++
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = 0;
        int max = 1;
        int max_profit = 0;

        while(max<n)
        {
            if(prices[max]<prices[min])
            {
                min = max;
            }
            if(max>min)
            {
                int profit = prices[max] - prices[min];
                max_profit = profit>max_profit?profit:max_profit;
            }
            max++;
        }

        return max_profit;
    }
}
