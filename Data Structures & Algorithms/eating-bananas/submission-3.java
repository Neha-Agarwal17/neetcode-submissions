/*
    h - no of hours in which you have to eat all bananas
    k - choose k such that no. of bananas you can eat from each pile in 1 hour
    1 pile per hour
    minimum k needed to eat and return all bananas
    value for k cannot exceed max of piles[]
*/
class Solution {
    public int minEatingSpeed(int[] piles, int hours_limit) {
        int n = piles.length;
        int low = 1;
        int high = piles[0];
        for(int i=0; i<n; i++)
        {
            high = piles[i]>high?piles[i]:high;
        }
        int min_k = high;
        while(low<=high)
        {
            int curr_k = low + (high - low)/2;
            int curr_hours = 0;
            for(int i=0;i<n;i++)
            {
                curr_hours += Math.ceil((double)piles[i]/curr_k);
            }
            if(curr_hours > hours_limit)
            {
                low = curr_k + 1;
            }
            else
            {
                min_k = curr_k<min_k?curr_k:min_k;
                high = curr_k - 1;
            }
        }
        return min_k;
    }
}
