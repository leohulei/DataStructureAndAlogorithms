package src.main.java.classical;

import java.util.Arrays;

/**
 * 一个整型数组 nums ，在数组中找出由三个数字组成的最大乘积，并输出这个乘积。
 * 乘积不会越界
 * 如果数组中全是非负数，则排序后最大的三个数相乘即为最大乘积；如果全是非正数，则最大的三个数
 * 相乘同样也为最大乘积。
 * 如果数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数（即绝对
 * 值最大）与最大正数的乘积。
 * 分别求出三个最大正数的乘积，以及两个最小负数与最大正数的乘积，二者之间的最大值即为所求答
 * 案。
 */
public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,3,4,-5,-6,};
        System.out.println(getMax(nums));
        System.out.println(getMaxMin(nums));

    }


    //获取数组中三个数的最大乘积：两个最小的负数和最大的正数的乘积 与三个最大的正数的乘积作比较
    public static int getMax(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0]*nums[1]*nums[n-1],nums[n-3]*nums[n-1]*nums[n-2]);
    }

    //按照上边的方法，如果能直接找到这个5个数而不用进行排序，那算法的复杂度就会下降
    public static int getMaxMin(int[] nums){
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;//定义两个最小的负数
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;//定义三个最大的正数

        for (int x: nums) {
            if (x < min1){//如果x比最小的数还小，那么x是最小的数，min1 变成第二小的数
                min2 = min1;
                min1 =x;
            }else if(x <min2){//如果x比第二小的数小，那么x就是第二小的数
                min2 =x ;

            }else if(x > max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if(x > max2){
                max3 = max2;
                max2 = x;
            }else if(x > max3){
                max3 = x;
            }

        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }
}
