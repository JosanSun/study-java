package leetcode.study.group002.ex0038;

/**
 * @Author : josan
 * @Date : 2020/2/9 0:45
 * @Package : leetcode.study.group002.ex0038
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String str = countAndSay(n - 1);
        return getNextString(str);
    }

    private String getNextString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length();) {
            char ch = str.charAt(i);
            int pos = i;
            while (pos < str.length() && ch == str.charAt(pos)) {
                ++pos;
            }
            int num = pos - i;
            sb.append(String.valueOf(num));
            sb.append(ch);
            i = pos;
        }
        return sb.toString();
    }
}