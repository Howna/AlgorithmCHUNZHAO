//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 475 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k <= 0 || n < k) {
            return res;
        }
        dfs(n, k, 1, path,res);
        return res;

    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if(path.size() == k) { //递归终止条件
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = begin; i <=  n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            dfs(n, k, i+1, path,res);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
