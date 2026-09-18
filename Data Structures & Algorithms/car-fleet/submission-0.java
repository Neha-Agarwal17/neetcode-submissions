class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        //Used for automatically sorting by the keys while inserting values
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Stack<Double> stack = new Stack<>();
        for(int i=0;i<n;i++)
        {
            map.put(position[i], speed[i]);
        }
        for(Map.Entry<Integer, Integer> entry: map.descendingMap().entrySet())
        {
            int pos = entry.getKey();
            int spd = entry.getValue();

            double time = (double) (target - pos) / spd;            
            if (!stack.isEmpty() && time <= stack.peek()) {
                // This car catches the fleet ahead
                // So it becomes part of the same fleet
                continue;
            }
            stack.push(time);
        }
        return stack.size();

    }
}
