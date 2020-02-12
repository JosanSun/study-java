package leetcode.study.group003.ex0058;

/**
 * @Author : josan
 * @Date : 2020/2/12 21:59
 * @Package : leetcode.study.group003.ex0058
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        int pos = s.lastIndexOf(' ');
        return s.length() - pos - 1;
    }
}
