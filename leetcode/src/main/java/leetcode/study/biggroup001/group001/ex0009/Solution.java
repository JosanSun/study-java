package leetcode.study.biggroup001.group001.ex0009;

/**
 * @Author : josan
 * @Date : 2020/2/3 9:54
 * @Package : leetcode.study.ex0004
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = reverse(x);
        return (y - x) == 0;
    }

    private int reverse(int x) {
        int minPossible = Integer.MIN_VALUE / 10;
        int maxDigits = getDigits(Integer.MIN_VALUE);

        int result = 0;
        boolean changeFlag = false;
        if (x >= 0) {
            x = -x;
            changeFlag = true;
        }

        result = reverse(x, minPossible, maxDigits);

        if (changeFlag) {
            result = -result;
        }

        return result;
    }

    private int reverse(int x, int minPossible, int maxDigits) {
        int result = 0;
        int depth = 0;
        boolean needSafeCheck = getDigits(x) == maxDigits;
        while(x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
            ++depth;
            if (needSafeCheck) {
                if (depth == maxDigits -1) {
                    if (result < minPossible ||
                            (result == minPossible && (x % 10) < (Integer.MIN_VALUE % 10))) {
                        // 越界
                        return 0;
                    }
                }
            }
        }
        return result;
    }

    private int getDigits(int x) {
        if (x == 0) {
            return 1;
        }

        int digits = 0;
        while(x != 0) {
            x /= 10;
            ++digits;
        }
        return digits;
    }
}