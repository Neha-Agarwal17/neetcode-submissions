class Solution {
    public int[] dailyTemperatures(int[] arr) {
        
        int i=0;
        int j=i+1;
        int n = arr.length;
        int[] res = new int[n]; 
        while(i<n-1)
        {
            if(j<n && arr[j]>arr[i])
            {
                res[i]=j-i;
                i++;
                j=i+1;
            }
            else
            {
                j++;
            }
            // If j reaches the end and no warmer day was found for day 'i'
            if (j >= n) {
                res[i] = 0; // No warmer day exists
                i++;       // Move to the next day
                j = i + 1;  // Reset pointer
            }
        }
        return res;
    }
}
