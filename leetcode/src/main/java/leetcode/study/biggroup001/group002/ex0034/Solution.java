package leetcode.study.biggroup001.group002.ex0034;

/**
 * @Author : josan
 * @Date : 2020/2/8 19:59
 * @Package : leetcode.study.group002.ex0034
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1, -1};
        }

        return searchRangeInner(nums, 0, nums.length, target);
    }

    private int[] searchRangeInner(int[] nums, int st, int ed, int target) {
        if (ed - st < 1) {
            return new int[] {-1, -1};
        }
        if (ed - st == 1) {
            return nums[st] == target ? new int[]{st, st} : new int[]{-1, -1};
        }

        int mid = st + (ed - st - 1) / 2;
        if (nums[mid] == target) {
            int left = mid;
            while (left >= st && nums[left] == target) {
                --left;
            }
            int right = mid;
            while (right < ed && nums[right] == target) {
                ++right;
            }
            return new int[]{left + 1, right - 1};
        } else if (nums[mid] < target){
            return searchRangeInner(nums, mid + 1, ed, target);
        } else {
            return searchRangeInner(nums, st, mid, target);
        }
    }
}
