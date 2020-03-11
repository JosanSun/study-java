package leetcode.study.biggroup001.group003.ex0042;

/**
 * @Author : josan
 * @Date : 2020/2/9 16:16
 * @Package : leetcode.study.group003.ex0042
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        return trapInner(height, 0, height.length);
    }

    private int trapInner(int[] height, int st, int ed) {
        if (ed - st <= 2) {
            return 0;
        }

        int pos = st;
        while (pos + 1 < ed && height[pos] <= height[pos + 1]) {
            ++ pos;
        }
        if (pos + 1 >= ed) {
            return 0;
        }
        int leftIdx = pos;

        boolean hasAsc = false;
        while (pos + 1 < ed) {
            if (height[pos] >= height[pos + 1]) {
                ++pos;
            } else {
                hasAsc = true;
                break;
            }
        }
        if (!hasAsc) {
            return 0;
        }

        ++pos;
        while (pos + 1 < ed && height[pos] <= height[pos + 1]) {
            ++pos;
        }
        int rightIdx = pos;

        if (height[leftIdx] > height[rightIdx]) {
            rightIdx = fixRight(height, leftIdx, rightIdx + 1);
        }

        // [leftIdx, rightIdx]
        int area = getArea(height, leftIdx, rightIdx + 1);
        return area + trapInner(height, rightIdx, ed);
    }

    private int fixRight(int[] height, int leftIdx, int rightIdx) {
        int curRight = rightIdx - 1;
        int pos = rightIdx;
        while (pos < height.length) {
            if (height[pos] >= height[leftIdx]) {
                return pos;
            } else if (height[pos] >= height[curRight]) {
                curRight = pos;
            }
            ++pos;
        }

        return curRight;
    }

    private int getArea(int[] height, int st, int ed) {
        int heightNum = Math.min(height[st], height[ed - 1]);

        int area = heightNum * (ed - st - 2);
        for (int i = st + 1; i < ed - 1; i++) {
            if (height[i] > heightNum) {
                area -= heightNum;
            } else {
                area -= height[i];
            }
        }
        return area;
    }
}
