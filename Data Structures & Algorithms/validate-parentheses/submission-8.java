class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] ch = s.toCharArray();
        for(char c: ch)
        {
            if(c == '(' || c == '[' || c == '{')
            {
                stack.push(c);
            }
            else
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                char top = stack.pop();
                switch (top){
                case '{':
                    if(c!='}')
                    {
                        return false;
                    }
                    break;
                case '(':
                    if(c!=')')
                    {
                        return false;
                    }
                    break;
                case '[':
                    if(c!=']')
                    {
                        return false;
                    }
                    break;
                }
            }
        }
        return stack.isEmpty()?true:false;
    }
}
