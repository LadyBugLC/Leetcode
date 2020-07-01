//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串


//leetcode submit region begin(Prohibit modification and deletion)
//逐位相加,next表示进位
class Solution {
    public String addBinary(String a, String b) {
        String add = "";
        int lena = a.length(), lenb = b.length();
        int numa = 0, numb = 0, next = 0;
        while (lena > 0 | lenb > 0) {
            numa = numb = 0;
            if (lena > 0)
                numa = a.charAt(lena - 1) - '0';
            if (lenb > 0)
                numb = b.charAt(lenb - 1) - '0';
            if (next + numa + numb > 1) {
                add = (next + numa + numb - 2) + add;
                next = 1;
            } else {
                add = (next + numa + numb) + add;
                next = 0;
            }
            lena--;
            lenb--;
        }
        if (next == 1)
            add = 1 + add;
        while (add.length() > 0 && add.charAt(0) == '0')
            add = add.substring(1);
        if (add.length() == 0)
            add = "0";
        return add;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
