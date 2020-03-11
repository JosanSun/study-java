package leetcode.study.week179.t02;

/**
 * @Author : josan
 * @Date : 2020/3/8 10:20
 * @Package : leetcode.study.week179.t02
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int numTimesAllBlue(int[] light) {
        if (light == null || light.length == 0) {
            throw new IllegalArgumentException("light is wrong");
        }

        int result = 0;
        int maxNum = -1;
        for (int i = 0; i < light.length; i++) {
            maxNum = Math.max(maxNum, light[i]);
            if (maxNum == i + 1) {
                ++ result;
            }
        }

        return result;
    }
}
