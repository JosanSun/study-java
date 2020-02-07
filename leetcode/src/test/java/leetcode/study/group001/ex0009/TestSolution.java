package leetcode.study.group001.ex0009;

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
    public void testIsPalindrome() {
        doTestIsPalindrome(121, true);
        doTestIsPalindrome(-121, false);
        doTestIsPalindrome(10, false);
    }

    private void doTestIsPalindrome(int x, boolean expected) {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(x);

        Assert.assertEquals("not the same", expected, result);
    }
}
