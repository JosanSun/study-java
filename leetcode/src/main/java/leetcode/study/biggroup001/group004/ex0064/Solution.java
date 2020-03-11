package leetcode.study.biggroup001.group004.ex0064;

/**
 * @Author : josan
 * @Date : 2020/2/15 1:28
 * @Package : leetcode.study.group004.ex0064
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            throw new IllegalArgumentException("grid is wrong");
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        // region init dp
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // endregion

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
