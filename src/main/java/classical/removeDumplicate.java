package src.main.java.classical;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个有序数组 nums ，原地删除重复出现的元素，使每个元素只出现一次 ，返回删除后数组的新长度
 *
 * 不要使用额外的数组空间，必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class removeDumplicate {
    public static void main(String[] args) {
        int [] str = new int[]{2,2,3,3,4,4,5};
//        int [] str = new int[]{1,2,2,3,3,4,5};
        System.out.println(removeDump(str));

    }

    public static int removeDump(int[] str){
        if (str.length == 0){
            return 0;
        }
        int j =0 ;
        for (int i = 1; i < str.length; i++) {
            if (str[i] != str[j]) {
                j++;
                str[j] = str[i]; //不相等，j向后移
            }
        }
        return j+1;
    }



}
