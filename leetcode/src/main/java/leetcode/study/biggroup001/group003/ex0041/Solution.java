package leetcode.study.biggroup001.group003.ex0041;

/**
 * @Author : josan
 * @Date : 2020/2/9 11:46
 * @Package : leetcode.study.group003.ex0041
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int result = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }

            if (nums[i] == result) {
                result = fixResult(nums, i, result);
            }
        }
        return result;
    }

    private int fixResult(int[] nums, int ed, int origin) {
        while (true) {
            int next = ++origin;
            int i = 0;
            for (; i < ed; i++) {
                if (next == nums[i]) {
                    break;
                }
            }
            if (i >= ed) {
                return next;
            }
        }
    }
}