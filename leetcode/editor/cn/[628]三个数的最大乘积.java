//给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: 6
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: 24
// 
//
// 注意: 
//
// 
// 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。 
// 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。 
// 
// Related Topics 数组 数学 
// 👍 243 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumProduct(int[] nums) {
        int max = -2000, max1 = -2000, max2 = -2000, min1 = 0, min2 = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max2) {
                max2 = nums[i];
                if (max1 < max2) {
                    int tmp = max1;
                    max1 = max2;
                    max2 = tmp;
                    if (max < max1) {
                        tmp = max;
                        max = max1;
                        max1 = tmp;
                    }
                }
            }
            if (nums[i] < 0) {
                if (nums[i] < min2) {
                    min2 = nums[i];
                    if (min2 < min1) {
                        int tmp = min1;
                        min1 = min2;
                        min2 = tmp;
                    }
                }
                num++;
            }
        }
        if (num >= 2)
            return Math.max(max * max1 * max2, max * min1 * min2);
        else return max * max1 * max2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
