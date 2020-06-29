//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串


//leetcode submit region begin(Prohibit modification and deletion)
//读入字符串
//1.去除所有除字母数字以外的字符
//2.全转换为大写
//3.从两端向字符串中间开始循环判断,不符合题意标为false.
class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Z^a-z^0-9]", "");
        s = s.toUpperCase();
        //  System.out.println(s2);
        int len = s.length();
        boolean flag = true;
        int a = 0;
        while (flag & a < len - 1) {
            if (s.charAt(a) != s.charAt(len - 1))
                flag = false;
            a++;
            len--;
        }
        //System.out.println(flag);
        return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
