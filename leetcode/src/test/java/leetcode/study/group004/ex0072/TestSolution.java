package leetcode.study.group004.ex0072;

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
    public void testMinDistance() {
        doTestMinDistance("horse", "ros", 3);
        doTestMinDistance("", "horos", 5);
        doTestMinDistance("horos", "", 5);
        doTestMinDistance("intention", "execution", 5);
        doTestMinDistance("sea", "eat", 2);
    }

    private void doTestMinDistance(String word1, String word2, int expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.minDistance(word1, word2));
    }
}
