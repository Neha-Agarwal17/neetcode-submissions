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
        //Finding middle using slow+fast past pointers
        ListNode slow = head;
        ListNode fast = head;
        ListNode list1 = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Split into two lists
        ListNode list2 = slow.next;
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

        list2 = prev;

        //Merge the two lists list1 & list2
        while(list2!=null && list1!=null)
        {
            ListNode nextL1 = list1.next;
            ListNode nextL2 = list2.next;
            list1.next = list2;
            list2.next = nextL1;
            if(list2.next == null && nextL2!=null)
            {
                list2.next = nextL2;
            }
            else if(list1.next == null && nextL1!=null)
            {
                list1.next = nextL1;
            }
            list1 = nextL1;
            list2 = nextL2;
        }
    }
}
