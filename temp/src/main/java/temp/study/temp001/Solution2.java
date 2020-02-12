package temp.study.temp001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : josan
 * @Date : 2020/2/10 9:33
 * @Package : temp.study
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution2 {
    private int result = -1;

    public int findShortestWay(int[][] maze, int step) {
        if (maze == null || step <= 0) {
            throw new IllegalArgumentException("argument is wrong");
        }

        int M = maze.length;
        int N = maze[0].length;
        Position startPos = getStartPos(maze, M, N);
        if (startPos == null) {
            throw new IllegalArgumentException("can not find the start pos");
        }

        List<Position> curPath = new ArrayList<>();
        Map<Integer, Position> directionMap = new HashMap<>();
        directionMap.put(0, new Position(0, 1));
        directionMap.put(1, new Position(1, 0));
        directionMap.put(2, new Position(0, -1));
        directionMap.put(3, new Position(-1, 0));
        findShortestWayInner(maze, step, M, N, startPos, curPath, 0, directionMap);

        return result;
    }

    private void findShortestWayInner(int[][] maze, int step, int M, int N,
                                      Position startPos, List<Position> curPath,
                                      int currentLightNum, Map<Integer, Position> directionMap) {
        // 剪枝
        if (curPath.size() >= step) {
            return ;
        }

        for (int i = 0; i < directionMap.size(); i++) {
            Position nextPos = nextPosition(startPos, i, directionMap);
            if (couldNextPosCanGet(maze, M, N, nextPos)) {
                // mark the next state
                curPath.add(nextPos);
                int value = maze[nextPos.getI()][nextPos.getJ()];
                if (value == 2) {
                    ++currentLightNum;
                    // 防止重复算灯
                    maze[nextPos.getI()][nextPos.getJ()] = 0;
                } else if (value == 4) {
                    if (curPath.size() == step) {
                        result = Math.max(result, currentLightNum);
                        // reset the state
                        curPath.remove(curPath.size() - 1);
                        continue;
                    }
                    // curPath.size() < step  goon backtrack
                }

                findShortestWayInner(maze, step, M, N, nextPos, curPath, currentLightNum, directionMap);

                // reset the state
                curPath.remove(curPath.size() - 1);
                if (value == 2) {
                    --currentLightNum;
                    maze[nextPos.getI()][nextPos.getJ()] = value;
                }
            }
        }
    }

    private boolean couldNextPosCanGet(int[][] maze, int M, int N, Position nextPos) {
        if (nextPos.getI() >= 0 && nextPos.getI() < M && nextPos.getJ() >= 0 && nextPos.getJ() < N) {
            int value = maze[nextPos.getI()][nextPos.getJ()];
            return value != 1;
        }
        return false;
    }

    private Position getStartPos(int[][] maze, int M, int N) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (maze[i][j] == 3) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    private Position nextPosition(Position current, int i, Map<Integer, Position> directionMap) {
        Position position = directionMap.get(i);
        return new Position(current.getI() + position.getI(), current.getJ() + position.getJ());
    }
}