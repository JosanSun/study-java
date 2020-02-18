package leetcode.study.group004.ex0075;

/**
 * @Author : josan
 * @Date : 2020/2/16 17:47
 * @Package : leetcode.study.group004.ex0075
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public void sortColors(int[] nums) {
        int stOne = 0;
        int stTwo = nums.length - 1;

        for (int i = 0; i < nums.length && i <= stTwo; ) {
            if (nums[i] == 0) {
                swap(nums, i, stOne);
                ++stOne;
            } else if (nums[i] == 2) {
                swap(nums, i, stTwo);
                --stTwo;
                --i;
            }
            ++i;
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int value = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = value;
    }
}
