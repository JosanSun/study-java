package leetcode.study.biggroup001.group004.ex0069;

/**
 * @Author : josan
 * @Date : 2020/2/16 11:12
 * @Package : leetcode.study.group004.ex0069
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("x is wrong");
        }

        if (x == 0 || x == 1) {
            return x;
        }

        int i = 1;
        for (; i <= x / 2; ) {
            if (x == i * i) {
                return i;
            } else if (x < i * i || i * i <= 0) {
                break;
            }
            i *= 2;
        }

        int res = i - 1;
        for (int j = i - 1; j >= i / 2; j--) {
            res = j;
            if (j * j <= 0) {
                continue;
            }
            if (x >= j * j) {
                break;
            }
        }

        return res;
    }
}
