//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
// 👍 277 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        String[] sp = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sp.length; i++) {
            for(int j = sp[i].length() - 1; j >= 0; j--) {
                sb.append(sp[i].charAt(j));
            }
            if(i != sp.length - 1) {
                sb.append(" ");
            }

        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
