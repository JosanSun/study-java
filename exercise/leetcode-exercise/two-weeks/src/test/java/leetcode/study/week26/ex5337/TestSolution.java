package leetcode.study.week26.ex5337;

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
    public void testFindTheLongestSubstring() {
        doTestFindTheLongestSubstring("eleetminicoworoep", 13);
        doTestFindTheLongestSubstring("leetcodeisgreat", 5);
        doTestFindTheLongestSubstring("bcbcbc", 6);
        doTestFindTheLongestSubstring("id", 1);
        doTestFindTheLongestSubstring("ideddddd", 5);
        doTestFindTheLongestSubstring("idddddedd", 5);
        doTestFindTheLongestSubstring("ddddddidddddedd", 6);
    }

    private void doTestFindTheLongestSubstring(String s, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.findTheLongestSubstring(s));
    }
}
