package leetcode.study.biggroup001.group004.ex0074;

/**
 * @Author : josan
 * @Date : 2020/2/16 17:29
 * @Package : leetcode.study.group004.ex0074
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            throw new IllegalArgumentException("matrix is null");
        }

        int R = matrix.length;
        if (R == 0) {
            return false;
        }
        int C = matrix[0].length;
        if (C == 0) {
            return false;
        }

        boolean result = false;
        int row = 0;
        int col = 0;
        while (row < R) {
            if (matrix[row][col] == target) {
                result = true;
                break;
            }
            if (matrix[row][col] < target) {
                if (row + 1 < R && matrix[row + 1][col] <= target) {
                    ++row;
                } else {
                    ++col;
                    if (col == C) {
                        ++row;
                        col = 0;
                    }
                }
            } else {
                result = false;
                break;
            }

        }
        return result;
    }
}
