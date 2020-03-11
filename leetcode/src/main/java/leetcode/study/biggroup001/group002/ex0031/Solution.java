package leetcode.study.biggroup001.group002.ex0031;

/**
 * @Author : josan
 * @Date : 2020/2/7 13:27
 * @Package : leetcode.study.group002.ex0031
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutationOrigin(int[] nums) {
        if (nums == null || nums.length < 2) {
            return ;
        }

        nextPermutationInner(nums, 0);
    }

    private void nextPermutationInner(int[] nums, int st) {
        if (nums.length - st <= 1) {
            return ;
        }

        int i = st + 1;
        for (; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        if (i < nums.length - 1) {
            nextPermutationInner(nums, st + 1);
        } else {
            if (nums[st] >= nums[st + 1]) {
                reverseArray(nums, st, nums.length);
            } else {
                reverseArray(nums, st + 1, nums.length);
                int left = st + 1;
                while (left < nums.length && nums[st] >= nums[left]) {
                    ++left;
                }
                int temp = nums[st];
                nums[st] = nums[left];
                nums[left] = temp;
            }
        }
    }

    private void reverseArray(int[] nums, int st, int ed) {
        int i = st;
        int j = ed - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            ++i;
            --j;
        }
    }
}