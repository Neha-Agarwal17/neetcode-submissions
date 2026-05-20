class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int min_diff = Math.abs(arr[0] - x);
        map.put(arr[0], min_diff);
        int c = 0;
        for(int i=1;i<n;i++)
        {
            int diff = Math.abs(arr[i] - x);
            if(diff < min_diff)
            {
                min_diff = diff;
                c = i; 
            }
            map.put(arr[i], diff);
        }
        list.add(arr[c]);
        int i = c-1;
        int j = c+1;
        int count = 1;
        while(i>=0 && j<n && count<k)
        {
            int left = map.get(arr[i]);
            int right = map.get(arr[j]);
            if(left<right)
            {
                list.add(arr[i]);
                count++;
                i--;
            }
            else if(right<left)
            {
                list.add(arr[j]);
                count++;
                j++;
            }
            else
            {
                if(arr[i]<arr[j])
                {
                    list.add(arr[i]);
                    count++;
                    i--;
                }
                else
                {
                    list.add(arr[j]);
                    count++;
                    j++;
                }
            }
            if(count==k)
            {
                Collections.sort(list);
                return list;
            }
        }

        while(count<k)
        {
            if(i>=0)
            {
                list.add(arr[i]);
                i--;
                count++;
            }
            else if(j<n)
            {
                list.add(arr[j]);
                j++;
                count++;
            }            
        }
        Collections.sort(list);
        return list;
    }
}