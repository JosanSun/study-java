package leetcode.study.biggroup001.group001.ex0010;

/**
 * @Author : josan
 * @Date : 2020/2/3 9:54
 * @Package : leetcode.study.ex0004
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        return isMatch(text, 0, pattern, 0);
    }

    private boolean isMatch(String text, int st1, String pattern, int st2) {
        if (st2 == pattern.length()) {
            return st1 == text.length();
        }

        boolean first_match = (st1 != text.length() &&
                (pattern.charAt(st2) == text.charAt(st1) || pattern.charAt(st2) == '.'));

        if (st2 + 1 < pattern.length() && pattern.charAt(st2 + 1) == '*'){
            return (isMatch(text, st1, pattern, st2 + 2) ||
                    (first_match && isMatch(text, st1 + 1, pattern, st2)));
        } else {
            return first_match && isMatch(text, st1 + 1, pattern, st2 + 1);
        }
    }


    public boolean isMatchOrigin(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        return isMatchOrigin(s, 0, p, 0);
    }

    private boolean isMatchOrigin(String s, int st1, String p, int st2) {
        if (!(st1 < s.length())) {
            char nextCh = 0;
            if (st2 + 1 < p.length()) {
                nextCh = p.charAt(st2 + 1);
            }
            if (nextCh == '*') {
                return isMatch(s, st1, p, st2 + 2);
            } else {
                return !(st2 < p.length());
            }
        }
        if (!(st2 < p.length())) {
            return !(st1 < s.length());
        }

        char ch = p.charAt(st2);
        boolean mutliMatch = false;
        char nextCh = 0;
        if (st2 + 1 < p.length()) {
            nextCh = p.charAt(st2 + 1);
        }
        if (nextCh == '*') {
            mutliMatch = true;
        }

        if (mutliMatch) {
            if (st1 < s.length() &&
                    (s.charAt(st1) == ch || ch == '.')) {
                return isMatch(s, st1, p, st2 + 2) || isMatch(s, st1 + 1, p, st2);
            } else {
                return isMatch(s, st1, p, st2 + 2);
            }
        } else {
            if (st1 < s.length()
                    && (s.charAt(st1) == ch || ch == '.')) {
                return isMatch(s, st1 + 1, p, st2 + 1);
            } else {
                return false;
            }
        }
    }
}