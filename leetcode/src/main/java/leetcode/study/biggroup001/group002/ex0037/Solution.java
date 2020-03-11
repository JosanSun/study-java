package leetcode.study.biggroup001.group002.ex0037;

/**
 * @Author : josan
 * @Date : 2020/2/8 20:50
 * @Package : leetcode.study.group002.ex0036
 * @ProjectName: pom-parent
 * @Description:
 */
class Solution {
    private static boolean isSolved = false;

    private static final int n = 3;
    private static final int N = 9;

    private static final int[][] rows = new int[N][N + 1];
    private static final int[][] columns = new int[N][N + 1];
    private static final int[][] inboxes = new int[N][N + 1];

    public void solveSudoku(char[][] board) {
        checkBoard(board);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.') {
                    placeNumber(board, i, j, board[i][j] - '0');
                }
            }
        }

        backtrack(board, 0, 0);
//        System.out.println();
    }

    private void backtrack(char[][] board, int row, int column) {
        if (board[row][column] == '.') {
            for (int i = 0; i < N; i++) {
                if (couldPlace(row, column, i + 1)) {
                    placeNumber(board, row, column, i + 1);
                    placeNextNumber(board, row, column);
                    if (!isSolved) {
                        removeNumber(board, row, column, i + 1);
                    }
                }
            }
        } else {
            placeNextNumber(board, row, column);
        }
    }

    private boolean couldPlace(int row, int column, int num) {
        int boxIndex = (row / n) * n + column / n;
        return rows[row][num] + columns[column][num] + inboxes[boxIndex][num] == 0;
    }

    private void placeNextNumber(char[][] board, int row, int column) {
        if (row == N - 1 && column == N - 1) {
            isSolved = true;
            return ;
        }

        if (column == N - 1) {
            backtrack(board, ++row, 0);
        } else {
            backtrack(board, row, column + 1);
        }
    }

    private void placeNumber(char[][] board, int row, int column, int num) {
        int boxIndex = (row / n) * n + column / n;

        ++rows[row][num];
        ++columns[column][num];
        ++inboxes[boxIndex][num];
        board[row][column] = (char)('0' + num);
    }

    private void removeNumber(char[][] board, int row, int column, int num) {
        int boxIndex = (row / n) * n + column / n;

        --rows[row][num];
        --columns[column][num];
        --inboxes[boxIndex][num];
        board[row][column] = '.';
    }

    private void checkBoard(char[][] board) {
        if (board == null || board.length != N || board[0].length != N) {
            throw new IllegalArgumentException("baord is not right");
        }
        for (char[] rows : board) {
            for(char ch : rows) {
                if (!(ch == '.' ||
                        (ch >= '0' && ch <= '9'))) {
                    throw new IllegalArgumentException("char is not valid");
                }
            }
        }
    }
}


class Solution02 {

    private boolean[][] rows = new boolean[9][10];

    private boolean[][] cols = new boolean[9][10];

    private boolean[][] boxs = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxs[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int i, int j) {
        // 左上角开始寻找空位,遇到空位时停下
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) {
                return true;
            }
        }
        for (int num = 1; num <= 9; num++) {
            int boxIndex = i / 3 * 3 + j / 3;
            if (!rows[i][num] && !cols[j][num] && !boxs[boxIndex][num]) {
                board[i][j] = (char) ('0' + num);
                rows[i][num] = true;
                cols[j][num] = true;
                boxs[boxIndex][num] = true;
                if (dfs(board, i, j)) {
                    return true;
                } else {
                    // 回溯
                    board[i][j] = '.';
                    rows[i][num] = false;
                    cols[j][num] = false;
                    boxs[boxIndex][num] = false;
                }
            }
        }
        return false;
    }
}