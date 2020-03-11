package leetcode.study.equal.util;

import leetcode.study.common.ListNode;

/**
 * @Author : josan
 * @Date : 2020/2/23 22:10
 * @Package : leetcode.study.equal.util
 * @ProjectName: pom-parent
 * @Description:
 */
public class ListNodeHelper {
    public static void assertEqualNode(ListNode lhs, ListNode rhs) {
        while (lhs != null && rhs != null) {
            if (lhs.val == rhs.val) {
                lhs = lhs.next;
                rhs = rhs.next;
            } else {
                break;
            }
        }

        if (lhs != null || rhs != null) {
            System.out.println("They are not equal");
        } else {
            System.out.println("They are equal");
        }
    }

    public static ListNode createListNodeFromArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        ListNode dumpHead = new ListNode(-1);
        ListNode p = dumpHead;
        for (int i = 0; i < nums.length; i++) {
            ListNode tmp = new ListNode(nums[i]);
            p.next = tmp;
            p = p.next;
        }

        return dumpHead.next;
    }
}
