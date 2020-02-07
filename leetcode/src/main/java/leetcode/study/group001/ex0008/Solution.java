package leetcode.study.group001.ex0008;

/**
 * @Author : josan
 * @Date : 2020/2/3 9:54
 * @Package : leetcode.study.ex0004
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }

        char firstChar = str.charAt(0);
        int sign = 1;
        int trueStart = 0;
        if (firstChar == '-') {
            sign = -1;
            ++trueStart;
        } else if (firstChar == '+') {
            ++trueStart;
        } else if (!(firstChar <= '9' && firstChar >= '0')) {
            return 0;
        }

        int result = 0;
        int trueEnd = trueStart;
        for (; trueEnd < str.length(); trueEnd++) {
            if (!Character.isDigit(str.charAt(trueEnd))) {
                break;
            }
        }
        while(trueStart < trueEnd && str.charAt(trueStart) == '0') {
            ++trueStart;
        }

        int len = trueEnd - trueStart;

        boolean isOverFlow = false;
        int minPossible = Integer.MIN_VALUE / 10;
        int maxPossible = Integer.MAX_VALUE / 10;
        int maxDigits = getDigits(Integer.MIN_VALUE);

        if (len > maxDigits) {
            isOverFlow = true;
        }


        for (int i = trueStart; i < trueEnd; i++) {
            result = result * 10 + sign * (str.charAt(i) - '0');
            if (sign == 1) {
                if ((result > maxPossible && (i + 1) < trueEnd)
                    || (result == maxPossible && (i + 1) < trueEnd && (str.charAt(i + 1) - '0') > (Integer.MAX_VALUE % 10))) {
                    isOverFlow = true;
                    break;
                }
            } else {
                if ((result < minPossible && (i + 1) < trueEnd)
                        || (result == minPossible && (i + 1) < trueEnd && -(str.charAt(i + 1) - '0') < (Integer.MIN_VALUE % 10))) {
                    isOverFlow = true;
                    break;
                }
            }
        }

        if (isOverFlow) {
            result = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
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