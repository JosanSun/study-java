package leetcode.study.group003.ex0054;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/2/12 16:28
 * @Package : leetcode.study.group003.ex0054
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int minNum = Math.min(m, n);

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= (minNum + 1) / 2; i++) {
            listMatrix(matrix, i - 1, i - 1, m - i + 1, n - i + 1, result);
        }

        return result;
    }

    private void listMatrix(int[][] matrix, int stI, int stJ, int edI, int edJ, List<Integer> result) {
        for (int j = stJ; j < edJ; j++) {
            result.add(matrix[stI][j]);
        }
        for (int i = stI + 1; i < edI; i++) {
            result.add(matrix[i][edJ - 1]);
        }
        if (stI != edI -1) {
            for (int j = edJ - 2; j >= stJ; --j) {
                result.add(matrix[edI - 1][j]);
            }
        }
        if (stJ != edJ - 1) {
            for (int i = edI - 2; i >= stI + 1; --i) {
                result.add(matrix[i][stJ]);
            }
        }
    }
}
