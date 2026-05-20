
class Solution {
    public int trap(int[] arr) {

    /*APPROACH 1 -> For every spot I stand on, if I've passed the tallest building I knew about, 
    I'm going to run all the way to the end of the city to see what the next tallest building is.
    recalculating the maxRight wall
    In a scenario where the bar heights are strictly decreasing (e.g., [5, 4, 3, 2, 1]),
    every time you move one step forward, you trigger that while loop to scan the rest of the array.

    TIME COMPLEXITY -> (O(N2))

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
    */
    
    /* APPROACH 2 -> The Two-Pointer approach
        1. Set Your Boundaries - Place one pointer at the start and one at the end. 
        Keep track of the tallest building seen so far on each side, called Max Left and Max Right.
        2. Move the Shorter Bar - Compare the bars at your two pointers.
        Always move the pointer that is standing on the shorter height toward the middle.
        Why? 
            Because the shorter side is the "bottleneck." It doesn't matter how high the other side is;
            the water will always spill out from the shorter side first.
        3. Compare with the Max - 
        When you move to a new bar, check it against its side's record (Max Left or Max Right):
            If the bar is taller: Update your Max Left or Max Right. (New peak found, no water trapped).
            If the bar is shorter: You’ve found a hole! The water trapped at this spot is simply the Max of that side minus the height of the bar.
    */
    int n = arr.length;
    int maxLeft = arr[0];
    int maxRight = arr[n-1];
    int i = 0;
    int j = n-1;
    int sum = 0;
    while(i<j)
    {
        if(maxLeft<maxRight)
        {
            i++;
            if(arr[i]<maxLeft)
            {
                sum+=maxLeft - arr[i];
            }
            else
            {
                maxLeft = arr[i];
            }
        }
        else
        {
            j--;
            if(arr[j]<maxRight)
            {
                sum+=maxRight - arr[j];
            }
            else
            {
                maxRight = arr[j];
            }
        }
    }
    return sum;
    }
}
