package leetcode.study.group001.ex0014;

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
    public void testLongestCommonPrefix() {
        doTestLongestCommonPrefix(new String[]{"flower", "flow", "flight"}, "fl");
        doTestLongestCommonPrefix(new String[]{"dog", "racecar", "car"}, "");
        doTestLongestCommonPrefix(new String[]{"aa", "a"}, "a");
    }

    private void doTestLongestCommonPrefix(String[] strs, String expected) {
        Solution solution = new Solution();
        String result = solution.longestCommonPrefix(strs);

        Assert.assertEquals("not the same", expected, result);
    }
}
