package src.main.java.classical;

/**
 * 在不使用 sqrt(x) 函数的情况下，得到 x的平方根的整数部分
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrts(9));
        System.out.println(binarySearch(9));
        System.out.println(newTon(9));
    }

    private static int sqrts(int x) {
        //暴力算法 找到i*i<=x 且(i+1)(i+1)>x 那么i就是他的平方根或者其整数部分
        for (int i =1; i<=x; i++){
            if(i*i <=x && (i+1)*(i+1) >x){
                //对比i*i 与i+1 * i+1 谁距离x更近
                    return i;
            }
        }
        return -1;
    }

    //二分查找法计算x的平方根
    private static int binarySearch(int x) {
        int l = 0;
        int r = x;
        int index = -1;//记录值
        while (l <= r){//循环终止条件就是l与r重合
            int mid =l + (r-l)/2;//lr的中间值
            //判断mid*mid 是否<=x ,如果小于x则l右移 否则 r 左移
            if (mid*mid <= x){
                index =mid;
                l =mid +1;
            }else {
                r =mid-1;//二分位置右移开始
            }
        }
        return index;
    }

    //牛顿算法找平方根
    public static int newTon(int x){
        return (int)sqart(x,x);

    }

    //x/n 与 n  的平均值是向x的平方根收敛的 目的是找到x/n=n
    //2个乘积是x的数，他们的平均值比他们本身更接近x的平方根n,通过迭代，让他们的平均值不断地向n收敛，直至相等，就能得到x的平方根
    public static double sqart(double n,int x){
        double res = (x/n + n )/2;//平均值
        if(res == n){
            return n;
        }else {
            return sqart(res,x);
        }
    }
}
