package leetcode.study.group003.ex0056;

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
    public void testMerge() {
       doTestMerge(new int[][]{{1,3},{2,6},{8,10},{15,18}},
               new int[][]{{1,6},{8,10},{15,18}});
        doTestMerge(new int[][]{{1,4},{4,5}},
                new int[][]{{1,5}});
        doTestMerge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}},
                new int[][]{{1,10}});
    }

    private void doTestMerge(int[][] intervals, int[][] expected) {
        Solution solution = new Solution();
        Assert.assertArrayEquals("not the same", expected,
                solution.merge(intervals));
    }
}
