package leetcode.study.biggroup001.group004.ex0066;

/**
 * @Author : josan
 * @Date : 2020/2/15 1:41
 * @Package : leetcode.study.group004.ex0066
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            throw new IllegalArgumentException("digits is wrong");
        }

        boolean hasIncr = checkPlusOne(digits);

        if (hasIncr) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
            for (int i = 1; i < digits.length; i++) {
                digits[i] = 0;
            }
        } else {
            int carry = 1;
            int k = digits.length - 1;
            while (carry != 0) {
                int value = digits[k];
                digits[k] = (value + carry) % 10;
                carry = (value + carry) / 10;
                --k;
            }
        }
        return digits;
    }

    private boolean checkPlusOne(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                return false;
            }
        }
        return true;
    }
}
