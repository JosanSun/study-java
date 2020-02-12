package leetcode.study.group003.ex0055;

/**
 * @Author : josan
 * @Date : 2020/2/12 17:39
 * @Package : leetcode.study.group003.ex0055
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        } else if (nums.length == 1) {
            return true;
        }

        int remain = nums[0];
        // 特殊情况
        if (remain == 0) {
            return false;
        }
        int i = 1;
        for (; i < nums.length; i++) {
            remain = Math.max(remain - 1, nums[i]);
            if (remain == 0 && i != nums.length - 1) {
                break;
            }
        }
        return !(i < nums.length);
    }
}