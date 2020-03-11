package leetcode.study.biggroup001.group001.ex0006;

/**
 * @Author : josan
 * @Date : 2020/2/3 9:54
 * @Package : leetcode.study.ex0004
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int pos = i;
            int num = 0;
            if (i == 0 || i == numRows - 1) {
                while(pos < s.length()) {
                    sb.append(s.charAt(pos));
                    ++ num;

                    // cal next post
                    pos = i + num * (2 * numRows - 2);
                }
            } else {
                while (pos < s.length()) {
                    sb.append(s.charAt(pos));
                    ++ num;

                    // cal next post
                    if (num % 2 == 0) {
                        pos = i + (2 * numRows - 2) * (num / 2);
                    } else {
                        pos = (2 * numRows - 2 - i) + (2 * numRows - 2) * (num / 2);
                    }
                }
            }
        }

        return sb.toString();
    }
}