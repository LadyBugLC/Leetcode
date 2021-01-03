//给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例： 
//
// 
//输入：head = 1->4->3->2->5->2, x = 3
//输出：1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 312 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode anshead = null;
        ListNode ans = null;
        ListNode biggerhead = null;
        ListNode last = null;
        while (head != null) {
            if (head.val < x) {
                if (anshead == null) {
                    ans = new ListNode(head.val);
                    anshead = ans;
                } else {
                    ans.next = new ListNode(head.val);
                    ans = ans.next;
                }
                if (last != null)
                    last.next = head.next;
                head = head.next;
            } else {
                if (biggerhead == null) {
                    biggerhead = head;
                    last = biggerhead;
                }
                last = head;
                head = head.next;
            }
        }
        if (ans != null) {
            ans.next = biggerhead;
            return anshead;
        } else return biggerhead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
