//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 示例 1: 
//
// 
//输入:
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出: 3
//解释: 
//长度最长的公共子数组是 [3, 2, 1]。
// 
//
// 说明: 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
//动态规划,lena为a数组的角标,lenb为b数组的角标,表明以这两个元素为结尾匹配的最长子数组
class Solution {
    public int findLength(int[] A, int[] B) {
        int lena = A.length, lenb = B.length;
        int[][] dp = new int[lena][lenb];
        int maxlen = 0;
        for (int a = 0; a < lena; a++)
            if (A[a] == B[0]) {
                dp[a][0] = 1;
                maxlen = 1;
            } else dp[a][0] = 0;
        for (int b = 0; b < lenb; b++)
            if (A[0] == B[b]) {
                dp[0][b] = 1;
                maxlen = 1;
            } else dp[0][b] = 0;
        for (int a = 1; a < lena; a++)
            for (int b = 1; b < lenb; b++)
                if (A[a] == B[b]) {
                    dp[a][b] = dp[a - 1][b - 1] + 1;
                    if (dp[a][b] > maxlen)
                        maxlen = dp[a][b];
                } else dp[a][b] = 0;
        return maxlen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
