package leetcode.study.biggroup001.group005.ex0097;

import java.util.Objects;

/**
 * @Author : josan
 * @Date : 2020/3/7 20:43
 * @Package : leetcode.study.group005.ex0097
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1.isEmpty()) {
            return Objects.equals(s2, s3);
        }

        if (s2 == null || s2.isEmpty()) {
            return Objects.equals(s1, s3);
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return isInterleaveInner(s1, 0, s2, 0, s3, 0);
    }

    private boolean isInterleaveInner(String s1, int st1, String s2, int st2, String s3, int st3) {
        if (st1 == s1.length() && st2 == s2.length()) {
            return true;
        } else if (st1 == s1.length()) {
            return s2.charAt(st2) == s3.charAt(st3) && isInterleaveInner(s1, st1, s2, st2 + 1, s3, st3 + 1);
        } else if(st2 == s2.length()) {
            return s1.charAt(st1) == s3.charAt(st3) && isInterleaveInner(s1, st1 + 1, s2, st2, s3, st3 + 1);
        }

        if (s1.charAt(st1) == s2.charAt(st2)) {
            if (s1.charAt(st1) == s3.charAt(st3)) {
                return isInterleaveInner(s1, st1 + 1, s2, st2, s3, st3 + 1)
                || isInterleaveInner(s1, st1, s2, st2 + 1, s3, st3 + 1);
            } else {
                return false;
            }
        } else {
            if (s1.charAt(st1) == s3.charAt(st3)) {
                return isInterleaveInner(s1, st1 + 1, s2, st2, s3, st3 + 1);
            } else if (s2.charAt(st2) == s3.charAt(st3)){
                return isInterleaveInner(s1, st1, s2, st2 + 1, s3, st3 + 1);
            } else {
                return false;
            }
        }
    }
}
