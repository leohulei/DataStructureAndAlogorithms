package src.main.java.classical;

public class Lemon {
    public static void main(String[] args) {

        /**
         * 一杯柠檬水5元，顾客排队进行购买
         * 每位顾客只买一杯，向你支付5/10/20元面值的钱
         * 开始手中没有钱
         * 问能否给顾客找零 能true 不能false
         */
        int[] people = new int[]{5,5,10,20};
        System.out.println(pay(people));
    }

    public static boolean pay(int[] num){
        int five =0;
        int ten = 0;//定义手中5元与10元的个数，20没法找零不必关注
        //分析可知：5元不需要找零 10元需要5元找零 20元需要10+5 或者5+5+5 找零，进一步分析可知，优先找10+5能更好的延续工作

        for (int i = 0; i < num.length; i++) {
            if(num[i] == 5){
                five++;
            }else if (num[i] == 10) {
                if (five >0) {
                    ten++;
                    five--;
                }else {
                    return false;
                }
            }else if (num[i] == 20) {
                if(ten >0 && five >0){
                    ten--;
                    five--;
                }else if (five >=3) {
                    five -=3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
