package leetcode.study.group002.ex0036;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : josan
 * @Date : 2020/2/8 20:50
 * @Package : leetcode.study.group002.ex0036
 * @ProjectName: pom-parent
 * @Description:
 */
public class Solution {
    private static final int N = 9;

    public boolean isValidSudoku(char[][] board) {
        checkBoard(board);
        return isRowsValid(board) && isColumnsValid(board) && isSubBoxesValid(board);
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

    private boolean isRowsValid(char[][] board) {
        for (int i = 0; i < N; i++) {
            Set set = new HashSet();
            for (int j = 0; j < N; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                if (set.contains(ch)) {
                    return false;
                } else {
                    set.add(ch);
                }
            }
        }
        return true;
    }

    private boolean isColumnsValid(char[][] board) {
        for (int i = 0; i < N; i++) {
            Set set = new HashSet();
            for (int j = 0; j < N; j++) {
                char ch = board[j][i];
                if (ch == '.') {
                    continue;
                }
                if (set.contains(ch)) {
                    return false;
                } else {
                    set.add(ch);
                }
            }
        }
        return true;
    }

    private boolean isSubBoxesValid(char[][] board) {
        for (int stI = 0; stI < N; stI += 3) {
            for (int stJ = 0; stJ < N; stJ += 3) {
                Set set = new HashSet();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char ch = board[stI + i][stJ + j];
                        if (ch == '.') {
                            continue;
                        }
                        if (set.contains(ch)) {
                            return false;
                        } else {
                            set.add(ch);
                        }
                    }
                }
            }
        }
        return true;
    }
}