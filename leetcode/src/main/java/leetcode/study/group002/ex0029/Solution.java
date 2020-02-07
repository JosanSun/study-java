package leetcode.study.group002.ex0029;

/**
 * @Author : josan
 * @Date : 2020/2/7 10:01
 * @Package : leetcode.study.group002.ex0029
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("divisor can not be zero");
        }
        boolean isPositive = true;
        if (dividend < 0 && divisor > 0
            || (dividend > 0 && divisor < 0)) {
            isPositive = false;
        }

        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                return isPositive ? -dividend : dividend;
            }
        }

        int result = 0;
        while (dividend <= divisor) {
            dividend -= divisor;
            --result;
        }

        return isPositive ? -result : result;
    }
}
