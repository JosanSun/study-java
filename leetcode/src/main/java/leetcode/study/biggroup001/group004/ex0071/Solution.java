package leetcode.study.biggroup001.group004.ex0071;

import java.util.Stack;

/**
 * @Author : josan
 * @Date : 2020/2/16 14:21
 * @Package : leetcode.study.group004.ex0071
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty() || path.charAt(0) != '/') {
            throw new IllegalArgumentException("path is wrong");
        }

        Stack<String> stack = new Stack<>();
        int pos = path.indexOf('/');
        while (pos != -1) {
            int nextPos = path.indexOf('/', pos + 1);
            String word;
            if (nextPos == -1) {
                word = path.substring(pos + 1);
            } else {
                word = path.substring(pos + 1, nextPos);
            }

            pos = nextPos;
            if ("..".equals(word)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (".".equals(word) || "".equals(word)) {
                continue;
            } else {
                stack.push(word);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        } else {
            while(!stack.isEmpty()) {
                String word = stack.pop();
                sb.append(invert(word));
                sb.append("/");
            }
        }
        return invert(sb.toString());
    }

    private String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
