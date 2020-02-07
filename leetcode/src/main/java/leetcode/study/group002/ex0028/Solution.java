package leetcode.study.group002.ex0028;

/**
 * @Author : josan
 * @Date : 2020/2/7 0:47
 * @Package : leetcode.study.group002.ex0028
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null) {
            throw new NullPointerException("null exception");
        }
        if (needle.isEmpty()) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            int k = i;
            int j = 0;
            while (k < haystack.length() && j < needle.length()) {
                if (haystack.charAt(k) == needle.charAt(j)) {
                    ++k;
                    ++j;
                } else {
                    break;
                }
            }
            if (j >= needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
