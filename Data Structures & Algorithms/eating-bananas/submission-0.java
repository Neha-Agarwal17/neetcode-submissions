class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = piles[0];
        for(int i=0;i<n;i++)
        {
            max = piles[i]>max?piles[i]:max;
        }
        int low = 1;
        int high = max;
        int min_mid = high;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int count=0;
            for(int i=0;i<n;i++)
            {
                count+= ((piles[i]+mid-1)/mid);
            }
            if(count<=h)
            {
                min_mid=mid<min_mid?mid:min_mid;
                high=mid-1;   
            }
            else
            {
                low=mid+1;
            }
        }
        return min_mid;
    }
}
