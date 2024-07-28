package src.main.java.classical;

public class ChampTower {
    public static void main(String[] args) {
        System.out.println(champTower(5,3,2));
    }

    /**
     *
     * @param sum
     * @param c
     * @param l
     * @return
     * i行j列多余出来的，会均分到i+1行的j列与j+1列
     */
    public static double champTower(int sum,int c, int l){
        double[][] ca = new double[100][100];
        ca[0][0] = sum;//最顶层装的酒
        for (int i = 0; i <= c; i++) {
            for (int j = 0; j <=i; j++) {
                double d =(ca[i][j]-1)/2;//每一个杯子多出来向两边分别流下去的酒
                if(d > 0){//超过一杯确实流下去了
                    ca[i+1][j] +=d;
                    ca[i+1][j+1] +=d;
                }
            }
        }
        //小于一杯放的是结果，大于一杯就是一杯
        return Math.min(1,ca[c][l]);
    }
}
