/*
start from end -> 
stack - 28
40
40>stack.peek() -> yes - pop out 28 & push 40
stack - 40
35
35>stack.peek() -> no - push(35)
stack - 35 40
36>35 -> yes - pop out until curr tmp>stack.peek()
36>40 -> no - 

stack - 
5
4 5
3 5
2 3 5
1 5
*/

class Solution {
    public int[] dailyTemperatures(int[] tmp) {
        int n = tmp.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        for(int curr = n-1; curr>=0; curr--)
        {
            while(!stack.isEmpty() &&                
            tmp[curr]>=tmp[stack.peek()])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                res[curr] = 0;
            }
            else
            {
                res[curr] = stack.peek() - curr;
            }
            stack.push(curr);
        }
        return res;
    }
}
