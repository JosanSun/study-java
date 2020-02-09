package leetcode.study.group002.ex0032;

/**
 * @Author : josan
 * @Date : 2020/2/7 15:05
 * @Package : leetcode.study.group002.ex0032
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '(') {
                result = Math.max(result, longestValidParenthesesInner(s, i, 0, 0));
            }
        }
        return result;
    }

    private int longestValidParenthesesInner(String s, int st, int left, int right) {
        if (st >= s.length()) {
            return left == right ? left + right : 0;
        }

        char ch = s.charAt(st);
        if (ch == '(') {
            ++left;
            return longestValidParenthesesInner(s, st + 1, left, right);
        } else {
            ++right;
            if (left == right) {
                int nextSt = st + 1;
                if (nextSt < s.length() && s.charAt(nextSt) == '(') {
                    return left + right + longestValidParenthesesInner(s, st + 1, 0, 0);
                } else {
                    return left + right;
                }
            } else {
                return longestValidParenthesesInner(s, st + 1, left, right);
            }
        }
    }
}