package leetcode.study.group004.ex0072;

/**
 * @Author : josan
 * @Date : 2020/2/16 14:39
 * @Package : leetcode.study.group004.ex0072
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException("word1 or word2 is wrong");
        }

        if (word1.isEmpty()) {
            return word2.length();
        } else if (word2.isEmpty()) {
            return word1.length();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length() + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1] - 1);
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }


    public int minDistanceNotPass(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException("word1 or word2 is wrong");
        }

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        return minDistanceInnerNotPass(chars1, 0, chars2, 0);
    }

    private int minDistanceInnerNotPass(char[] chars1, int st1, char[] chars2, int st2) {
        if (st2 == chars2.length) {
            // 删除操作
            return chars1.length - st1;
        }
        if (st1 == chars1.length) {
            return chars2.length - st2;
        }

        int minDist = Integer.MAX_VALUE;
        if (chars1[st1] != chars2[st2]) {
            // 插入操作
            char[] chars1Tmp = new char[chars1.length + 1];
            int i = 0;
            for (; i < st1; i++) {
                chars1Tmp[i] = chars1[i];
            }
            chars1Tmp[i] = chars2[st2];
            for (; i < chars1.length; ++i) {
                chars1Tmp[i + 1] = chars1[i];
            }
            minDist = Math.min(minDist, minDistanceInnerNotPass(chars1Tmp, st1 + 1, chars2, st2 + 1) + 1);

            // 删除字符
            chars1Tmp = new char[chars1.length - 1];
            i = 0;
            for (; i < st1; i++) {
                chars1Tmp[i] = chars1[i];
            }
            ++i;
            for (; i < chars1.length; ++i) {
                chars1Tmp[i - 1] = chars1[i];
            }
            minDist = Math.min(minDist, minDistanceInnerNotPass(chars1Tmp, st1, chars2, st2) + 1);

            // 替换一个字符
            char ch = chars1[st1];
            chars1[st1] = chars2[st2];
            minDist = Math.min(minDist, minDistanceInnerNotPass(chars1, st1 + 1, chars2, st2 + 1) + 1);
            chars1[st1] = ch;
        } else {
            minDist = Math.min(minDist, minDistanceInnerNotPass(chars1, st1 + 1, chars2, st2 + 1));
        }
        return minDist;
    }
}