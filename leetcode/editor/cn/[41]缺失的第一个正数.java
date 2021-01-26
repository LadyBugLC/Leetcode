//给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,0]
//输出: 3
// 
//
// 示例 2: 
//
// 输入: [3,4,-1,1]
//输出: 2
// 
//
// 示例 3: 
//
// 输入: [7,8,9,11,12]
//输出: 1
// 
//
// 
//
// 提示： 
//
// 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
//数组添加负号作为标记
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++)
            if (nums[i] <= 0)
                nums[i] = len + 1;
        for (int i = 0; i < len; i++)
            if (nums[i] >= -len && nums[i] <= len)
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        for (int i = 0; i < len; i++)
            if (nums[i] > 0)
                return i + 1;
        return len + 1;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
