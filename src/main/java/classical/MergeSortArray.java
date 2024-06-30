package src.main.java.classical;

import java.util.Arrays;

/**
 * 两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。假设 nums1 的空间大小等于 m + n，这样它就
 * 有足够的空间保存来自 nums2 的元素。
 */
public class MergeSortArray {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,3,5,7,9,0,0,0,0};
        int[] num2 = new int[]{2,4,6,8};
//        System.out.println(merge(num1,5,num2,4));
//        System.out.println(Arrays.toString(merge(num1,5,num2,4)));
        System.out.println(Arrays.toString(towPoint(num1,5,num2,4)));
    }

    public static int[] merge(int[] num1, int m, int[] num2, int n){
        System.arraycopy(num2,0,num1,m,n);//将num2从0拷贝到num1，从num1的m处开始拷贝n个数据
        Arrays.sort(num1);
        return num1;
    }

    public static int[] towPoint(int[] num1, int m, int[] num2, int n){
        //定义一个结果数组，长度等于num1的长度
        int[] res = new int[m+n];
        int f1 = 0;//定义两个指针，分别从num1和num2的第一个数开始
        int f2 = 0;
        int resFlag = 0 ;
        //比较f1与f2 谁小就放入新数组，然后后移再比较
        while (f1 <m && f2<n){//如果不小于，说明某一个数组遍历完了
            res[resFlag++] = num1[f1] <num2[f2] ? num1[f1++] : num2[f2++];
        }
        if (f1 < m){//num1没有遍历完，把剩下的直接copy过去
            //把num1从f1位置开始 拷贝到res 从res resFlag开始 长度是剩余个数
//            System.arraycopy(num1,f1,res,f1+f2,m+n-f1-f2);
            System.arraycopy(num1,f1,res,resFlag,m-f1);

        }
        if (f2 <n){//num2没有遍历完，把剩下的直接copy过去
//            System.arraycopy(num2,f1,res,f1+f2,m+n-f1-f2);
            System.arraycopy(num2,f1,res,resFlag,n-f2);
        }
        return res;
    }
}
