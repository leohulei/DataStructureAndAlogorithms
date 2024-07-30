package src.main.java.leecode;

/**
 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

 例如，121 是回文，而 123 不是。
 示例 1：

 输入：x = 121
 输出：true
 示例 2：

 输入：x = -121
 输出：false
 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 示例 3：

 输入：x = 10
 输出：false
 解释：从右向左读, 为 01 。因此它不是一个回文数。
 提示：

 -231 <= x <= 231 - 1
 进阶：你能不将整数转为字符串来解决这个问题吗？
 */
public class leecode_0009_palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome2(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome2(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome2(10));
    }

    public static boolean isPalindrome(int x) {
        String revertStr = new StringBuilder(String.valueOf(x)).reverse().toString();
        return String.valueOf(x).equals(revertStr);
    }

    public static boolean isPalindrome2(int x) {
        //数学解法
        if (x<0) return false;
        int temp = 1;
        while (x / temp >= 10) {
            temp *= 10;
        }//确定位数
        while(x>0){
            int left = x/temp;//首位除以位数取整
            int right = x%10;//末位 除10取余
            if(left != right) return false;
            x = (x%temp)/10;//去除首位末位
            temp /= 100;
        }
        return true;
    }

}
