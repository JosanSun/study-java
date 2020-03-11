package leetcode.study.biggroup001.group004.ex0062;

/**
 * @Author : josan
 * @Date : 2020/2/13 21:42
 * @Package : leetcode.study.group004.ex0062
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] pathNumArray = new int[m][n];

        for (int i = 0; i < m; i++) {
            pathNumArray[i][n - 1] = 1;
        }
        for (int j = 0; j < n; j++) {
            pathNumArray[m - 1][j] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                pathNumArray[i][j] = pathNumArray[i][j + 1] + pathNumArray[i + 1][j];
            }
        }

        return pathNumArray[0][0];
    }
}
