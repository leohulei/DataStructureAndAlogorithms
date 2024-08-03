package src.main.java.classical;

public class MaxMoney {
    public static void main(String[] args) {
//        int[] num = new int[]{1,2,3,1};
        int[] num = new int[]{2,7,9,3,1};
//        System.out.println(maxMoney(num,num.length-1));
//        System.out.println(maxMoney2(num,0));
//        System.out.println(sum(5,6));
//        System.out.println(dp(num));
        System.out.println(dpc(num));

        TreeNode node5 = new TreeNode(1,null,null);
        TreeNode node4 = new TreeNode(3,null,null);
        TreeNode node3 = new TreeNode(3,null,node5);
        TreeNode node2 = new TreeNode(2,null,node4);
        TreeNode node1 = new TreeNode(3,node2,node3);
        int[] t = dfs(node1);
        System.out.println(Math.max(t[0],t[1]));

    }

    static int maxMoney(int[] num, int index){
        if (num == null || index<0){
            return 0;
        }
        if (index == 0){
            return num[0];

        }
        //当下标为index时，index-1余index-2 两个谁大就选谁,但是当选择index-2的时候，他的最优解是要加上他本身的
        //因为如果index-2选了的话，index也是可以选的
        int l = maxMoney(num,index-1);
        int r = maxMoney(num,index-2)+num[index];
        return Math.max(l,r);

    }

    //首位不相连
    static int dp(int[] num){
        int length = num.length;
        if (null == num || length == 0){
            return 0;
        }
        if (length == 1){
            return num[length-1];
        }
        int[] dp = new int[length];
        dp[0] =num[0];
        dp[1] =Math.max(num[0],num[1]);
        for (int i = 2; i <length ; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+num[i]);//计算出i位置的最优解，并保存在dp数组
        }
        return dp[length-1];//最后位置的最优解就是最终的解
    }

    //dp优化
    static int dpc(int[] num){
        int length = num.length;
        if (null == num || length == 0){
            return 0;
        }
        if (length == 1){
            return num[length-1];
        }
        int first = num[0];
        int second = num[1];
        for (int i = 2; i <length ; i++) {
            int temp = second;
            second = Math.max(first+num[i],second);//计算出i位置的最优解，并保存在dp数组
            first = temp;
        }
        return second;//最后位置的最优解就是最终的解
    }


    //首位相连
    static int dp2(int[] num,int start, int end){
        int first = num[start];
        int second = Math.max(num[start],num[start+1]);
        for (int i = start+2; i <=end ; i++) {
            int temp = second;
            second = Math.max(first+num[i],second);
            first = temp;
        }
        return second;
    }

    static int maxMoney2(int[] num, int index){
        if (num == null || index>=num.length){
            return 0;
        }
        if (index == num.length-1){
            return num[index];

        }
        int l = maxMoney2(num,index+1);
        int r = maxMoney2(num,index+2)+num[index];
        return Math.max(l,r);

    }
    //求x-Y的和
    static int sum(int x,int y){
        if(x==y){
            return x;
        }

        return x + sum(x+1,y);

    }

    //int[]{select最优解，noSelect最优解}
    public static int[] dfs(TreeNode node){
        if(node == null){
            return new int[]{0,0};
        }

        int[] l = dfs(node.left);//选左边的最优解
        int[] r = dfs(node.right);//选右边的最优解
        //当前节点选了，那就不能选他的左右节点 所以就是当前节点的值与左右都不选的值
        int select = node.val + l[1]+r[1];
        //当前节点不选，那就是它选左边的最优与右边的最优的和
        int noSelect = Math.max(l[0],l[1])+Math.max(r[0],r[1]);

        return new int[]{select,noSelect};

    }
}
