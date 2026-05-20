class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int i = 0;
        int j = i+1;
        int max = 0; 
        while(j<n)
        {
            if(prices[i]<prices[j])
            {
                max = Math.max((prices[j]-prices[i]), max);
            }
            else
            {
                i=j;
            }
            j++;
        }
        return max;
    }
}
