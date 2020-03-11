package leetcode.study.week26.ex5337;

/**
 * @Author : josan
 * @Date : 2020/3/7 22:55
 * @Package : leetcode.study.week26.ex5337
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int findTheLongestSubstring(String s) {
        if (s == null || s.length() < 1 || s.length() > 500000) {
            throw new IllegalArgumentException("s is wrong");
        }

        int maxLen = -1;
        int len = 0;
        int[] chars = new int[26];

        int st = findNextYuanYin(s, 0);
        if (st == -1) {
            return s.length();
        }

        int prevYuanYinPos = -1;
        for (int i = st; i < s.length() && i != -1; ) {
            for (int j = i; j < s.length() && j != -1; ) {
                ++chars[s.charAt(j) - 'a'];
                if (isOdd(chars)) {
                    int k = findNextYuanYin(s, j + 1);
                    if (k == -1) {
                        maxLen = Math.max(maxLen, s.length() - prevYuanYinPos - 1);
                    } else {
                        maxLen = Math.max(maxLen, k - prevYuanYinPos - 1);
                    }
                }
                j = findNextYuanYin(s, j + 1);
            }
            init(chars);
            prevYuanYinPos = i;
            i = findNextYuanYin(s, i + 1);
        }

        prevYuanYinPos = -1;
        if (maxLen == -1) {
            int i = findNextYuanYin(s, 0);
            while (i < s.length() && i != -1) {
                maxLen = Math.max(maxLen, i - prevYuanYinPos - 1);
                prevYuanYinPos = i;
                i = findNextYuanYin(s, i + 1);
            }
            maxLen = Math.max(maxLen, s.length() - prevYuanYinPos - 1);
        }

        return maxLen;
    }

    private void init(int[] chars) {
        chars['a' - 'a'] = 0;
        chars['e' - 'a'] = 0;
        chars['i' - 'a'] = 0;
        chars['o' - 'a'] = 0;
        chars['u' - 'a'] = 0;
    }

    private boolean isOdd(int[] chars) {
        return chars['a' - 'a'] % 2 == 0 &&  chars['e' - 'a'] % 2 == 0 && chars['i' - 'a'] % 2 == 0
                && chars['o' - 'a'] % 2 == 0 && chars['u' - 'a'] % 2 == 0;
    }

    private boolean isYuanYin(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private int findNextYuanYin(String s, int st) {
        int i = st;
        for ( ; i < s.length(); i++) {
            if (isYuanYin(s.charAt(i))) {
                break;
            }
        }
        return i < s.length() ? i : -1;
    }
}
