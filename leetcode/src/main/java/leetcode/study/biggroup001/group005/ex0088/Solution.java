package leetcode.study.biggroup001.group005.ex0088;

/**
 * @Author : josan
 * @Date : 2020/3/6 23:03
 * @Package : leetcode.study.group005.ex0088
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null) {
            throw new IllegalArgumentException("nums1 is null");
        }

        if (nums2 == null || n == 0) {
            return ;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return ;
        }

        int m1 = m - 1;
        int n1 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (m1 < 0) {
                while (i >= 0) {
                    nums1[i--] = nums2[n1 --];
                }
            } else if (n1 < 0) {
                break;
            } else {
                if (nums1[m1] > nums2[n1]) {
                    nums1[i] = nums1[m1];
                    --m1;
                } else {
                    nums1[i] = nums2[n1];
                    --n1;
                }
            }
        }
    }
}
