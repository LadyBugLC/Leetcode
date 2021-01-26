//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
// Related Topics 字符串 动态规划 回溯算法

//f[i][j] 表示 s 的前 i 个字符与 p 中的前 j 个字符是否能够匹配,动态规划
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        if (i == 0)
            return false;
        if (p.charAt(j - 1) == '.')
            return true;
        return p.charAt(j - 1) == s.charAt(i - 1);
    }
    public boolean isMatch(String s, String p) {
        int lens = s.length(), lenp = p.length();
        boolean[][] flag = new boolean[lens + 1][lenp + 1];
        flag[0][0] = true;
        for (int i = 0; i <= lens; i++)
            for (int j = 1; j <= lenp; j++) {
                if (p.charAt(j - 1) != '*') {
                    if (match(s, p, i, j))
                        flag[i][j] = flag[i - 1][j - 1];
                    else flag[i][j] = false;
                }
                else{
                    if(match(s,p,i,j-1)){
                        flag[i][j]=flag[i-1][j]|flag[i][j-2];
                    }
                    else flag[i][j]=flag[i][j-2];
                }
            }
        return flag[lens][lenp];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
