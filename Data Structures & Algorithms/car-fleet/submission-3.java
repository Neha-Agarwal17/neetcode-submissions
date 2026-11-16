class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int n = position.length;
        for(int i=0;i<n;i++)
        {
            map.put(position[i], speed[i]);
        }
        Stack<Double> stack = new Stack<>();
        for(Map.Entry<Integer,Integer> entry : map.descendingMap().entrySet())
        {
            Double time = (double)(target - entry.getKey())/entry.getValue();
            if(!stack.isEmpty() && time<=stack.peek())
            {
                continue;
            }
            stack.push(time);
        }
        return stack.size();
    }
}
