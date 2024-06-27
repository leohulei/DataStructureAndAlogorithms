package src.main.java.classical;

/**
 * 求取斐波那契数列第N位的值。
 * 斐波那契数列：每一位的值等于他前两位数字之和。前两位固定 0，1,1,2,3,5,8。。。。
 */
public class FeiboNaQi {
    public static void main(String[] args) {
        //0,1,1,2,3,5,8,13,21,34,55,89
        System.out.println(calculate(10));
        System.out.println(twoPoint(10));
        System.out.println(dp(10));

    }

    //第一个数是0 第二个数是1 之后的数是他前边两个数的和
    public static int calculate(int num){
        int[] nums = new int[num+1];//下标是num 数组最少num+1
        nums[0] = 0 ;
        nums[1] = 1 ;
        if (num==0){
            return 0;
        }
        if (num==1){
            return 1;
        }
        int i =2;
        while (i <= num){
            nums[i]=nums[i-1]+nums[i-2];
            if(i<num){
                i++;
            }else {
                break;
            }

        }
        return nums[num-2]+nums[num-1];
    }

    public static int twoPoint(int num){
        if(num ==0){
            return 0;
        }
        if(num ==1){
            return 1;
        }
        int low = 0;
        int hight =1;

        for (int i = 2; i <= num; i++) {
            int sum = low+hight;
            low = hight;
            hight =sum;

        }
        return hight;

    }

    public static int dp(int n){
        int[] dp = new int[n+1];
        dp[0] =0;
        dp[1] =1;
        if (n==0){
            return dp[0];
        }
        if (n==1){
            return dp[1];
        }

        for (int i=2; i<dp.length;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
