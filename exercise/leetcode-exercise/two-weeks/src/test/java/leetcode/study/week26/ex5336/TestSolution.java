package leetcode.study.week26.ex5336;

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
    public void testSortString() {
        doTestSortString("aaaabbbbcccc", "abccbaabccba");
        doTestSortString("rat", "art");
        doTestSortString("leetcode", "cdelotee");
        doTestSortString("ggggggg", "ggggggg");
        doTestSortString("spo", "ops");
    }

    private void doTestSortString(String s, String expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.sortString(s));
    }
}
