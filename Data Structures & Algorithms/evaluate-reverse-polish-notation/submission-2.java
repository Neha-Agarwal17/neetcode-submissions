class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String s: tokens)
        {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            {
                int s2 = Integer.parseInt(stack.pop());
                int s1 = Integer.parseInt(stack.pop());
                switch(s)
                {
                    case "+":
                    stack.push(String.valueOf(s1+s2));
                    break;
                    case "-":
                    stack.push(String.valueOf(s1-s2));
                    break;
                    case "*":
                    stack.push(String.valueOf(s1*s2));
                    break;
                    case "/":
                    stack.push(String.valueOf(s1/s2));
                    break;
                }
            }
            else
            {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
