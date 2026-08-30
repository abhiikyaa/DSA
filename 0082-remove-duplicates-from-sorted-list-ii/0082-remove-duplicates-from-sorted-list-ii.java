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
    public ListNode deleteDuplicates(ListNode head) 
    {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null)
        {
            next = curr.next;
            if(next != null && curr.val == next.val)
            {
                int dup = curr.val;
                while(curr != null && curr.val == dup)
                {
                    curr = curr.next;
                }

                if(prev == null)
                {
                    head = curr;
                }
                else
                {
                    prev.next = curr;
                }
            }
            else
            {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}