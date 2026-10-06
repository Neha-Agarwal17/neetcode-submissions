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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode begin = head;
        ListNode prev = null;
        ListNode curr = head;

        int n = 0;

        // Count nodes
        while (begin != null) {
            n++;
            begin = begin.next;
        }

        begin = head;
        int rem = n;

        ListNode newHead = head;
        ListNode groupPrev = null;

        while (rem >= k) {

            ListNode groupStart = begin;
            prev = null;
            curr = begin;

            int count = k;

            // Reverse k nodes
            while (count > 0) {
                ListNode next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;

                count--;
            }

            // prev = new head of reversed group
            if (groupPrev == null) {
                newHead = prev;
            } else {
                groupPrev.next = prev;
            }

            // groupStart is now the tail
            groupStart.next = curr;

            // groupStart becomes previous node for next group
            groupPrev = groupStart;
            begin = curr;

            rem = rem - k;
        }

        return newHead;
    }
}