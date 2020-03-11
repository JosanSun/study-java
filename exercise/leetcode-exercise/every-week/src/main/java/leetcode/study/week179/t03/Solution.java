package leetcode.study.week179.t03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/3/8 10:20
 * @Package : leetcode.study.week179.t03
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer> allEmployees = findEmployees(headID, manager);

        if (allEmployees.size() == 0) {
            return 0;
        }

        int maxMinutes = 0;
        for (int i = 0; i < allEmployees.size(); i++) {
            maxMinutes = Math.max(maxMinutes, informTime[headID] +
                    numOfMinutes(n, allEmployees.get(i), manager, informTime));
        }
        return maxMinutes;
    }

    private List<Integer> findEmployees(int headID, int[] manager) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == headID) {
                result.add(i);
            }
        }
        return result;
    }
}
