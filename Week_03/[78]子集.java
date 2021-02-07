//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 983 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    int n;
    public List<List<Integer>> subsets(int[] nums) {
        //[1,2,3] //递归：每次选中一个数，加入到已有的子集中和之前的子集组成新的子集。
        //[] [1] [2] [3]  [1,2] [1,3] [2,3] [1,2,3]
        n = nums.length;
        for(int k = 0; k <= n; k++) {
            dfs(nums, 0, k, cur, res);
        }
        return res;
    }

    private void dfs(int[] nums, int start, int k, List<Integer> cur, List<List<Integer>> res) {
        if(k == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start; i < n; i++) {
            cur.add(nums[i]);
            dfs(nums, i+1, k-1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }




    //加入空集
       /*
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        for(int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();

            for(List<Integer> subSet: res) {
                List<Integer> newSubset = new ArrayList<Integer>(subSet);
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            res.addAll(newSubsets);
        }

        return res;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
