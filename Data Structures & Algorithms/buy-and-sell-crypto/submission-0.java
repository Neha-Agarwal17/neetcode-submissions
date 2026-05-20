//Use to 2 pointer technique - 
//one i at 0, j at i+1, if arr[j]<arr[i] && profit<0, i++, j++, else only j++
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit =0;
        int i =0;
        int j = i+1;
        while(j<n)
        {
            int profit = prices[j]- prices[i]; 
            if(prices[j]<prices[i])
            {
                i=j;
            }
            j++;
            maxProfit = profit>maxProfit ? profit : maxProfit;
        }
        return maxProfit;
    }
}
