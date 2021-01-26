/*
给你两个字符串 a 和 b ，二者均由小写字母组成。一步操作中，你可以将 a 或 b 中的 任一字符 改变为 任一小写字母 。

        操作的最终目标是满足下列三个条件 之一 ：

        a 中的 每个字母 在字母表中 严格小于 b 中的 每个字母 。
        b 中的 每个字母 在字母表中 严格小于 a 中的 每个字母 。
        a 和 b 都 由 同一个 字母组成。

        返回达成目标所需的 最少 操作数。



        示例 1：

        输入：a = "aba", b = "caa"
        输出：2
        解释：满足每个条件的最佳方案分别是：
        1) 将 b 变为 "ccc"，2 次操作，满足 a 中的每个字母都小于 b 中的每个字母；
        2) 将 a 变为 "bbb" 并将 b 变为 "aaa"，3 次操作，满足 b 中的每个字母都小于 a 中的每个字母；
        3) 将 a 变为 "aaa" 并将 b 变为 "aaa"，2 次操作，满足 a 和 b 由同一个字母组成。
        最佳的方案只需要 2 次操作（满足条件 1 或者条件 3）。

        示例 2：

        输入：a = "dabadd", b = "cda"
        输出：3
        解释：满足条件 1 的最佳方案是将 b 变为 "eee" 。



        提示：

        1 <= a.length, b.length <= 105
        a 和 b 只由小写字母组成

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */

class Solution {//step1每次调整a的最大字母或b的最小字母,直到符合要求
    public int minCharacters(String a, String b) {
        int step1 = step(a, b);
        int step2 = step(b, a);
        int[] alpa = new int[26];
        int[] alpb = new int[26];
        Arrays.fill(alpa, 0);
        Arrays.fill(alpb, 0);
        for (int i = 0; i < a.length(); i++)
            alpa[a.charAt(i) - 'a']++;
        for (int i = 0; i < b.length(); i++)
            alpb[b.charAt(i) - 'a']++;
        int alp = -1;
        int alpnum = -1;
        for (int i = 0; i < 26; i++) {
            if (alpa[i] + alpb[i] > alpnum) {
                alp = i;
                alpnum = alpa[i] + alpb[i];
            }
        }
        int step3 = 0;
        for (int i = 0; i < 26; i++) {
            if (i == alp)
                continue;
            step3 = step3 + alpa[i] + alpb[i];
        }
        return Math.min(Math.min(step1, step2), step3);
    }

    public int step(String a, String b) {
        int[] alpa = new int[26];
        int[] alpb = new int[26];
        Arrays.fill(alpa, 0);
        Arrays.fill(alpb, 0);
        for (int i = 0; i < a.length(); i++)
            alpa[a.charAt(i) - 'a']++;
        for (int i = 0; i < b.length(); i++)
            alpb[b.charAt(i) - 'a']++;
        int step1 = 0;
        int maxa = -1, minb = -1;
        for (int i = 25; i >= 0; i--)
            if (alpa[i] != 0) {
                maxa = i;
                break;
            }
        for (int i = 0; i < 26; i++)
            if (alpb[i] != 0) {
                minb = i;
                break;
            }
        while (maxa >= minb) {
            int changea = 0;
            for (int i = maxa; i > 0; i--)
                changea += alpb[i];
            if (maxa == 0)
                changea = 0;

            int changeb = 0;
            for (int i = minb; i < 25; i++)
                changeb += alpa[i];
            if (minb == 25)
                changeb = 0;

            if (changea > changeb) {
                alpa[maxa]--;
                alpa[0]++;
            } else {
                alpb[minb]--;
                alpb[25]++;
            }
            for (int i = 25; i >= 0; i--)
                if (alpa[i] != 0) {
                    maxa = i;
                    break;
                }
            for (int i = 0; i < 26; i++)
                if (alpb[i] != 0) {
                    minb = i;
                    break;
                }
            step1++;
        }
        return step1;
    }
}
