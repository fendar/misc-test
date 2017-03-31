package net.fendar.test.leetcode;

/**
 * Created by zhongchao on 16/9/15.
 */
public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result, now, node;
            result = new ListNode(0);
            now = result;
            int sum, rVal, pVal = 0;
            while (l1 != null && l2 != null) {

                sum = l1.val + l2.val + pVal;
                rVal = sum % 10;
                pVal = sum / 10;
                node = new ListNode(rVal);

                now.next = node;
                now = node;

                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                sum = l1.val + pVal;
                rVal = sum % 10;
                pVal = sum / 10;
                node = new ListNode(rVal);

                now.next = node;
                now = node;

                l1 = l1.next;
            }

            while (l2 != null) {
                sum = l2.val + pVal;
                rVal = sum % 10;
                pVal = sum / 10;
                node = new ListNode(rVal);

                now.next = node;
                now = node;

                l2 = l2.next;
            }

            if (pVal != 0) {
                node = new ListNode(pVal);
                now.next = node;
            }

            return result.next;
        }
    }
}
