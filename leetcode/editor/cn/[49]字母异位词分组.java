//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 566 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {//将字符串转化为字符数组后排序,作为键值插入哈希表
        HashMap<String, Integer> strmap = new HashMap<>();
        int countgroup = 0;
        ArrayList<List<String>> group = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String sortstr = new String(str);
            int groupnum;
            if (strmap.containsKey(sortstr))
                groupnum = strmap.get(sortstr);
            else {
                groupnum = countgroup;
                strmap.put(sortstr, countgroup);
                group.add(groupnum, new ArrayList<>());
                countgroup++;
            }
            group.get(groupnum).add(strs[i]);
        }
        return group;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
