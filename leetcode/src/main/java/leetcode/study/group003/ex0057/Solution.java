package leetcode.study.group003.ex0057;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : josan
 * @Date : 2020/2/12 21:42
 * @Package : leetcode.study.group003.ex0057
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        } else if (newInterval == null || newInterval.length == 0) {
            return intervals;
        }

        List<Range> rangeList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            rangeList.add(new Range(intervals[i][0], intervals[i][1]));
        }
        if (newInterval[0] == newInterval[1]) {
            rangeList.add(new Range(newInterval[0], newInterval[1]));
        } else {
            for (int i = newInterval[0]; i < newInterval[1]; i++) {
                rangeList.add(new Range(i, i + 1));
            }
        }

        rangeList = rangeList.stream()
                .sorted(Comparator.comparingInt(Range::getY))
                .collect(Collectors.toList());

        for (int i = rangeList.size() - 1; i > 0; --i) {
            Range left = rangeList.get(i - 1);
            Range right = rangeList.get(i);

            if (left.getY() >= right.getX()) {
                left.setX(Math.min(left.getX(), right.getX()));
                left.setY(right.getY());

                rangeList.remove(i);
            }
        }

        int[][] result = new int[rangeList.size()][2];
        for (int i = 0; i < rangeList.size(); i++) {
            result[i][0] = rangeList.get(i).getX();
            result[i][1] = rangeList.get(i).getY();
        }
        return result;
    }
}



class Range {
    private int x;
    private int y;

    public Range(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
