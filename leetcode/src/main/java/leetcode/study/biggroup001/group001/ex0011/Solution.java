package leetcode.study.biggroup001.group001.ex0011;

/**
 * @Author : josan
 * @Date : 2020/2/5 12:26
 * @Package : leetcode.study.ex0011
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    /***
     * 双指针法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxRes = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxRes = Math.max(maxRes, area);
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return maxRes;
    }

    public int maxAreaOrigin(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int[] area = new int[height.length];

        int maxRes = 0;

        for (int i = 0; i < height.length - 1; i++) {
            area[i] = Math.min(height[i], height[i + 1]);
            maxRes = Math.max(maxRes, area[i]);
        }

        for (int len = 2; len < height.length; len++) {
            for (int i = 0; i < height.length - 2; i++) {
                int j = i + len;
                if (j < height.length) {
                    area[i] = Math.max(area[i], Math.min(height[i], height[j]) * len);
                    maxRes = Math.max(maxRes, area[i]);
                }
            }
        }
        return maxRes;
    }

    public int maxAreaNotPass(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int[][] area = new int[height.length][height.length];

        int maxRes = 0;

        for (int i = 0; i < height.length - 1; i++) {
            area[i][i + 1] = Math.min(height[i], height[i + 1]);
            maxRes = Math.max(maxRes, area[i][i + 1]);
        }

        for (int len = 2; len < height.length; len++) {
            for (int i = 0; i < height.length - 2; i++) {
                int j = i + len;
                if (j < height.length) {
                    area[i][j] = Math.max(area[i][j - 1],
                            Math.min(height[i], height[j]) * len);
                    maxRes = Math.max(maxRes, area[i][j]);
                }
            }
        }
        return maxRes;
    }
}
