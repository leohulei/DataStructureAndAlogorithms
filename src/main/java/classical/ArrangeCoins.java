package src.main.java.classical;

/**
 *总共有 n 枚硬币，将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内
 */
public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(coins(7));
        System.out.println(binaryCoins(7));
        System.out.println(newton(7));

    }

    //穷举
    public static int coins(int n){

        for (int i = 1; i <=n ; i++) {//第一行开始放
            n = n-i;//每次放完后剩余的数量
            if (n <= i){//刚好放完或者不够放下一个
                return i;
            }
        }
        return 0;
    }

    //二分查找
    //假设n枚硬币放了 x 行 那么 只需要找到1-x之间 累加和与n相等即可 累加求和公式x（x+1）/2
    public static int binaryCoins(int n){
        int low = 1;
        int high =n;
        while (low <= high){//边界重合，就找完了
            int mid = low + (high-low)/2;
            int count = mid*(mid+1)/2;//求和
            if (count == n) {
                return high;
            }else if (count < n) {//说明硬币没用完 low 右移
                low = mid+1;
            }else if (count > n) {//超了，high左移
                high = mid-1;
            }

        }
        return high;
    }

    //牛顿迭代
    //一个预估值，一个实际值，x(x+1)/2=n
    //目的就是求出x=(2n-x)/x
    //其实就是求x得平方求根 ，两个乘积是x平方的数，他们的平均值比两个数本身更接近x
    public static int newton(int n){//一个预估值，一个实际值，x(x+1)/2=n

        return (int)sqart(n,n);
    }

    private static double sqart(double x, int n) {
        double res = (x + (2*n-x)/x )/2;
        if (res == x) {
            return x;
        }else {
            return sqart(res,n);
        }

    }

}
