//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
//使用排序+双指针的方法,时间复杂度为n2
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int close = 99999999;
        int a, b, c;
        int atarget;
        for (a = 0; a < n - 2 & close-target != 0; a++) {
            atarget = target - nums[a];
            b = a + 1;
            c = n - 1;
            while (b < c && close-target != 0) {
                if (Math.abs(nums[a] + nums[b] + nums[c] - target) < Math.abs(close-target))
                    close = nums[a] + nums[b] + nums[c];
                if (nums[b] + nums[c] > atarget)
                    c--;
                else
                    b++;
            }
        }
        return close;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
