package leetcode.study.biggroup001.group004.ex0067;

/**
 * @Author : josan
 * @Date : 2020/2/16 10:19
 * @Package : leetcode.study.group004.ex0067
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty() || b == null || b.isEmpty()) {
            throw new IllegalArgumentException("a or b is wrong");
        }

        a = invert(a);
        b = invert(b);

        String c = addBinaryInvert(a, b);

        return invert(c);
    }

    private String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private String addBinaryInvert(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        int i = 0;
        int j = 0;
        while (i < a.length() || j < b.length() || carry > 0) {
            int valueA = i < a.length() ? a.charAt(i) - '0' : 0;
            int valueB = j < b.length() ? b.charAt(j) - '0' : 0;
            int value = (valueA + valueB + carry) % 2;
            sb.append(value);

            carry = (valueA + valueB + carry) / 2;
            i = i < a.length() ? ++i : i;
            j = j < b.length() ? ++j : j;
        }

        return sb.toString();
    }
}
