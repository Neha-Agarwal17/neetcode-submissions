class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int c = 0;
        for(int i =0; i<ops.length;i++)
        {
            switch(ops[i])
            {
                case "+":
                int last = stack.pop();
                c = Integer.valueOf(last) + 
                Integer.valueOf(stack.peek());
                stack.push(last);
                stack.push(c);
                break;
                case "C":
                stack.pop();
                break;
                case "D":
                c = Integer.valueOf(stack.peek()) * 2;
                stack.push(c);
                break;
                default:
                stack.push(Integer.valueOf(ops[i]));
                break;
            }
        }
        int res = 0;
        while(!stack.isEmpty())
        {
            res += stack.pop();
        }
        return res;
    }
}