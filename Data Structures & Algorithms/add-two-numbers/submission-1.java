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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        
        int carry = 0;
        int sum = curr1.val + curr2.val + carry;
        int rem = sum%10;
        // If sum>9?(carry -> 1 ) else(carry->0)
        carry = sum/10;
        ListNode newList = new ListNode(rem);
        ListNode prev = newList;
        curr1=curr1.next;
        curr2=curr2.next;

        while(curr1!=null && curr2!=null)
        {
            sum = curr1.val + curr2.val + carry;
            rem = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(rem);
            prev.next = newNode;
            prev=prev.next;
            curr1=curr1.next;
            curr2=curr2.next;
        }

        while(curr1!=null)
        {
            sum = curr1.val + carry;
            rem = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(rem);
            prev.next = newNode;
            prev=prev.next;            
            curr1 = curr1.next;
        }
        while(curr2!=null)
        {
            sum = curr2.val + carry;
            rem = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(rem);
            prev.next = newNode;
            prev=prev.next;
            curr2 = curr2.next;
        }

        if(carry>0)
        {
            ListNode newNode = new ListNode(carry);
            prev.next = newNode;
            newNode.next = null;
        }

        return newList;
    }
}
