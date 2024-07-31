package src.main.java.剑指offer;
//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
public class offer14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
        String[] strs2 = {"flower","alow","tlight"};
        System.out.println(longestCommonPrefix(strs2));

    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            int j = 0;
            for (; j < prefix.length() && j < strs[i].length(); j++){
                if (prefix.charAt(j) != strs[i].charAt(j)){//直到不等
                    break;
                }
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;

    }
}
