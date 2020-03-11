package leetcode.study.biggroup001.group004.ex0079;

/**
 * @Author : josan
 * @Date : 2020/2/19 1:59
 * @Package : leetcode.study.group004.ex0079
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            throw new IllegalArgumentException("board or word is null");
        }

        int M = board.length;
        int N = board[0].length;

        boolean[][] isVisited = new boolean[M][N];
        int[][] direction = new int[][]{{0,1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean result = false;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == word.charAt(0)) {
                    isVisited[i][j] = true;
                    result = existInner(board, M, N, i, j, word, 1, isVisited, direction);
                    isVisited[i][j] = false;
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean existInner(char[][] board, int M, int N, int stI, int stJ, String word, int nextSt,
                               boolean[][] isVisited, int[][] direction) {
        if (nextSt == word.length()) {
            return true;
        }

        boolean result = false;
        for (int i = 0; i < 4; i++) {
            int nextStI = stI + direction[i][0];
            int nextStJ = stJ + direction[i][1];
            if (couldPlace(board, M, N, nextStI, nextStJ, word, nextSt, isVisited)) {
                isVisited[nextStI][nextStJ] = true;
                ++nextSt;
                result = existInner(board, M, N, nextStI, nextStJ, word, nextSt, isVisited, direction);
                if (result) {
                    return true;
                }
                isVisited[nextStI][nextStJ] = false;
                --nextSt;
            }
        }
        return false;
    }

    private boolean couldPlace(char[][] board, int M, int N, int stI, int stJ,
                               String word, int st, boolean[][] isVisited) {
        return stI < M && stI >= 0 && stJ < N && stJ >= 0
                && !isVisited[stI][stJ] && board[stI][stJ] == word.charAt(st);
    }
}
