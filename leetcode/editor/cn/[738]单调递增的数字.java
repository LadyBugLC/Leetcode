//给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。 
//
// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。） 
//
// 示例 1: 
//
// 输入: N = 10
//输出: 9
// 
//
// 示例 2: 
//
// 输入: N = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 输入: N = 332
//输出: 299
// 
//
// 说明: N 是在 [0, 10^9] 范围内的一个整数。 
// Related Topics 贪心算法 
// 👍 114 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int monotoneIncreasingDigits(int N) {
        if (N == 0)
            return 0;
        int place = 0;
        for (int i = 1; i <= N; i *= 10)
            place++;
        int[] num = new int[place];
        num[0] = N / (int) Math.pow(10, place - 1);
        int cutN = N - num[0] * (int) Math.pow(10, place - 1);
        for (int i = 1; i < place; i++) {
            num[i] = cutN / (int) Math.pow(10, place - i - 1);
            cutN -= num[i] * (int) Math.pow(10, place - i - 1);
            if (num[i] < num[i - 1]) {
                for (int j = i + 1; j < num.length; j++)
                    num[j] = 9;
                do {
                    num[i] = 9;
                    num[i - 1]--;
                    i--;
                } while (i >= 1 && num[i] < num[i - 1]);
                i = place;//跳出循环
            }
        }
        int back = 0;
        for (int i = 0; i < num.length; i++)
            back += num[i] * (int) Math.pow(10, place - i - 1);
        return back;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
