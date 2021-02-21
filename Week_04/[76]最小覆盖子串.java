//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 963 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if((s.length()==0) ||( t.length()==0) || (s.length() < t.length())) return ""; //定义特殊情况

        //定义S和T中字符出现的频数
        int[] winFreq = new int[128];
        int[] tFreq = new int[128];

        //把字符串转成字符数组，然后统计t中出现的字符个数
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        for(char c: charArrayT){
            tFreq[c]++;
        }

        //distance表示滑动窗口内部包含了T中字符的个数，
        // 窗口内单个字符个数等于T中对应的字符个数的时候不再增加。
        int distance = 0;
        int minlen = s.length()+1 ;
        int begin = 0;

        //定义滑动窗口的边界
        int right=0;
        int left=0;

        while(right<s.length()){

            if(winFreq[charArrayS[right]] < tFreq[charArrayS[right]]){
                distance++;
            }
            winFreq[charArrayS[right]]++;
            right++;

            while(distance == t.length()){
                if(right - left < minlen){
                    minlen = right - left;
                    begin = left;
                }
                if(winFreq[charArrayS[left]] == tFreq[charArrayS[left]]){
                    distance--;
                }
                winFreq[charArrayS[left]]--;
                left++;
            }

        }
        if(minlen == s.length()+1){
            return "";
        }
        return s.substring(begin,begin+minlen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
