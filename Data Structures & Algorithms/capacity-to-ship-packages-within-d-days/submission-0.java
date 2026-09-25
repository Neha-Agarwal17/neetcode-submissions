class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = weights[0];
        int high = 0;
        for(int i=0;i<n;i++)
        {
            high+=weights[i];
            low = weights[i]>low?weights[i]:low;
        }
        int res = high;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int lwc = mid;
            int i=0;    
            int count=1;
            while(i<n)
            {
                if(mid-weights[i]>=0)
                {
                    mid = mid-weights[i];
                    i++;
                }
                else
                {
                    count++;
                    mid = lwc;
                }
            }
            if(count <= days)
            {
                res=res>lwc?lwc:res;
                high=lwc-1;
            }
            else
            {
                low=lwc+1;
            }
        }
        return res;
    }
}