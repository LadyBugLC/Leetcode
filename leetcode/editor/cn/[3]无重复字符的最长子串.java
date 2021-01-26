//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


//leetcode submit region begin(Prohibit modification and deletion)
//双指针,移动滑块
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 1;
        int maxlen = 1, lens = s.length();
        String s1 = "";
        if(lens>0)
            s1 = s.substring(0, 1);
        while (j < lens) {
            int next = s1.indexOf(s.charAt(j));
            if (next == -1)
                j++;
            else {
                i = next + i+1;
                j++;
            }
            s1 = s.substring(i, j);
            if (s1.length() > maxlen&&next==-1){
                maxlen = s1.length();
                //    System.out.println(s1+i+j);
            }
        }
        if (lens == 0)
            return 0;
        return maxlen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
