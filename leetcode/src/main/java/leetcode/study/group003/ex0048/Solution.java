package leetcode.study.group003.ex0048;

/**
 * @Author : josan
 * @Date : 2020/2/10 1:27
 * @Package : leetcode.study.group003.ex0048
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("matrix is null");
        }

        angleRotate(matrix);
        upAndDownSwap(matrix);
    }

    private void angleRotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
            }
        }
    }

    private void upAndDownSwap(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, i, j, n - 1 - i, j);
            }
        }
    }

    private void swap(int[][] matrix, int st1, int ed1, int st2, int ed2) {
        int temp = matrix[st1][ed1];
        matrix[st1][ed1] = matrix[st2][ed2];
        matrix[st2][ed2] = temp;
    }
}

