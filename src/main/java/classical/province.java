package src.main.java.classical;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c
 * 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相
 * 连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 * 亲戚问题、朋友圈问题
 */
public class province {
    public static void main(String[] args) {
        int[][] a = {{1,1,0},{1,1,0},{0,0,1}};//2
        int[][] b = {{1,0,0},{0,1,0},{0,0,1}};//3
//        System.out.println(getProvince(a));
//        System.out.println(getProvince(b));
        System.out.println(bfs(b));
    }

    public static int getProvince(int[][] connect){
        //首先确定城市个数，要挨个遍历
        //遍历过程中记录城市是否被访问过，不重复遍历
        //记录省份个数
        int citys = connect.length;
        boolean[] visited = new boolean[citys];
        int province = 0;

        //没被访问
        for (int i=0; i<citys; i++){
            if (!visited[i]) {
                //深度遍历所有和城市i关联的城市
                dfs(i,citys,visited,connect);//访问二维数组第i个内的每个元素，数量是citys，是否被访问过标识，城市之间的关联关系
                province++;
            }
        }
        return province;
    }

    private static void dfs(int i, int citys, boolean[] visited, int[][] connect) {

        for (int j = 0; j <citys ; j++) {
            if (visited[j] != true && connect[i][j] == 1){//没访问，且关联关系为1
                visited[j] =true;
                dfs(j,citys,visited,connect);
            }
        }
    }


    //广度优先算法
    public static int bfs(int[][] connect){
        int citys = connect.length;
        boolean[] visited = new boolean[citys];
        int province = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        //没被访问
        for (int i=0; i<citys; i++){
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()){//为空就是遍历完了,一个while循环找一层深度
                    int k = queue.poll();
                    visited[k] =true;
                    for (int j = 0; j <citys ; j++) {
                        if (visited[j] != true && connect[i][j] == 1){//没访问，且关联关系为1
                            queue.offer(j);
                        }
                    }
                }
                province++;
            }
        }
        return province;
    }
}
