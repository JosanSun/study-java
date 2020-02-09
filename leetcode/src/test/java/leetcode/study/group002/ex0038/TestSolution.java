package leetcode.study.group002.ex0038;

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
    public void testCountAndSay() {
//        doTestCountAndSay(1, "1");
        doTestCountAndSay(2, "11");
        doTestCountAndSay(4, "1211");
        doTestCountAndSay(5, "111221");
        doTestCountAndSay(9, "31131211131221");
        doTestCountAndSay(20, "11131221131211132221232112111312111213111213211231132132211211131221131211221321123113213221123113112221131112311332211211131221131211132211121312211231131112311211232221121321132132211331121321231231121113112221121321133112132112312321123113112221121113122113121113123112112322111213211322211312113211");
    }

    private void doTestCountAndSay(int n, String expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.countAndSay(n));
    }
}
