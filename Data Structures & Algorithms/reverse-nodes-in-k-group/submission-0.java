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
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kNode = getK(groupPrev, k);
            if (kNode == null) {
                break;
            }

            ListNode groupNext = kNode.next;

            // reverse the group
            ListNode prev = kNode.next;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            ListNode tmp = groupPrev.next;
            groupPrev.next = kNode;
            groupPrev = tmp;

        }
        return dummy.next;
    }

    private ListNode getK(ListNode curr, int k ) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k -= 1;
        }

        return curr;
    }
}
