package leetcode.study.group001.ex0003;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : josan
 * @Date : 2020/2/3 9:54
 * @Package : leetcode.study.ex0003
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(s.length());
        int maxLen = 0;
        int prev = 0;
        for (int i = 0; i < s.length(); ) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                ++i;
                int len = i - prev;
                maxLen = Math.max(maxLen, len);
            } else {
                set.remove(s.charAt(prev));
                // TODO: not the ch
//                set.remove(ch);
                ++prev;
            }
        }
        return maxLen;
    }




//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while (i < n && j < n) {
//            // try to extend the range [i, j]
//            if (!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                ans = Math.max(ans, j - i);
//            }
//            else {
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;
//    }

    public int lengthOfLongestSubstring02(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] longestLenFromIdx = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            longestLenFromIdx[i] = 1;
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            int idx = getIdx(s, i + 1, i + 1 + longestLenFromIdx[i + 1], s.charAt(i));
            longestLenFromIdx[i] = idx - i;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < longestLenFromIdx.length; ++i) {
            if (longestLenFromIdx[i] > max) {
                max = longestLenFromIdx[i];
            }
        }

        return max;
    }

    private int getIdx(String s, int st, int ed, char ch) {
        int i = st;
        for ( ; i < ed; i++) {
            if (s.charAt(i) == ch) {
                break;
            }
        }
        return i;
    }

    public int lengthOfLongestSubstringOrigin01(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] longestLenFromIdx = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            longestLenFromIdx[i] = 1;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (notExistsChar(s, i, j, s.charAt(j))) {
                    ++longestLenFromIdx[i];
                } else {
                    break;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < longestLenFromIdx.length; ++i) {
            max = Math.max(longestLenFromIdx[i], max);
        }

        return max;
    }

    private boolean notExistsChar(String s, int st, int ed, char ch) {
        for (int i = st; i < ed; ++i) {
            if (ch == s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
