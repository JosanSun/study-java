package leetcode.study.biggroup001.group005.ex0085;

import java.util.Stack;

/**
 * @Author : josan
 * @Date : 2020/2/27 0:44
 * @Package : leetcode.study.group005.ex0085
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int M = matrix.length;
        int N = matrix[0].length;

        int[] heights = new int[N];

        int maxArea = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                heights[j] = matrix[i][j] == '1'
                        ? heights[j] + 1 : 0;
            }

            maxArea = Math.max(maxArea, getMaxArea(heights));
        }

        return maxArea;
    }

    private int getMaxArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxArea = -1;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int curHeight = heights[stack.peek()];
                stack.pop();
                maxArea = Math.max(maxArea, curHeight * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int curHeight = heights[stack.peek()];
            stack.pop();
            maxArea = Math.max(maxArea, curHeight * (heights.length - stack.peek() - 1));
        }

        return maxArea;
    }

    public int maximalRectangleNotPass(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("matrix is error");
        }

        int M = matrix.length;
        int N = matrix[0].length;

        int[] maxColumn = new int[N];
        int[] maxRow = new int[N];

        if (matrix[0][N - 1] == '1') {
            maxColumn[N - 1] = 1;
            maxRow[N - 1] = 1;
        } else {
            maxColumn[N - 1] = 0;
            maxRow[N - 1] = 0;
        }
        for (int j = N - 2; j >= 0; j--) {
            if (matrix[0][j] == '1') {
                maxColumn[j] = 1 + maxColumn[j + 1];
                maxRow[j] = 1;
            } else {
                maxColumn[j] = 0;
                maxRow[j] = 0;
            }
        }

        for (int i = 1; i < M; i++) {
            if (matrix[i][N - 1] == '1') {
                maxColumn[N - 1] = 1;
                maxRow[N - 1] = 1 + maxRow[N - 1];
            } else {
                maxColumn[N - 1] = 0;
                maxRow[N - 1] = 0;
            }

            for (int j = N - 2; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    maxColumn[j] = 1 + maxColumn[j + 1];
                    maxRow[j] = 1 + maxRow[j];
                } else {
                    maxColumn[j] = 0;
                    maxRow[j] = 0;
                }
            }
        }

        return 0;
    }
}