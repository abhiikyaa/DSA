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
    public void reorderList(ListNode head) 
    {
        ListNode midN = mid(head);
        ListNode nextN = midN.next;
        midN.next = null;
        ListNode L1 = head,L1Next;
        ListNode L2 = rev(nextN);           
        while(L1!=null && L2!=null)
        {
            L1Next =  L1.next;                                    
			L1.next =  L2;
			           
            L1 =  L2;
            L2=L1Next;
        }    
    }

    public ListNode mid(ListNode head)
    {
        ListNode s = head , f = head;
        while(f != null && f.next != null)
        {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public ListNode rev(ListNode head)
    {
        ListNode curr = head, prev = null, next = null;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}