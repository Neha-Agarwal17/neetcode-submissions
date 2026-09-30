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
    public void reorderList(ListNode head) {
        //Find middle using slow+fast pointers always
        ListNode slow = head;
        ListNode fast = head;
        ListNode list1 = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Split into two lists by save 2nd half 
        ListNode list2 = slow.next;
        //3. cut the link (point first list end to null) else later during merge it will cause cycle
        slow.next = null;

        ListNode curr = list2;
        ListNode prev = null;
        while(curr!=null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //4. since now curr is at null and prev is at the first node of the 2nd list
        list2 = prev;

        //Merge the two lists list1 & list2
        while(list2!=null && list1!=null)
        {
            ListNode nextL1 = list1.next;
            ListNode nextL2 = list2.next;
            list1.next = list2;
            list2.next = nextL1;
            list1 = nextL1;
            list2 = nextL2;
        }
    }
}
