//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 744 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        if(n == 0){
            return ans;
        }

        char[][] board = new char[n][n];
        // Arrays.fill只能作用于一维数组
        for(char[] i : board){
            Arrays.fill(i, '.');
        }

        // 记录该列、对角线上是否已经放置了皇后
        boolean[] column = new boolean[n];
        boolean[] ldiag = new boolean[2*n-1];
        boolean[] rdiag = new boolean[2*n-1];

        backtracking(ans, board, column, ldiag, rdiag, 0, n);
        return ans;
    }


    /*
     * 回溯函数：
     * ans：结果数组、board：自己根据n构造的棋盘，默认填充为'.'
     * column,ldiag,rdiag：对每一行，建立列、左斜、左斜访问数组，来记录这些位置是否已经存放皇后了
     * row：当前的行数
     * n：几皇后问题，即棋盘有几行几列
     */
    public void backtracking(List<List<String>> ans, char[][] board, boolean[] column, boolean[] ldiag, boolean[] rdiag, int row, int n){
        // 已经走完所有行了，可以把当前棋盘放入结果数组了
        if(row == n){
            // char[][] 转换为List<String>
            List temp = new ArrayList();
            for (char[] a : board){
                temp.add(String.valueOf(a));
            }
            ans.add(temp);
            return;
        }

        for (int i = 0; i < n; i++){
            // 当前列、左斜线或者右斜线的某个位置已经有王后了，跳过该列，继续搜索
            // 左斜线上：横纵坐标之和固定
            // 右斜线上：（横左边-纵坐标）固定，为何避免出现负数索引，因此采用n-(横左边-纵坐标)
            if (column[i] || rdiag[n-1-row+i] || ldiag[row+i]){
                continue;
            }
            // 修改当前节点状态
            board[row][i] = 'Q';
            column[i] = rdiag[n-1-row+i] = ldiag[row+i] = true;
            // 递归子节点
            backtracking(ans, board, column, ldiag, rdiag, row + 1, n);
            // 撤销修改
            board[row][i] = '.';
            column[i] = rdiag[n-1-row+i] = ldiag[row+i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
