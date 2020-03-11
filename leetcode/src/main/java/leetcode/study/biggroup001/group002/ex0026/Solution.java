package leetcode.study.biggroup001.group002.ex0026;

/**
 * @Author : josan
 * @Date : 2020/2/6 22:36
 * @Package : leetcode.study.group002.ex0026
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[result - 1]) {
                nums[result++] = nums[i];
            }
        }
        return result;
    }
}