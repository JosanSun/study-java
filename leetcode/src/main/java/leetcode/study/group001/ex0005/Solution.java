package leetcode.study.group001.ex0005;

/**
 * @Author : josan
 * @Date : 2020/2/3 9:54
 * @Package : leetcode.study.ex0004
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    public String longestPalindromeOrigin(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        boolean[][] flags = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            flags[i][i] = true;
        }

        for (int j = 1; j < s.length(); j++) {
            flags[j - 1][j] = s.charAt(j -1) == s.charAt(j);
        }

        for (int searchLen = 3; searchLen <= s.length(); searchLen++) {
            int st = 0;
            int ed = searchLen - 1;
            while (st < s.length() && ed < s.length()) {
                flags[st][ed] = flags[st + 1][ed - 1] && (s.charAt(st) == s.charAt(ed));
                ++st;
                ed = searchLen - 1 + st;
            }
        }

        int maxLen = -1;
        int st = -1;
        int ed = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (flags[i][j] && maxLen <= j - i + 1) {
                    maxLen = j - i + 1;
                    st = i;
                    ed = j;
                }
            }
        }

        return s.substring(st, ed + 1);
    }
}