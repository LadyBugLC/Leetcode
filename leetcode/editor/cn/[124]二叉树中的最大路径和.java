//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索


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
//int maxsum为题所求解 int sum(TreeNode root)为递归函数
//在遍历每个节点的时候,只需要三个值即可判断解:
//1.该点左儿子为端点的路径的最大值
//2.该点右儿子为端点的路径的最大值
//3.以及该点自身的值
//加以判断,(左+自+右,左+自,自+右,自)中 取最大值和maxsum比较,若大于则更新maxsum
//递归函数sum返回值为以该点为端点的最长路径.
//递归调用sum,直到遍历所有节点.maxsum即为解.
class Solution {
    public int maxPathSum(TreeNode root) {
        int maxsum = 0;
        public int sum (TreeNode root){
            int leftsum, rightsum;
            if (root.left != null)
                leftsum = sum(root.left);
            else leftsum = 0;
            if (root.right != null)
                rightsum = sum(root.right);
            else rightsum = 0;
            if (leftsum + rightsum + root.val > maxsum)
                maxsum = leftsum + rightsum + root.val;
            if (leftsum + root.val > maxsum)
                maxsum = leftsum + root.val;
            if (rightsum + root.val > maxsum)
                maxsum = rightsum + root.val;
            if (root.val > maxsum)
                maxsum = root.val;
            if (leftsum > rightsum) {
                if (leftsum > 0)
                    return leftsum + root.val;
                else return root.val;
            } else {
                if (rightsum > 0)
                    return rightsum + root.val;
                else return root.val;
            }
        }
        public int maxPathSum (TreeNode root){
            maxsum = root.val;
            int a = sum(root);
            if (a > maxsum)
                maxsum = a;
            return maxsum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
