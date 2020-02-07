package leetcode.study.group002.ex0027;

/**
 * @Author : josan
 * @Date : 2020/2/7 0:37
 * @Package : leetcode.study.group002.ex0027
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}