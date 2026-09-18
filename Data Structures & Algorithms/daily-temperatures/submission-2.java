class Solution {
    public int[] dailyTemperatures(int[] tmp) {
        Stack<Integer> stack = new Stack<>();
        int n = tmp.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty() && tmp[i]>tmp[stack.peek()])
            {
                int prev = stack.pop();
                res[prev] = i - prev;
            }
            stack.push(i);
        }
        return res;
    }
}
