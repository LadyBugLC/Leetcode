//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法


import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, k);
    }

    //引入随机数的快速选择算法,返回第k大的数
    public int quickselect(int[] nums, int l, int r, int k) {
        int q = quicksort(nums, l, r);
        if (q + k == nums.length)
            return nums[q];
        else return q + k < nums.length ? quickselect(nums, q + 1, r, k) : quickselect(nums, l, q - 1, k);
    }

    //引入随机数的快速排序
    Random ran = new Random();

    public int quicksort(int[] nums, int l, int r) {
        int i = ran.nextInt(r - l + 1) + l;
        int x = nums[i];
        swap(nums, i, r);
        i = l;
        for (int j = l; j < r; j++)
            if (nums[j] <= x) {
                swap(nums, j, i);
                i++;
            }
        swap(nums, i, r);
        return i;
    }

    public void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
