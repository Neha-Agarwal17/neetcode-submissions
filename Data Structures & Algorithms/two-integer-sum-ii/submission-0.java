class Solution {
    public int[] twoSum(int[] arr, int k) {
        int n = arr.length;
        int i=0, j=n-1;
        while(i<j)
        {
            int sum = arr[i]+arr[j];
            if(sum==k)
            {
                return(new int[]{i+1, j+1});
            }
            else if(sum>k)
            {
                j--;
            }
            else{
                i++;
            }
        }
        return new int[]{1,2};
    }
}
