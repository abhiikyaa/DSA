class Solution {
    public ListNode swapPairs(ListNode head) 
    {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null && curr.next != null)
        {
            next = curr.next;

            curr.next = next.next;
            next.next = curr;

            if(prev == null)
                head = next;
            else
                prev.next = next;

            prev = curr;
            curr = curr.next;
        }

        return head;
    }
}