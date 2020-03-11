package leetcode.study.biggroup001.group003.ex0059;

/**
 * @Author : josan
 * @Date : 2020/2/12 22:10
 * @Package : leetcode.study.group003.ex0059
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n is wrong");
        }

        int[][] matrix = new int[n][n];

        int startNum = 1;

        for (int i = 1; i <= (n + 1) / 2; i++) {
            startNum = fillOneCircle(matrix, i - 1, i - 1,
                    n - i + 1, n - i + 1, startNum);
        }

        return matrix;
    }

    private int fillOneCircle(int[][] matrix, int stI, int stJ, int edI, int edJ, int startNum) {
        for (int j = stJ; j < edJ; j++) {
            matrix[stI][j] = startNum++;
        }
        for (int i = stI + 1; i < edI; i++) {
            matrix[i][edJ - 1] = startNum++;
        }
        if (edI - 1 != stI) {
            for (int j = edJ - 2; j >= stJ; j--) {
                matrix[edI - 1][j] = startNum++;
            }
        }
        if (edJ - 1 != stJ) {
            for (int i = edI - 2; i > stI; --i) {
                matrix[i][stJ] = startNum++;
            }
        }
        return startNum;
    }
}
