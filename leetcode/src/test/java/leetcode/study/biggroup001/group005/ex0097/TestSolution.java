package leetcode.study.biggroup001.group005.ex0097;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author : josan
 * @Date : 2020/3/3 0:20
 * @Package : leetcode.study.group005.ex0085
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testIsInterleave() {
        doTestIsInterleave("aabcc", "dbbca", "aadbbcbcac", true);
        doTestIsInterleave("aabcc", "dbbca", "aadbbbaccc", false);
    }

    private void doTestIsInterleave(String s1, String s2, String s3, boolean expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.isInterleave(s1, s2, s3));
    }
}
