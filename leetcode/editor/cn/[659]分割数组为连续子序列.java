//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 
//
// 示例 2： 
//
// 输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 
//
// 示例 3： 
//
// 输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组长度范围为 [1, 10000] 
// 
//
// 
// Related Topics 堆 贪心算法 
// 👍 163 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPossible(int[] nums) {//双哈希表,一个记录剩余数字个数,一个记录数字结尾的序列个数
        HashMap<Integer, Integer> countnum = new HashMap<>();
        HashMap<Integer, Integer> endnum = new HashMap<>();
        for (int i : nums)
            countnum.put(i, countnum.getOrDefault(i, 0) + 1);
        for (int num : nums) {
            int count = countnum.getOrDefault(num, 0);
            if (count > 0) {
                countnum.put(num, count - 1);
                int end = endnum.getOrDefault(num - 1, 0);
                if (end > 0) {
                    endnum.put(num - 1, end - 1);
                    endnum.put(num, endnum.getOrDefault(num, 0) + 1);
                } else {
                    int count1 = countnum.getOrDefault(num + 1, 0);
                    int count2 = countnum.getOrDefault(num + 2, 0);
                    if (count1 > 0 && count2 > 0) {
                        countnum.put(num + 1, count1 - 1);
                        countnum.put(num + 2, count2 - 1);
                        endnum.put(num + 2, endnum.getOrDefault(num + 2, 0) + 1);
                    } else return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
