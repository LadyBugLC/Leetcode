//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2,2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [4,9] 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶: 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 322 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
//利用哈希表存储元素和元素出现次数
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
        int[] num = new int[Math.min(nums1.length, nums2.length)];
        int length = 0;
        for (int i = 0; i < nums1.length; i++)
            if (maps.containsKey(nums1[i]))
                maps.put(nums1[i], maps.get(nums1[i]) + 1);
            else maps.put(nums1[i], 1);
        for (int i = 0; i < nums2.length; i++)
            if (maps.containsKey(nums2[i])) {
                maps.put(nums2[i], maps.get(nums2[i]) - 1);
                num[length] = nums2[i];
                length++;
                maps.remove(nums2[i], 0);
            }
        return Arrays.copyOfRange(num, 0, length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
