/*
21
10
+
3
Stack ->
30
-
4
34

take value of str[i] and push to stack
take value of star[i+1] and push to stack
if (!(str[i]>=-200 && str[i]<=200)) - true
switch(str[i]) ->
 int b = stack.pop, int a = stack.pop(); 
 case '+': stack.push(a+b);
 case '-': stack.push(a-b);
 case '*': stack.push(a*b);
 case '/': stack.push(0);

*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<tokens.length; i++)
        {
            String s = tokens[i];
            if(s.matches("[+\\-*/]"))
            {
                int b = stack.pop();
                int a = stack.pop();
                switch(s){
                case "+": 
                    stack.push(a+b);
                    break;
                case "-":
                    stack.push(a-b);
                    break;
                case "*":
                    stack.push(a*b);
                    break;
                case "/":
                    stack.push(a/b);
                    break;
                }
            }
            else
            {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.pop();
        
    }
}
