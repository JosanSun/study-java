package leetcode.study.group003.ex0052;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : josan
 * @Date : 2020/2/12 15:52
 * @Package : leetcode.study.group003.ex0052
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    private List<List<String>> result = new ArrayList<>();

    public int totalNQueens(int n) {
        char[][] maze = new char[n][n];
        int[][] num = new int[n][n];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = '.';
            }
        }
        solveNQueensInner(maze, 0, new Position(0, 0), n, num);

        return result.size();
    }


    private void solveNQueensInner(char[][] maze, int curQueenNum, Position position,
                                   int n, int[][] num) {
        if (curQueenNum == n) {
            List<String> list = convertMaze2StrList(maze);
            result.add(list);
            return ;
        }

        while (position.getI() < n && position.getJ() < n) {
            int i = position.getI();
            int j = position.getJ();
            if (couldPlace(maze, i, j)) {
                ++curQueenNum;
                setOtherPlace(maze, n, i, j, num);

                solveNQueensInner(maze, curQueenNum, nextPosition(maze, position, n), n, num);

                --curQueenNum;
                removeOtherPlace(maze, n, i, j, num);

                position = nextPosition(maze, position, n);
            } else {
                position = nextPosition(maze, position, n);
                solveNQueensInner(maze, curQueenNum, position, n, num);
            }
        }
    }

    private Position nextPosition(char[][] maze, Position position, int n) {
        Position next = nextPositionOneStep(position, n);
        if (next.getI() >= n) {
            return next;
        }
        while (next.getI() < n && maze[next.getI()][next.getJ()] != '.') {
            next = nextPositionOneStep(next, n);
        }
        return next;
    }

    private Position nextPositionOneStep(Position position, int n) {
        int i = position.getI();
        int j = position.getJ();
        ++j;
        if (j == n) {
            j = 0;
            ++i;
        }
        return new Position(i, j);
    }

    private void setOtherPlace(char[][] maze, int n, int i, int j, int[][] num) {
        maze[i][j] = 'Q';
        char ch = 'M';
        for (int k = 0; k < n; k++) {
            if (k != i) {
                ++num[k][j];
                maze[k][j] = ch;
            }
            if (k != j) {
                ++num[i][k];
                maze[i][k] = ch;
            }
        }

        int iTmp = i - 1;
        int jTmp = j - 1;
        while (iTmp >= 0 && jTmp >= 0) {
            ++num[iTmp][jTmp];
            maze[iTmp--][jTmp--] = ch;
        }
        iTmp = i + 1;
        jTmp = j + 1;
        while (iTmp < n && jTmp < n) {
            ++num[iTmp][jTmp];
            maze[iTmp++][jTmp++] = ch;
        }
        iTmp = i - 1;
        jTmp = j + 1;
        while (iTmp >= 0 && jTmp < n) {
            ++num[iTmp][jTmp];
            maze[iTmp--][jTmp++] = ch;
        }
        iTmp = i + 1;
        jTmp = j - 1;
        while (iTmp < n && jTmp >= 0) {
            ++num[iTmp][jTmp];
            maze[iTmp++][jTmp--] = ch;
        }
    }

    private void removeOtherPlace(char[][] maze, int n, int i, int j, int[][] num) {
        maze[i][j] = '.';
        char ch = '.';
        for (int k = 0; k < n; k++) {
            if (k != i) {
                --num[k][j];
                if (num[k][j] == 0) {
                    maze[k][j] = ch;
                }
            }
            if (k != j) {
                --num[i][k];
                if (num[i][k] == 0) {
                    maze[i][k] = ch;
                }
            }
        }

        int iTmp = i - 1;
        int jTmp = j - 1;
        while (iTmp >= 0 && jTmp >= 0) {
            --num[iTmp][jTmp];
            if (num[iTmp][jTmp] == 0) {
                maze[iTmp][jTmp] = ch;
            }
            --iTmp;
            --jTmp;
        }
        iTmp = i + 1;
        jTmp = j + 1;
        while (iTmp < n && jTmp < n) {
            --num[iTmp][jTmp];
            if (num[iTmp][jTmp] == 0) {
                maze[iTmp][jTmp] = ch;
            }
            ++iTmp;
            ++jTmp;
        }
        iTmp = i - 1;
        jTmp = j + 1;
        while (iTmp >= 0 && jTmp < n) {
            --num[iTmp][jTmp];
            if (num[iTmp][jTmp] == 0) {
                maze[iTmp][jTmp] = ch;
            }
            --iTmp;
            ++jTmp;
        }
        iTmp = i + 1;
        jTmp = j - 1;
        while (iTmp < n && jTmp >= 0) {
            --num[iTmp][jTmp];
            if (num[iTmp][jTmp] == 0) {
                maze[iTmp][jTmp] = ch;
            }
            ++iTmp;
            --jTmp;
        }
    }

    private boolean couldPlace(char[][] maze, int i, int j) {
        return maze[i][j] == '.';
    }

    private List<String> convertMaze2StrList(char[][] maze) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < maze.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'M' || maze[i][j] == '.') {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
}

class Position {
    private int i;
    private int j;

    public Position(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}