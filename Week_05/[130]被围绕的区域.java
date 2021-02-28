//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 478 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int column = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                fill(board, 0, j);
                fill(board, row-1, j);
            }

            fill(board, i, 0);
            fill(board, i, column-1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void fill(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 'X' || board[x][y] == '#') {
            return;
        }

        board[x][y] = '#';
        fill(board, x-1, y);
        fill(board, x+1, y);
        fill(board, x, y-1);
        fill(board, x, y+1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
