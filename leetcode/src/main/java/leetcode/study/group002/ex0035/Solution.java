package leetcode.study.group002.ex0035;

/**
 * @Author : josan
 * @Date : 2020/2/8 20:40
 * @Package : leetcode.study.group002.ex0035
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("nums can not be null");
        }
        if (nums.length == 0) {
            return 0;
        }

        int pos = 0;
        while(pos < nums.length && nums[pos] < target) {
            ++pos;
        }
        return pos;
    }
}