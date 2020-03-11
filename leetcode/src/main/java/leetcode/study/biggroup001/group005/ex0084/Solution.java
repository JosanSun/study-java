package leetcode.study.biggroup001.group005.ex0084;

import java.util.Stack;

/**
 * @Author : josan
 * @Date : 2020/2/25 1:00
 * @Package : leetcode.study.group005.ex0084
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null) {
            throw new IllegalArgumentException("heights is null");
        }

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


    public int largestRectangleArea02(int[] heights) {
        if (heights == null) {
            throw new IllegalArgumentException("heights is null");
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return maxArea;
    }


    public int largestRectangleAreaOrigin(int[] heights) {
        if (heights == null) {
            throw new IllegalArgumentException("heights is null");
        }

        return largestRectangleAreaInner(heights, 0, heights.length);
    }

    private int largestRectangleAreaInner(int[] heights, int st, int ed) {
        if (ed == st) {
            return 0;
        }
        if (ed - st == 1) {
            return heights[st];
        }

        int mid = st + (ed - st) / 2;

        int maxAreaLeft = largestRectangleAreaInner(heights, st, mid);
        int maxAreaRight = largestRectangleAreaInner(heights, mid + 1, ed);

        int leftPos = mid - 1;
        int rightPos = mid + 1;
        int curWidth = 1;
        int curHeight = heights[mid];
        int maxArea = curWidth * curHeight;
        while (leftPos >= st || rightPos < ed) {
            int leftValue = leftPos >= st ? heights[leftPos] : -1;
            int rightValue = rightPos < ed ? heights[rightPos] : -1;
            ++curWidth;
            if (leftValue > rightValue) {
                if (leftValue <= curHeight) {
                    curHeight = leftValue;
                }
                maxArea = Math.max(maxArea, curHeight * curWidth);
                --leftPos;
            } else {
                if (rightValue <= curHeight) {
                    curHeight = rightValue;
                }
                maxArea = Math.max(maxArea, curHeight * curWidth);
                ++rightPos;
            }
        }

        return Math.max(maxArea, Math.max(maxAreaLeft, maxAreaRight));
    }
}
