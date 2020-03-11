package leetcode.study.biggroup001.group003.ex0050;

/**
 * @Author : josan
 * @Date : 2020/2/11 23:58
 * @Package : leetcode.study.group003.ex0050
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        return n < 0 ? myPowInner(x, n) : 1.0 / myPowInner(x, -n);
    }

    private double myPowInner(double x, int n) {
        if (n >= 0) {
            throw new IllegalArgumentException("n is wrong. " + n);
        }

        double sum = 1;
        while (n < 0) {
            if (n % 2 == -1) {
                sum *= x;
            }

            n /= 2;
            x *= x;
        }
        return 1.0 / sum;
    }
}