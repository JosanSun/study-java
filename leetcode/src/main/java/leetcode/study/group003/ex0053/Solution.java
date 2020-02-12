package leetcode.study.group003.ex0053;

/**
 * @Author : josan
 * @Date : 2020/2/12 16:00
 * @Package : leetcode.study.group003.ex0053
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums is error");
        }

        int result = nums[0];
        int[] maxArray = new int[nums.length];
        maxArray[0] = nums[0];


        for (int i = 1; i < nums.length; i++) {
            // 这个其实就是nums[i-1]>0就行
            maxArray[i] = Math.max(nums[i], nums[i] + maxArray[i -1]);
            result = Math.max(result, maxArray[i]);
        }

        return result;
    }
}
