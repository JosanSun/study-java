package leetcode.study.group002.ex0032;

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
    public void testLongestValidParentheses() {
        doTestLongestValidParentheses("(()", 2);
        doTestLongestValidParentheses(")()())", 4);
        doTestLongestValidParentheses("()(()", 2);
    }

    private void doTestLongestValidParentheses(String s, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.longestValidParentheses(s));
    }
}
