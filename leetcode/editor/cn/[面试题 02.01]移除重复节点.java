//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
//不使用临时缓冲区,用时间换取空间
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        int num = 1;
        ListNode p = head;
        boolean flag = true;
        if (head == null)
            return head;
        while (p.next != null) {
            int pval = p.next.val;
            ListNode searchp = head;
            flag = true;
            for (int i = 0; i < num; i++) {
                if (searchp.val == pval) {
                    p.next = p.next.next;
                    num--;
                    flag = false;
                }
                searchp = searchp.next;
            }
            num++;
            if (flag == true && p.next != null)
                p = p.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
