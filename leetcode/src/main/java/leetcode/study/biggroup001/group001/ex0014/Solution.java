package leetcode.study.biggroup001.group001.ex0014;

/**
 * @Author : josan
 * @Date : 2020/2/5 22:08
 * @Package : leetcode.study.group001.ex0014
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int commonLen = 0;
        int len1 = strs[0].length();
        for (int i = 0; i < len1; i++) {
            int j = 0;
            for (; j < strs.length - 1; j++) {
                if (i >= strs[j + 1].length()
                    || strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    break;
                }
            }
            if (j < strs.length - 1) {
                break;
            } else {
                ++commonLen;
            }
        }
        return strs[0].substring(0, commonLen);
    }
}
