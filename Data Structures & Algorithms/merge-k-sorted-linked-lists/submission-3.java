/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int n = lists.length;
        if(n==0)
        {
            return null;
        }
        for(int i=0; i<n; i++)
        {
            ListNode curr = lists[i];
            while(curr!=null)
            {
                map.put(curr.val, map.getOrDefault(curr.val, 0)+1);
                curr = curr.next;
            }
        }

        if(map.isEmpty())
        {
            return null;
        }

        int firstKey = map.firstKey();
        ListNode newList = new ListNode(firstKey);
        ListNode prev = newList;
        map.put(firstKey, map.getOrDefault(firstKey, 0)-1);

        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            int key = entry.getKey();
            int freq = entry.getValue();
            while(freq>0)
            {
                ListNode dummy = new ListNode(key);
                prev.next = dummy;
                prev = prev.next;
                freq--;
            }
        }
        return newList;
    }
}
