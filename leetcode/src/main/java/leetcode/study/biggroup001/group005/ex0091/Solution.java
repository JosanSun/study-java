package leetcode.study.biggroup001.group005.ex0091;

/**
 * @Author : josan
 * @Date : 2020/3/7 0:34
 * @Package : leetcode.study.group005.ex0091
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null) {
            throw new IllegalArgumentException("s is null");
        }

        return numDecodingsInner(s);
    }

    private int numDecodingsInner(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) != '0') {
            dp[1] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i + 1] = dp[i];
            }
            if (s.charAt(i - 1) != '0') {
                int value = Integer.valueOf(s.substring(i - 1, i + 1));
                if (value <= 26 && 0 < value) {
                    dp[i + 1] += dp[i - 1];
                }
            }
        }

        return dp[s.length()];
    }
}