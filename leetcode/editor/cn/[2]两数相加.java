//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
//逐位相加,next表示是否进位
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1, num2;
        ListNode head = new ListNode(0);
        ListNode p = head;
        int next = 0;
        boolean flag1 = true, flag2 = true;
        while (flag1 || flag2) {
            num1 = l1.val;
            num2 = l2.val;
            if (num1 + num2 + next > 9) {
                p.val = num1 + num2 + next - 10;
                next = 1;
            } else {
                p.val = num1 + num2 + next;
                next = 0;
            }
            //   System.out.println(p.val);
            if (l1.next != null || l2.next != null) {
                p.next = new ListNode(0);
                p = p.next;
            } else p.next = null;
            if (l1.next != null)
                l1 = l1.next;
            else {
                l1.val = 0;
                flag1 = false;
            }
            if (l2.next != null)
                l2 = l2.next;
            else {
                l2.val = 0;
                flag2 = false;
            }
        }

        if (next == 1) {
            p.next = new ListNode(1);
            p.next.next = null;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
