//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 315 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.List;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        boolean lefttoright = true;
        LinkedList<TreeNode> nodeque = new LinkedList<>();
        nodeque.add(root);
        while (!nodeque.isEmpty()) {
            LinkedList<Integer> num = new LinkedList<>();
            int size = nodeque.size();
            for (int i = 0; i < size; i++) {
                int count = i;
                if (!lefttoright)
                    count = size - i - 1;
                TreeNode tmp = nodeque.get(count);
                num.add(tmp.val);
                if (nodeque.get(i).left != null)
                    nodeque.add(nodeque.get(i).left);
                if (nodeque.get(i).right != null)
                    nodeque.add(nodeque.get(i).right);
            }
            ans.add(num);
            lefttoright = !lefttoright;
            for (int i = 0; i < size; i++)
                nodeque.remove(0);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
