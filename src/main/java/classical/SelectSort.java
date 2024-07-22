package src.main.java.classical;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] a = {3,1,1,2,4,4,7};
        selectsort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void selectsort(int[] a){


        for (int i = 0; i < a.length; i++) {
            int p =i;
            for (int j = i+1; j <a.length ; j++) {
                if(a[j] < a[p]){
                    p = j;//标记循环中发现的最小的数
                }

            }
            if(p !=i){//若果最小的数发生变化了，就交换位置
                int temp = a[p];
                a[p] = a[i];
                a[i] = temp;
            }

        }
    }
}
