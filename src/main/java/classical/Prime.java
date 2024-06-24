package src.main.java.classical;


/**
 * 统计N以内的素数
 * 素数：只能被1和自身整除的数，0、1除外
 */
public class Prime {
    public static void main(String[] args) {
        int sum = 0 ;//素数的个数
        //100以内素数的个数
        for (int i = 2; i < 100; i++) {
            sum += isPrime(i) ? 1 :0 ;
        }
        System.out.println(sum);
        System.out.println(aishaifa(100));
    }

    //判断一个数是否是素数 [2,n-1] 没有他能整除的数就是
    public static boolean isPrime(int x){
        for (int i=2; i<x;i++){//这里可以优化为i*i <= x 因为我们只需要计算到 根号i*根号I 之后的符合乘法交换律
            if (x%i == 0) {
                return false;
            }
        }
        return true;
    }
    //埃筛法 遍历到素数就对素数倍增找到合数，然后跳过遍历减少次数
    public static int aishaifa(int n){
        //假设当前所有数都是素数
        boolean[] isPrime = new boolean[n];//默认false是素数
//        Arrays.fill(isPrime,true);//为方便理解，也可以全部填充为true，但是会增加开销
        int count = 0;//记录素数的个数
        for (int i = 2; i < n; i++) {
            if(!isPrime[i]){//如果是素数
                count ++;
                for (int j = 2*i; j < n; j+=i) {
                    isPrime[j] = true;
                }

            }
        }
        return count;
    }

}
