//给出一个完全二叉树，求出该树的节点个数。 
//
// 说明： 
//
// 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为
//第 h 层，则该层包含 1~ 2h 个节点。 
//
// 示例: 
//
// 输入: 
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//输出: 6 
// Related Topics 树 二分查找 
// 👍 316 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int h = 1;
        TreeNode treeroot;
        treeroot = root;
        while (root.left != null) {
            h++;
            root = root.left;
        }
        int val = 0;
        int left = 1 << (h - 1), right = (1 << h) - 1;
        while (left != right) {
            val = (right - left + 1) / 2 + left;
            if (testval(treeroot, h, val))
                left = val;
            else right = val - 1;
        }
        return left;
    }

    public boolean testval(TreeNode root, int h, int val) {
        int bits = 1 << (h - 2);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & val) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
