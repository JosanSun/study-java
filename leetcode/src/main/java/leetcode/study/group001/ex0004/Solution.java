package leetcode.study.group001.ex0004;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/2/3 9:54
 * @Package : leetcode.study.ex0004
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("nums1 or nums2 cannot be null");
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (findKThElement(nums1, nums2, (nums1.length + nums2.length) / 2) +
                    findKThElement(nums1, nums2, (nums1.length + nums2.length) / 2 + 1)) / 2.0;
        } else {
            return findKThElement(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
        }
    }

    private int findKThElement(int[] nums1, int[] nums2, int k) {
        if (k <= 0 || k > nums1.length + nums2.length) {
           throw new IllegalArgumentException("k is wrong");
        }

        int i = 0;
        int j = 0;
        while (i + j < k) {
            if (i < nums1.length && j < nums2.length && nums1[i] < nums2[j]
                || j >= nums2.length) {
                ++i;
            } else {
                ++j;
            }
        }

        int numLeft = i == 0 ? Integer.MIN_VALUE : nums1[i -1];
        int numRight = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];

        return Math.max(numLeft, numRight);




//        int i = 0;
//        int j = 0;
//
//        while(i + j < k) {
//            if ((i < nums1.length && j < nums2.length && nums1[i] < nums2[j])
//                || j >= nums2.length) {
//                ++i;
//            } else {
//                ++j;
//            }
//        }
//
//        if (i == 0) {
//            return nums2[j - 1];
//        } else if (j == 0) {
//            return nums1[i - 1];
//        } else {
//            return Math.max(nums1[i - 1], nums2[j - 1]);
//        }
    }




    public double findMedianSortedArraysfailed(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        return findMedianSortedArraysfailed(nums1, 0, nums1.length, nums2, 0, nums2.length);
    }

    private double findMedianSortedArraysfailed(int[] nums1, int st1, int ed1,
                                                int[] nums2, int st2, int ed2) {
        if (ed1 - st1 <= 2) {
            List<Integer> list = new ArrayList<>(ed1 - st1 + ed2 - st2);
            for (int i = st1; i < ed1; ++i) {
                list.add(nums1[i]);
            }
            for (int i = st2; i < ed2; ++i) {
                list.add(nums2[i]);
            }
            list.sort(Comparator.comparingInt(a -> a));

            if ((list.size() & 1) == 0) {
                return (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0;
            } else {
                return list.get(list.size() / 2);
            }
        }

        int median1Pos = st1 + (ed1 - st1) / 2;
        int median1 = nums1[median1Pos];
        int median2Pos = st2 + (ed2 - st2) / 2;
        int median2 = nums2[median2Pos];
        if (median1 < median2) {
            int len1 = median1Pos - st1;
            int len2 = ed2 - median2Pos - 1;
            if (len1 <= len2) {
                return findMedianSortedArraysfailed(nums1, median1Pos, ed1,
                        nums2, st2, ed2 - (median1Pos - st1));
            } else {
                return findMedianSortedArraysfailed(nums1, st1 + (ed2 - median2Pos - 1), ed1,
                        nums2, st2, median2Pos + 1);
            }
        } else if (median1 > median2
                || (median1 == median2 && ((ed1 - st1) % 2) == 0)) {
            int len1 = ed1 - median1Pos - 1;
            int len2 = median2Pos - st2;
            if (len1 <= len2) {
                return findMedianSortedArraysfailed(nums1, st1, median1Pos + 1,
                        nums2, st2 + (ed1 - median1Pos - 1), ed2);
            } else {
                return findMedianSortedArraysfailed(nums1, st1, ed1 - (median2Pos - st2),
                        nums2, median2Pos, ed2);
            }
        } else {
            return median1;
        }
    }
}