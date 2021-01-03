//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 322 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        int[] place = new int[26];//-1表示未出现 -2表示重复出现
        Arrays.fill(place, -1);
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (place[tmp - 'a'] == -1)
                place[tmp - 'a'] = i;
            else place[tmp - 'a'] = -2;
        }
        int ans = s.length();
        for (int i = 0; i < 26; i++)
            if (place[i] > -1 && place[i] < ans)
                ans = place[i];
        if (ans == s.length())
            ans = -1;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
