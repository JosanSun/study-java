package leetcode.study.group004.ex0065;

/**
 * @Author : josan
 * @Date : 2020/2/15 1:54
 * @Package : leetcode.study.group004.ex0065
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty() || s.trim().isEmpty()) {
            return false;
        }
        s = s.trim();

        return firstStatus(s, 0);
    }

    private boolean firstStatus(String s, int pos) {
        if (pos == s.length()) {
            return false;
        }

        char ch = s.charAt(pos++);

        if (ch == '+' || ch == '-') {
            return thirdStatus(s, pos);
        } else if (Character.isDigit(ch)) {
            return secondStatus(s, pos);
        } else if (ch == '.' && pos != s.length()) {
            return fourthStatusFirst(s, pos);
        } else {
            return false;
        }
    }

    /***
     * only  数字
     * @param s
     * @param pos
     * @return
     */
    private boolean secondStatus(String s, int pos) {
        if (pos == s.length()) {
            return true;
        }

        char ch = s.charAt(pos++);
        if (Character.isDigit(ch)) {
            return secondStatus(s, pos);
        } else if (ch == '.') {
            return fourthStatusInner(s, pos);
        } else if (ch == 'e') {
            return fifthStatus(s, pos);
        } else {
            return false;
        }
    }

    /***
     * only +/-
     * @param s
     * @param pos
     * @return
     */
    private boolean thirdStatus(String s, int pos) {
        if (pos == s.length()) {
            return false;
        }

        char ch = s.charAt(pos++);
        if (Character.isDigit(ch)) {
            return secondStatus(s, pos);
        } else if (ch == '.' && pos != s.length()) {
            return fourthStatusInner(s, pos);
        } else {
            return false;
        }
    }

    /***
     * +/-  .1
     * @param s
     * @param pos
     * @return
     */
    private boolean fourthStatusFirst(String s, int pos) {
        if (pos == s.length()) {
            return true;
        }

        char ch = s.charAt(pos++);
        if (Character.isDigit(ch)) {
            return fourthStatusInner(s, pos);
        } else {
            return false;
        }
    }

    /***
     * +/-  .1
     * @param s
     * @param pos
     * @return
     */
    private boolean fourthStatusInner(String s, int pos) {
        if (pos == s.length()) {
            return true;
        }

        char ch = s.charAt(pos++);
        if (Character.isDigit(ch)) {
            return fourthStatusInner(s, pos);
        } else if (ch == 'e') {
            return fifthStatus(s, pos);
        } else {
            return false;
        }
    }

    /***
     * e字母在前
     * @param s
     * @param pos
     * @return
     */
    private boolean fifthStatus(String s, int pos) {
        if (pos == s.length()) {
            return false;
        }

        char ch = s.charAt(pos++);
        if ((ch == '-' || ch == '+') && (pos != s.length())
                || Character.isDigit(ch)) {
            return sixthStatus(s, pos);
        } else {
            return false;
        }
    }

    private boolean sixthStatus(String s, int pos) {
        if (pos == s.length()) {
            return true;
        }

        char ch = s.charAt(pos++);
        if (Character.isDigit(ch)) {
            return sixthStatus(s, pos);
        } else {
            return false;
        }
    }
}
