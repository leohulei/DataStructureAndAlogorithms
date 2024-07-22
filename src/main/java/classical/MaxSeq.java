package src.main.java.classical;

public class MaxSeq {

    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,2,3,4,3,4,5,6,7};
        //找连续最长的子数组
        System.out.println(maxSeq(num));
    }

    public static int maxSeq(int[] num){
        int max = Integer.MIN_VALUE;//记录过程中最小子数组的长度
        int n = num.length;
        int start = 0;//每个阶段的其实位置
        for (int i = 1; i <n ; i++) {//下标为1开始和下标为0的比较：：从0开始也可，但是底下要改为i+1，然后循环到n-1为止
            if (num[i] < num[i-1]) {//如果前边比后边小，说明他还在连续递增
                start = i ;//一个阶段的连续递增子数组结束，下一阶段从i重新开始
            }
            max = Math.max(max,i-start+1);
        }
        return max;
    }
}
