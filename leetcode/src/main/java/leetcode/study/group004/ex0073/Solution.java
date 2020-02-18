package leetcode.study.group004.ex0073;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : josan
 * @Date : 2020/2/16 16:56
 * @Package : leetcode.study.group004.ex0073
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("matrix is null");
        }

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }

        for (Integer row : rowSet) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }
        for (Integer column : columnSet) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }
    }
}