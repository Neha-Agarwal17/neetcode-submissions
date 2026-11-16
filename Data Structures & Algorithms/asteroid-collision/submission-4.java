/*

[2 4 -4 -1]
[2]
TOP -> 2
NEW -> 4
COMPARE (TOP,NEW)
+ -> RIGHT && - -> LEFT

RIGHT RIGHT - NEW GO INTO STACK
RIGHT LEFT - COLLISION - PUSH MAX OF BOTH INTO STACK
LEFT RIGHT - NO COLLISION - NEW GO INTO STACK
LEFT LEFT - NEW GO INTO STACK
EQUAL WEIGHT - BOTH DESTROYED

use a boolean flag to check for conditions where the incoming astteroid could get destroyed
an incoming asteroid could collide with top of stack and again next top and so on as well(so keep checking)
if, its not destroyed at last after all checks then add to the stack
*/

class Solution {
    public int[] asteroidCollision(int[] a) {
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(a[0]);
        for(int i=1;i<n;i++)
        {       
            boolean destroyed = false;
            while(!stack.isEmpty() && stack.peek()>0 && a[i]<0)
            {
                if(Math.abs(stack.peek()) == Math.abs(a[i]))
                {
                    stack.pop();
                    destroyed = true;
                    break;
                }
                else if(Math.abs(stack.peek())>Math.abs(a[i]))
                {
                    destroyed = true;
                    break;
                }
                else
                {
                    stack.pop();
                }
            }
            if(destroyed==false)
            {
                stack.push(a[i]);
            }
        }
        // pop and store from the end of the array
        int[] result = new int[stack.size()];
        for(int i=result.length-1;i>=0;i--)
        {
            result[i]=stack.pop();
        }
        return result;
    }
}