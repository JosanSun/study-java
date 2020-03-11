package leetcode.study.biggroup001.group005.ex0087;

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
    public void testIsScramble() {
        doTestIsScramble("great", "rgeat", true);
        doTestIsScramble("abcde", "caebd", false);
        doTestIsScramble("abb", "bab", true);
        doTestIsScramble("abb", "bba", true);
    }

    private void doTestIsScramble(String s1, String s2, boolean expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.isScramble(s1, s2));
    }
}
