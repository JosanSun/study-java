package leetcode.study.biggroup001.group003.ex0051;

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
    public void testSolveNQueens() {
       doTestSolveNQueens(4, Arrays.asList(
               Arrays.asList(".Q..", "...Q", "Q...", "..Q."),
               Arrays.asList("..Q.", "Q...", "...Q", ".Q..")));
    }

    private void doTestSolveNQueens(int n, List<List<String>> expected) {
        Solution solution = new Solution();
        Assert.assertEquals("not the same", expected,
                solution.solveNQueens(n));
    }
}
