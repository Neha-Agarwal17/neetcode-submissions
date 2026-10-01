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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //we need dummy here because if head is removed then dummy node can be returned
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        //1.Move fast n times forward in the list (reach nth index from begin of list)
        int count=0;
        while(count<=n)
        {
            fast = fast.next;
            count++;
        }
        //2. Move slow until fast!=null, now slow is at prev of nth index from end 
        while(fast!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        //remove next element to slow (nth element from end)
        slow.next = slow.next.next;

        return dummy.next;
    }
}
