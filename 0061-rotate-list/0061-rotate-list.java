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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null || head.next == null || k == 0) 
            return head;

        int cnt = 1;
        ListNode curr = head;

        while(curr.next != null)
        {
            cnt++;
            curr = curr.next;
        }

        ListNode tail = curr;

        k = k % cnt;

        if(k == 0) return head;

        int mid = cnt - k;

        ListNode prev = null;
        curr = head;

        while(mid > 1)
        {
            prev = curr;
            curr = curr.next;
            mid--;
        }

        ListNode next = curr.next;

        curr.next = null;

        tail.next = head;

        return next;
    }
}