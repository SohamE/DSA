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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode l1,l2,result,temp;
		if (list1 == null) return list2;
        if (list2 == null) return list1;
		if (list1.val < list2.val) {
			l1 = list1;
			l2 = list2;
		} else {
			l1 = list2;
			l2 = list1;
		}
		result = l1;
		temp = l1;
		while(l1 != null) {
			if(l1.val <= l2.val) {
				temp = l1;
				l1 = l1.next;
			} else {
				temp.next = l2;
				temp = l1;
				l1 = l2;
				l2 = temp;
			}
		}
		temp.next = l2;
        return result;
    }
}
