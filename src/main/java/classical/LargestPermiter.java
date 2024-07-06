package src.main.java.classical;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 A ，返回由其中三个长度组成的、面积不为零的三角形的最大
 * 周长。
 * 如果不能形成任何面积不为零的三角形，返回 0 。
 * 贪心：
 * 先小到大排序，假设最长边是最后下标，另外两条边是倒数第二和第三下标，则此时三角形周长最大
 * n < (n-1) + (n-2)，如果不成立，意味着该数组中不可能有另外两个值之和大于n，此时将n左移，重新计算
 */
public class LargestPermiter {
    /**
     * 给定一组正整数，求他们能组成的三角形的最大周长
     */
    public static void main(String[] args) {
        int[] num = new int[]{3,6,2,3,4};
        System.out.println(largest(num));
    }
    //组成三角形：两边之和大于第三边，周长最大--边越长周长越长
    public static int largest(int[] num){
        //先对数组进行排序
        Arrays.sort(num);
        int max = 0;
        //从后往前去找，看他们能否组成三角形，如果能那就是最大周长
        for (int i = num.length-1; i >=2 ; i--) {
            if(num[i]<num[i-1]+num[i-2]){
                max = num[i]+num[i-1]+num[i-2];
                return max;
            }

        }
        return max;
    }
}
