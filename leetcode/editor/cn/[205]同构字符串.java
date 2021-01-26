//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表 
// 👍 281 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] alpa = new int[126];
        int[] alpb = new int[126];
        Arrays.fill(alpa, -1);
        Arrays.fill(alpb, -1);
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - '0';
            int b = t.charAt(i) - '0';
            if (alpa[a] == -1 && alpb[b] == -1) {
                alpa[a] = b;
                alpb[b] = a;
            } else if (alpa[a] != b || alpb[b] != a)
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
