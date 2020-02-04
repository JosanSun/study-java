package leetcode.study.ex0005;

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
    public void testLongestPalindrome() {
        doTestLongestPalindrome("cbbd", "bb");
        doTestLongestPalindrome("babad", "bab");
    }

    private void doTestLongestPalindrome(String s, String expected) {
        Solution solution = new Solution();
        String result = solution.longestPalindrome(s);

        Assert.assertEquals("not the same", expected, result);
    }
}
