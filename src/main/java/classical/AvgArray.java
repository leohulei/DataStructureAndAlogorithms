package src.main.java.classical;

/**
 * 给一个整数数组，找出平均数最大且长度为 k 的下标连续的子数组，并输出该最大平均数。
 */
public class AvgArray {
    public static void main(String[] args) {
        int[] num = new int[]{1,12,-5,-6,50,3};
        int k = 4 ;
        //求连续长度为4的子数组的最大平均值
        System.out.println(slide(num,4));
    }


    //滑动窗口
    public static double slide(int[] num, int k){
        int sum = 0; //记录和，（和最大，平均值就最大）
        int n = num.length;
        for (int i = 0; i < k; i++) {//初始窗口求和
            sum += num[i];
        }
        int max = sum;
        for (int i = k; i < n; i++) {
            sum = sum-num[i-k]+num[i];//去掉滑动窗口的头元素,加上右移元素
            max = Math.max(sum,max);
        }
        return 1.0 * max/k;
    }
}
