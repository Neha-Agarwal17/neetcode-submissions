/*
    Sorted car positions - speed mappings
    whichever car takes lesser time than the car ahead its position, they will become 1 fleet
    time taken by a car to reach target = remaining distance / speed of the car 
    we need to iterate from last to first positions
    Use a stack to store the number of car fleets (at top of the stack, always have the next position's time)
*/

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Stack<Double> stack = new Stack<>();
        int n = position.length;
        for(int i=0;i<n;i++)
        {
            map.put(position[i], speed[i]);
        }
        for(Map.Entry<Integer,Integer> entry : map.descendingMap().entrySet())
        {
            double time = (double) (target - entry.getKey())/entry.getValue();
            if(!stack.isEmpty() && time<= stack.peek())
            {
                continue;
            }
            stack.push(time); 
        }
        return stack.size();
    }
}
