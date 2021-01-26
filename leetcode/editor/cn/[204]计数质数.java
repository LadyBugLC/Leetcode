//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 552 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        if (n < 2)
            return 0;
        int[] prime = new int[n];
        int count = 0;
        Arrays.fill(prime, 1);//1为素数
        for (int i = 2; i < n; i++) {
            if (prime[i] == 1) {
                count++;
                if ((long) i * i < n)
                    for (int j = i * i; j < n; j += i)
                        prime[j] = 0;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
