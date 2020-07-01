//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回
// 0。 
//
// 示例: 
//
// 输入: s = 7, nums = [2,3,1,2,4,3]
//输出: 2
//解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
// 
//
// 进阶: 
//
// 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// Related Topics 数组 双指针 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //二分查找
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int min = 1, max = len;
        int minlen = 0;
        if (len == 0)
            return 0;
        if (len == 1)
            if (nums[0] >= s)
                return 1;
        if (len == 2)
            if (nums[0] + nums[1] >= s)
                return 2;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + nums[i];
            if (sum >= s) {
                minlen = len;
                i = len;
            }
        }
        while (min != max) {
            boolean flag = false;
            len = (min + max) / 2;
            sum = 0;
            for (int i = 0; i < len; i++)
                sum = sum + nums[i];
            if (sum >= s)
                flag = true;
            for (int i = 0; i < nums.length - len && !flag; i++) {
                sum = sum - nums[i] + nums[i + len];
                if (sum >= s)
                    flag = true;
            }
            if (flag == true) {
                max = len;
                minlen = len;
            } else
                min = len;
            if (len == (min + max) / 2)
                break;
            //System.out.println(len);
        }
        return minlen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
