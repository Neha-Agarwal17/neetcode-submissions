class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int count =0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                count++;
            }
        }
        int mul = 1;
        for(int i=0; i<nums.length; i++)
        {
            switch(count){
                case 0:
                    mul= mul * nums[i];
                    break;
                case 1:
                    if(nums[i]!=0){mul=mul*nums[i];}
                    break;
                case 2:
                    mul= 0;
                    break;
            }
        }
        for(int i=0; i<output.length; i++)
        {
            switch(count){
                case 0 :
                output[i]= mul/nums[i];
                break;
                case 1:
                if(nums[i]!=0)
                {   
                    output[i]=0;
                    break;
                }else{
                    output[i]=mul;
                    break;
                }
                case 2:
                output[i]=0;
                break;
            }
        }
        return output;
    }
}  
