package leetcode.study.biggroup001.group001.ex0017;

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
    public void testLetterCombinations() {
        doTestLetterCombinations("23", Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
    }

    private void doTestLetterCombinations(String digits, List<String> expected) {
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations(digits);

        Assert.assertEquals("not the same", expected, result);
    }
}
