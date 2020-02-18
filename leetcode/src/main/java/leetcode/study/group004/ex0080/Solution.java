package leetcode.study.group004.ex0080;

/**
 * @Author : josan
 * @Date : 2020/2/19 2:32
 * @Package : leetcode.study.group004.ex0080
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        return removeDuplicatesInner(nums, 2);
    }

    private int removeDuplicatesInner(int[] nums, int maxSameNum) {
        if (nums == null) {
            throw new IllegalArgumentException("nums is null");
        }

        int st = 0;
        int tempSameNum = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++st] = nums[i];
                tempSameNum = 1;
            } else {
                ++tempSameNum;
                if (tempSameNum <= maxSameNum) {
                    nums[++st] = nums[i];
                }
            }
        }

        return st + 1;
    }
}