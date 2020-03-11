package leetcode.study.biggroup001.group005.ex0081;

/**
 * @Author : josan
 * @Date : 2020/2/21 0:27
 * @Package : leetcode.study.group005.ex0081
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("nums is null");
        }

        if (nums.length == 0) {
            return false;
        }

        return searchInner(nums, 0, nums.length, target);
    }

    private boolean searchInner(int[] nums, int st, int ed, int target) {
        if (ed - st <= 3) {
            for (int i = st; i < ed; i++) {
                if (nums[i] == target) {
                    return true;
                }
            }
            return false;
        }

        int mid = st + (ed - st) / 2;
        boolean result = false;
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] < target){
            if (nums[st] == nums[ed - 1]) {
                result = searchInner(nums, st, mid, target) ||
                        searchInner(nums, mid + 1, ed, target);
            } else {
                if (nums[mid] >= nums[st]) {
                    result = searchInner(nums, mid + 1, ed, target);
                } else {
                    if (target <= nums[ed - 1]) {
                        result = halfSearch(nums, mid + 1, ed, target);
                    } else {
                        result = searchInner(nums, st, mid, target);
                    }
                }
            }
        } else {
            if (nums[st] == nums[ed - 1]) {
                result = searchInner(nums, st, mid, target) ||
                        searchInner(nums, mid + 1, ed, target);
            } else {
                if (nums[mid] >= nums[st]) {
                    if (target >= nums[st]) {
                        result = halfSearch(nums, st, mid, target);
                    } else {
                        result = searchInner(nums, mid + 1, ed, target);
                    }
                } else {
                    result = searchInner(nums, st, mid, target);
                }
            }
        }
        return result;
    }

    private boolean halfSearch(int[] nums, int st, int ed, int target) {
        if (ed - st <= 2) {
            for (int i = st; i < ed; i++) {
                if (nums[i] == target) {
                    return true;
                }
            }
            return false;
        }

        while (ed > st) {
            int mid = st + (ed - st) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                ed = mid;
            }
        }
        return false;
    }
}
