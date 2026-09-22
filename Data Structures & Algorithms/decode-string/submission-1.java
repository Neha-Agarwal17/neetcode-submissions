class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int n = s.length();
        char[] ch = s.toCharArray();
        for(int i=0;i<n;i++)
        {
            if(ch[i] != ']')
            {
                stack.push(String.valueOf(ch[i]));
            }
            else
            {
                StringBuilder sb_str = new StringBuilder();
                while(!stack.isEmpty() && stack.peek().matches("[a-zA-Z]+"))
                {
                    sb_str.insert(0, stack.pop());
                }
                if(!stack.isEmpty() && stack.peek().equals("["))
                {
                    stack.pop();
                    StringBuilder sb_digit = new StringBuilder();
                    while(!stack.isEmpty() && stack.peek().matches("[0-9]+"))
                    {
                        sb_digit.insert(0, stack.pop());
                    }
                    int count = Integer.parseInt(sb_digit.toString());
                    StringBuilder sb_final = new StringBuilder();
                    while(count>0)
                    {
                        sb_final.insert(0, sb_str);
                        count--;
                    }
                    String str_converted = sb_final.toString();
                    stack.push(str_converted);
                } 
            }
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty())
        {   
            result.insert(0,stack.pop());
        }
        return result.toString();
    }
}