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
    public ListNode partition(ListNode head, int x) 
    {
        if(head == null || head.next == null) return head;

        ListNode list1 = null;
        ListNode list2 = null;

        ListNode tail1 = null;
        ListNode tail2 = null;

        ListNode curr = head;
        ListNode next;

        while(curr != null)
        {
            next = curr.next;
            if(curr.val < x)
            {
                if(list1 == null)
                {
                    list1 = curr;
                    tail1 = curr;
                }
                else
                {
                    tail1.next = curr;
                    tail1 = curr;
                }
            }
            else
            {
                if(list2 == null)
                {
                    list2 = curr;
                    tail2 = curr;
                }
                else
                {
                    tail2.next = curr;
                    tail2 = curr;
                }
            }
            curr = next;
        }

        if(list1 == null) return list2;
        tail1.next = list2;
        if(tail2 != null)
        {
            tail2.next = null;
        }
        return list1;
    }
}