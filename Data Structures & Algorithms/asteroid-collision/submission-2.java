class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int n = a.length;
        for(int i=0;i<n;i++)
        {
            Boolean destroyed = false;
            while(!stack.isEmpty() && stack.peek()>0 && a[i]<0)
            {
                if(Math.abs(a[i])>Math.abs(stack.peek()))
                {
                    stack.pop();
                }
                else if(Math.abs(a[i]) == Math.abs(stack.peek()))
                {
                    destroyed = true;
                    stack.pop();
                    break;
                }
                else
                {
                    destroyed = true;
                    break;
                }
            }

            if(destroyed == false)
            {
                stack.push(a[i]);
            }            
        }
        int i=0;
        int[] result = new int[stack.size()];
        for(int val: stack)
        {
            result[i]=val;
            i++;
        }
        return result;
    }
}