//你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatg
//o"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相
//同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。 
//
// 示例 1： 
//
// 输入： pattern = "abba", value = "dogcatcatdog"
//输出： true
// 
//
// 示例 2： 
//
// 输入： pattern = "abba", value = "dogcatcatfish"
//输出： false
// 
//
// 示例 3： 
//
// 输入： pattern = "aaaa", value = "dogcatcatdog"
//输出： false
// 
//
// 示例 4： 
//
// 输入： pattern = "abba", value = "dogdogdogdog"
//输出： true
//解释： "a"="dogdog",b=""，反之也符合规则
// 
//
// 提示： 
//
// 
// 1 <= len(pattern) <= 1000 
// 0 <= len(value) <= 1000 
// 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。 
// 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
//暴力解法,为a.b赋值
class Solution {
    public boolean patternMatching(String pattern, String value) {
        int lenp = p.length();
        int lenv = v.length();
        String a = "anull";
        String b = "bnull";
        int lena = 0, lenb = 0;
        String v2 = "";
        int suma=0,sumb=0;
        for(int i=0;i<lenp;i++){
            if (p.charAt(i) == 'a')
                suma++;
            if (p.charAt(i) == 'b')
                sumb++;
        }
        for (; lenb <= lenv; lenb++) {
            lena=0;
            for (; lena <= lenv; lena++) {
                a = "anull";
                b = "bnull";
                v2 = "";
                if(suma*lena+sumb*lenb<=lenv) {
                    for (int i = 0; i < lenp; i++) {
                        if (p.charAt(i) == 'a') {
                            if (a.equals("anull"))
                                a = v.substring(v2.length(), v2.length() + lena);
                            v2 = v2 + a;
                        }
                        if (p.charAt(i) == 'b') {
                            if (b.equals("bnull"))
                                b = v.substring(v2.length(), v2.length() + lenb);
                            v2 = v2 + b;
                        }
                    }
                    if (v2.equals(v)&!a.equals(b))
                        return true;
                }
            }
        }
        if (v2.equals(v)&!a.equals(b))
            return true;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
