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
    public ListNode insertionSortList(ListNode head) 
    {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        ListNode list1 = head;
        ListNode list2 = slow.next;
        slow.next = null;
        // ListNode tail1 = null;
        // ListNode tail2 = null;
        // ListNode curr = head;
        // ListNode next;

        // while(curr != null)
        // {
        //     next = curr.next;
        //     curr.next = null;
        //     if(curr.val <= mid.val)
        //     {
        //         if(list1 == null)
        //         {
        //             list1 = curr;
        //             tail1 = curr;
        //         }
        //         else
        //         {
        //             tail1.next = curr;
        //             tail1 = curr;
        //         }
        //     }
        //     else
        //     {
        //         if(list2 == null)
        //         {
        //             list2 = curr;
        //             tail2 = curr;
        //         }
        //         else
        //         {
        //             tail2.next = curr;
        //             tail2 = curr;
        //         }
        //     }
        //     curr = next;
        // }
        list1 = insertionSortList(list1);
        list2 = insertionSortList(list2);
        return merge(list1,list2);
    }
    public ListNode merge(ListNode list1, ListNode list2) 
    {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head;

        if(list1.val <= list2.val)
        {
            head = list1;
            list1 = list1.next;
        }
        else
        {
            head = list2;
            list2 = list2.next; 
        }

        ListNode curr = head;
        while(list1 != null && list2 != null)
        {
            if(list1.val <= list2.val)
            {
                curr.next = list1;
                list1 = list1.next;
            }
            else
            {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1 != null)
        {
            curr.next = list1;
        }
        else
        {
            curr.next = list2;
        }
        return head;
    }
}