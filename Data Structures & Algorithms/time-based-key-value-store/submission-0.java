class TimeMap {
    Map<String, List<Integer>> timestamps;
    Map<String, List<String>> values;
    
    public TimeMap() {
        timestamps = new HashMap<>();
        values = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        timestamps
            .computeIfAbsent(key, k -> new ArrayList<>())
            .add(timestamp);

        values
            .computeIfAbsent(key, k -> new ArrayList<>())
            .add(value);
    }
    
    public String get(String key, int timestamp) {

        if (!timestamps.containsKey(key)) {
            return "";
        }

        List<Integer> arr = timestamps.get(key);
        List<String> vals = values.get(key);

        int low = 0;
        int high = arr.size() - 1;

        String answer = "";

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr.get(mid) == timestamp) {
                return vals.get(mid);
            }

            if (arr.get(mid) < timestamp) {
                // Valid candidate
                answer = vals.get(mid);

                // Maybe there is a later valid timestamp
                low = mid + 1;

            } else {
                // timestamp at mid is too large
                high = mid - 1;
            }
        }

        return answer;

    }
}
