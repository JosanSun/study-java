package leetcode.study.week26.ex5336;

/**
 * @Author : josan
 * @Date : 2020/3/7 22:35
 * @Package : leetcode.study.week26.ex5336
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    private static final int N = 26;

    public String sortString(String s) {
        if (s == null || s.length() < 1 || s.length() > 500) {
            throw new IllegalArgumentException("s is wrong");
        }

        int[] chars = new int[N];
        for (int i = 0; i < s.length(); i++) {
            ++chars[s.charAt(i) - 'a'];
        }

        StringBuilder result = new StringBuilder();

        boolean isGoHigh = true;
        doReverse(chars, isGoHigh, result, s.length());
        return result.toString();
    }

    private void doReverse(int[] chars, boolean isGoHigh, StringBuilder result, int len) {
        while (result.length() != len) {
            if (isGoHigh) {
                for (int i = 0; i < N; i++) {
                    if (chars[i] != 0) {
                        result.append((char)(i + 'a'));
                        --chars[i];
                    }
                }
            } else {
                for (int i = N - 1; i >= 0; i--) {
                    if (chars[i] != 0) {
                        result.append((char)(i + 'a'));
                        --chars[i];
                    }
                }
            }
            isGoHigh = !isGoHigh;
        }
    }
}
