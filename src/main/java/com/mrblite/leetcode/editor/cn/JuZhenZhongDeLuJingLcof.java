package com.mrblite.leetcode.editor.cn;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 剑指 Offer 12 - 矩阵中的路径
 *
 * @author mrblite
 * @date 2021-04-19 21:15:54
 **/
public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
//        [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
//        "ABCCED"
//
//        char[][] a = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        String b = "ABCCED";
        char[][] a = {
                {'A', 'D', 'E', 'E'}
        };
        String b = "AD";
        solution.exist(a, b);
    }

    /**
     * Solution
     **/
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] dirX = {-1, 0, 1, 0};
        private int[] dirY = {0, -1, 0, 1};
        private char[][] board;
        private int row;
        private int col;
        private String word;
        private int wordLen;
        private int index;


        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.word = word;
            wordLen = word.length();
            row = board.length;
            col = board[0].length;
            index = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (dfs(i, j)) {
                        return true;
                    }
                }
            }
            return false;

        }

        // 查找从当前结点开始是否存在符合子字符串的路径
        boolean dfs(int x, int y) {
            if (board[x][y] == word.charAt(index)) {
                if (wordLen == index + 1) {
                    return true;
                } else {
                    board[x][y] = '0';
                    index++;
                    for (int i = 0; i < 4; i++) {
                        int newX = x + dirX[i];
                        int newY = y + dirY[i];
                        if (isInArea(newX, newY) && board[newX][newY] != '0') {
                            if (dfs(x + dirX[i], y + dirY[i])) {
                                return true;
                            }
                        }
                    }
                    index--;
                    board[x][y] = word.charAt(index);
                    return false;
                }
            } else {
                return false;
            }

        }

        boolean isInArea(int x, int y) {
            return x >= 0 && x < row && y >= 0 && y < col;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}