package leetcode.study.group004.ex0063;

/**
 * @Author : josan
 * @Date : 2020/2/13 21:52
 * @Package : leetcode.study.group004.ex0063
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            throw new IllegalArgumentException("obstacleGrid is wrong");
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // 特殊情况
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        
        int[][] dp = new int[m][n];

        // region init dp
        dp[m - 1][n - 1] = 1;
        for (int i = m - 2; i >= 0; --i) {
            if (obstacleGrid[i][n - 1] != 1) {
                dp[i][n - 1] = dp[i + 1][n - 1];
            } else {
                dp[i][n - 1] = 0;
            }
        }
        for (int j = n - 2; j >= 0; j--) {
            if (obstacleGrid[m - 1][j] != 1) {
                dp[m - 1][j] = dp[m - 1][j + 1];
            } else {
                dp[m - 1][j] = 0;
            }
        }
        // endregion

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[0][0];
    }
}
