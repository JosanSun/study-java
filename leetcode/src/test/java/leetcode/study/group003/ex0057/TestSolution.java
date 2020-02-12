package leetcode.study.group003.ex0057;

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
    public void testInsert() {
       doTestInsert(new int[][]{{1,3},{6,9}}, new int[]{2,5},
               new int[][]{{1,5},{6,9}});
        doTestInsert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8},
                new int[][]{{1,2},{3,10},{12,16}});
    }

    private void doTestInsert(int[][] intervals, int[] newInterval, int[][] expected) {
        Solution solution = new Solution();
        Assert.assertArrayEquals("not the same", expected,
                solution.insert(intervals, newInterval));
    }
}
