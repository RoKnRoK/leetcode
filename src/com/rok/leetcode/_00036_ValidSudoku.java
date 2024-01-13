package com.rok.leetcode;

import java.util.*;

/**
 * Created by RoK on 19.07.2016.
 * All rights reserved =)
 */
public class _00036_ValidSudoku {
    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
        System.out.println(isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
        System.out.println(isValidSudoku(new char[][]{
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
        }));
    }

    public static boolean isValidSudoku(char[][] board) {
        var N = 9;
        char[] row = new char[N];
        char[][] blocks = new char[3][N];
        char[][] columns = new char[9][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (row[board[i][j] - 49] == 0) {
                    row[board[i][j] - 49] = board[i][j];
                } else {
                    return false;
                }
                if (columns[j][board[i][j] - 49] == 0) {
                    columns[j][board[i][j] - 49] = board[i][j];
                } else {
                    return false;
                }
                if (blocks[j/3][board[i][j] - 49] == 0) {
                    blocks[j/3][board[i][j] - 49] = board[i][j];
                } else {
                    return false;
                }
            }
            Arrays.fill(row, '\u0000');
            if (i%3 == 2) {
                Arrays.fill(blocks[0], '\u0000');
                Arrays.fill(blocks[1], '\u0000');
                Arrays.fill(blocks[2], '\u0000');
            }
        }
        return true;
    }

}
