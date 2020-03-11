package leetcode.study.biggroup001.group003.ex0058;

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
    public void testLengthOfLastWord() {
       doTestLengthOfLastWord("Hello World", 5);
       doTestLengthOfLastWord("Hello ", 5);
       doTestLengthOfLastWord("s Hllo s", 1);
       doTestLengthOfLastWord("   ", 0);
    }

    private void doTestLengthOfLastWord(String s, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.lengthOfLastWord(s));
    }
}
