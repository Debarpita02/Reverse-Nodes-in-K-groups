class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        int count = 0;
        ListNode current = head;

        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (count == k) {
            current = reverseKGroup(current, k);
            while (count > 0) {
                ListNode temp = head.next;
                head.next = current;
                current = head;
                head = temp;
                count--;
            }
            head = current;
        }

        return head;
    }
}
