package leetcode.study.group001.ex0020;

import java.util.Stack;

/**
 * @Author : josan
 * @Date : 2020/2/6 14:59
 * @Package : leetcode.study.group001.ex0020
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || !isMatch(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatch(char left, char right) {
        if ((right == ')' && left == '(')
            || (right == ']' && left == '[')
            || (right == '}' && left == '{')) {
            return true;
        }
        return false;
    }
}
