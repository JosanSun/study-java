package leetcode.study.biggroup001.group001.ex0003;

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
    public void testLengthOfLongestSubstring() {
//        doTestLengthOfLongestSubstring("abcabcbb", 3);
//        doTestLengthOfLongestSubstring("bbbb", 1);
        doTestLengthOfLongestSubstring("pwwkew", 3);
    }

    private void doTestLengthOfLongestSubstring(String s, int expected) {
        Solution solution = new Solution();
        int result = solution.lengthOfLongestSubstring(s);

        Assert.assertEquals("not the same", expected, result);
    }
}
