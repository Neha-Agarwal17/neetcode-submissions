class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c:s.toCharArray())
        {
            if(c=='}' || c==')' || c==']')
            {
                if(stack.isEmpty())
                {
                    return false;
                }
            switch(c)
            {
                case '}':
                    char pop_val = stack.pop();
                    if(pop_val!='{')
                    {
                        return false;
                    }
                    break;
                case ']':
                    pop_val = stack.pop();
                    if(pop_val!='[')
                    {
                        return false;
                    }
                    break;
                case ')':
                    pop_val = stack.pop();
                    if(pop_val!='(')
                    {
                        return false;
                    }
                    break;        
            }
            }
            else
            {
                stack.push(c);
            }   
        }
        if(!stack.isEmpty())
        {
            return false;
        }
    return true;
    }
}
