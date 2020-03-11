package leetcode.study.biggroup001.group002.ex0022;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/2/2 21:07
 * @Package : leetcode.study.ex0001
 * @ProjectName: pom-parent
 * @Description:
 */
public class TestSolution {
    @Test
    public void testGenerateParenthesis() {
        doTestGenerateParenthesis(3, Arrays.asList(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"));
    }

    private void doTestGenerateParenthesis(int n, List<String> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.generateParenthesis(n));
    }
}
