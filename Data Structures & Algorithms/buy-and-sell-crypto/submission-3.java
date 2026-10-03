//Use to 2 pointer technique - 
//one i at 0, j at i+1, if arr[j]<arr[i] && profit<0, i++, j++, else only j++
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

            if(max!=min && max>min)
            {
                int profit = prices[max] - prices[min];
                max_profit = profit>max_profit?profit:max_profit;
            }
            max++;
        }

        return max_profit;
    }
}
