package leetcode.study.biggroup001.group005.ex0087;

/**
 * @Author : josan
 * @Date : 2020/3/4 0:40
 * @Package : leetcode.study.group005.ex0087
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("s1 or s2 is error");
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len + 1];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int lenK = 2; lenK <= len; lenK++) {
            for (int i = 0; i <= len - lenK; i++) {
                for (int j = 0; j <= len - lenK; j++) {
                    for (int k = 1; k < lenK; k++) {
                        dp[i][j][lenK] = (dp[i][j][k] && dp[i + k][j + k][lenK - k])
                                || (dp[i][j + lenK - k][k] && dp[i + k][j][lenK - k]);
                        if (dp[i][j][lenK]) {
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][len];
    }


    public boolean isScrambleNotPass(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("s1 or s2 is error");
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        return isScrambleInnerNotPass(s1, s2, 0, s1.length());
    }

    private boolean isScrambleInnerNotPass(String s1, String s2, int st, int ed) {
        if (ed - st <= 2) {
            return isScrambleComparable(s1, s2, st, ed);
        }

        int mid = st + (ed - st) / 2;
        return (isScrambleInnerNotPass(s1, s2, st, mid) && isScrambleInnerNotPass(s1, s2, mid, ed))
                || (isScrambleInnerNotPass(s1, s2, st, mid + 1) && isScrambleInnerNotPass(s1, s2, mid + 1, ed));
    }

    private boolean isScrambleComparable(String s1, String s2, int st, int ed) {
        int len = ed - st;
        if (len == 0) {
            return true;
        } else if (len == 1 && s1.charAt(st) == s2.charAt(st)) {
            return true;
        } else if (len == 2) {
            if ((s1.charAt(st) == s2.charAt(st) && s1.charAt(st + 1) == s2.charAt(st + 1))
                || (s1.charAt(st + 1) == s2.charAt(st) && s1.charAt(st) == s2.charAt(st + 1))) {
                return true;
            }
        }
        return false;
    }
}
