//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 825 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*
    1.将数组中的区间按照起始位置进行排序
    2.用curr数组记录当前合并的最大区间，遍历数组中的每一个区间。如果当前区间的起始位置小于等于curr的终点位置，则可以继续合并。所以合并 并且更新curr的起始和终止位置，如果当前区间的起始位置大于curr的终止位置，则无法合并。所以将curr加入到result里面，并用当前的区间替换curr的值。
    */
    public int[][] merge(int[][] intervals) {
        //判断数组为空或只有一个区间的情况
        if(intervals.length < 2) return intervals;

        //对集合中的区间进行排序
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        int[] curr = intervals[0];
        for(int i=0; i<intervals.length; i++){
            if(intervals[i][0] <= curr[1]){
                curr[1] = Math.max(intervals[i][1],curr[1]);
            }else{
                res.add(curr);
                curr = intervals[i];
            }
        }
        res.add(curr);
        //定义一个二维数组存放结果
        int[][] result = new int[res.size()][2];
        for(int i =0; i<res.size(); i++){
            result[i]=res.get(i);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
