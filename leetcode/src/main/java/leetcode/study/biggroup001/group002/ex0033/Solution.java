package leetcode.study.biggroup001.group002.ex0033;

/**
 * @Author : josan
 * @Date : 2020/2/7 17:12
 * @Package : leetcode.study.group002.ex0033
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        return searchInner(nums, 0, nums.length, target);
    }

    private int searchInner(int[] nums, int st, int ed, int target) {
        if (ed - st < 1) {
            return -1;
        }
        if (ed - st == 1) {
            return nums[st] == target ? st : -1;
        }
        if (ed - st == 2) {
            return nums[st] == target ? st :
                    nums[st + 1] == target ? st + 1 : -1;
        }


        if (nums[st] < nums[ed - 1]) {
            return binarySearch(nums, st, ed, target);
        } else {
            int mid = st + (ed - st - 1) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (target <= nums[ed - 1]) {
                    return binarySearch(nums, mid + 1, ed, target);
                } else if (nums[mid] > nums[st]){
                    return searchInner(nums, mid + 1, ed, target);
                } else {
                    return searchInner(nums, st, mid, target);
                }
            } else {
                if (nums[st] <= target) {
                    return binarySearch(nums, st, mid, target);
                } else if (nums[st] > nums[mid]) {
                    return searchInner(nums, st, mid, target);
                } else {
                    return searchInner(nums, mid + 1, ed, target);
                }
            }
        }

    }

    private int binarySearch(int[] nums, int st, int ed, int target) {
        int left = st;
        int right = ed;
        int mid = -1;
        while (left < right) {
            mid = left + (right - left - 1) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left < right ? mid : -1;
    }
}
