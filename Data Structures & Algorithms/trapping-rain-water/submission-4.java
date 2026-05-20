
class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int max = 0;
        int maxIndex = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];
                maxIndex = i;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]>=maxLeft)
            {
                maxLeft = arr[i];
            }
            if(i>maxIndex)
            {
                max = arr[i];
                maxIndex = i;
                int j = i+1;
                while(j<n)
                {
                    if(arr[j]>max)
                    {
                        max = arr[j];
                        maxIndex = j;
                    }
                    j++;
                }
            }
            if(i<=maxIndex)
            {
                maxRight = max;
            }
            sum += ((maxLeft>maxRight)?maxRight:maxLeft)-arr[i];
        }
        return sum;
    }
}
