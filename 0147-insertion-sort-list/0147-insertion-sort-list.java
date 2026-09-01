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
// class Solution {
//     public ListNode insertionSortList(ListNode head) 
//     {
//         if(head == null || head.next == null) return head;
//         ListNode curr = head.next;
//         ListNode next;

//         while(curr != null)
//         {
//             next = curr.next;
//             curr.next = null;
//             ListNode prev = null;
//             ListNode temp = head;
//             while(temp != curr && temp.val <= curr.val)
//             {
//                 prev = temp;
//                 temp = temp.next;
//             }
//             if(prev == null)
//             {
//                 curr.next = head;
//                 head = curr;
//             }
//             else if(temp != curr)
//             {
//                 prev.next = curr;
//                 curr.next = temp;
//             }
//             curr = next;
//         }  
//         return head; 
//     }
// }

class Solution {
    public ListNode insertionSortList(ListNode head) 
    {
        if(head == null || head.next == null) return head;

        ListNode curr = head.next;
        ListNode prevCurr = head;

        while(curr != null)
        {
            ListNode next = curr.next;

            ListNode prev = null;
            ListNode temp = head;

            // insertion position find karo
            while(temp != curr && temp.val <= curr.val)
            {
                prev = temp;
                temp = temp.next;
            }

            // curr already correct position par hai
            if(temp == curr)
            {
                prevCurr = curr;
                curr = next;
                continue;
            }

            // curr ko old position se remove karo
            prevCurr.next = next;

            // curr ko head par insert karo
            if(prev == null)
            {
                curr.next = head;
                head = curr;
            }
            // curr ko beech mein insert karo
            else
            {
                prev.next = curr;
                curr.next = temp;
            }

            curr = next;
        }

        return head;
    }
}

