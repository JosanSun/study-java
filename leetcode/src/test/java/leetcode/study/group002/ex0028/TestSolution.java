package leetcode.study.group002.ex0028;

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
    public void testStrStr() {
        doTestStrStr("hello", "ll", 2);
        doTestStrStr("aaaaa", "bba", -1);
    }

    private void doTestStrStr(String haystack, String needle, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.strStr(haystack, needle));
    }
}
