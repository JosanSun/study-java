package leetcode.study.biggroup001.group004.ex0076;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author : josan
 * @Date : 2020/2/2 21:07
 * @Package : leetcode.study.ex0001
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testMinWindow() {
        doTestMinWindow("ADOBECODEBANC", "ABC", "BANC");
        doTestMinWindow("bba", "ab", "ba");
        doTestMinWindow("bbaaaaa", "ab", "ba");
        doTestMinWindow("bbaaaaa", "abc", "");
        doTestMinWindow("bbaaaaac", "abc", "baaaaac");
        doTestMinWindow("a", "a", "a");
        doTestMinWindow("abd", "bab", "");
        doTestMinWindow("abd", "dab", "abd");
        doTestMinWindow("cabwefgewcwaefgcf", "cae", "cwae");
    }

    private void doTestMinWindow(String s, String t, String expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.minWindow(s, t));
    }
}
