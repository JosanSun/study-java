package leetcode.study.biggroup001.group003.ex0045;

/**
 * @Author : josan
 * @Date : 2020/2/9 22:45
 * @Package : leetcode.study.group003.ex0045
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; --i) {
            int minNum = nums.length;
            for (int j = i + 1; j < nums.length && (j - i) <= nums[i]; j++) {
                minNum = Math.min(minNum, dp[j] + 1);
            }
            dp[i] = minNum;
        }
        return dp[0];
    }
}
