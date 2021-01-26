//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 334 👎 0


import java.util.Arrays;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] alp = new int[26];
        Arrays.fill(alp, -1);
        for (int i = 0; i < s.length(); i++) {
            alp[s.charAt(i) - 'a'] = i;
        }
        Stack<Character> letter = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (letter.contains(s.charAt(i)))
                continue;
            while (!letter.empty() && letter.peek() > s.charAt(i) && alp[letter.peek() - 'a'] > i)
                letter.pop();
            letter.push(s.charAt(i));
        }
        char[] backchar = new char[letter.size()];
        for (int i = backchar.length - 1; i >= 0; i--)
            backchar[i] = letter.pop();
        return String.valueOf(backchar);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
