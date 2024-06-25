package src.main.java.classical;

import java.util.Arrays;

/**
 * 数组中某一个下标，左右两边的元素之和相等，该下标即为中心索引
 * 思路：先统计出整个数组的总和，然后从第一个元素开始叠加
 * 总和递减当前元素，叠加递增当前元素，知道两个值相等
 */
public class ArrCenter {
    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};
        System.out.println(center(nums));
        System.out.println(center2(nums));
    }

    //从左向右循环，计算循环路径上数字的和 ，然后和数组的和进行比较 ，
    // 不相等向右循环，同时数组的总和减去循环过的元素，直到相等为止即为中心，否则没有中心
    private static int center(int[] nums) {
        int sum = Arrays.stream(nums).sum();//流式求和
        int total = 0 ;//记录循环路径上元素的和
        for (int i = 0; i < nums.length; i++) {
            total = total+nums[i];
            if(total == sum){
                return i;
            }
            sum = sum-nums[i];
        }

        return -1;
    }

    //从左到右遍历求和，如果2*total+curr当前元素的和与数组的总和sum相等，那么curr的下标就是中心点坐标
    public static int center2(int[] nums){
        int sum = Arrays.stream(nums).sum();//求和
        int total = 0;
        for (int i = 0; i < nums.length-1; i++) {
            total =total+nums[i];
            if (2*total+nums[i+1] == sum){
                return i+1;
            }
        }
        return -1;
    }



}
