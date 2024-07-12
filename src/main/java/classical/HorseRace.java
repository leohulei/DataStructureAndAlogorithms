package src.main.java.classical;

import java.util.*;

/**
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 */
public class HorseRace {
    //优势洗牌  田忌赛马
    public static void main(String[] args) {
        int[] A = {2,5,7,9,8};
        int[] B = {10,2,6,5,8};
        System.out.println(Arrays.toString(getResult(A,B)));
    }

    public static int[] getResult(int[] A, int[] B){
        int[] res = new int[A.length];
        //B数组保持原样，但为了减少对比次数，使用它的克隆数组排序后对比
        int[] bSort = B.clone();
        //先对两个数组进行排序
        Arrays.sort(A);
        Arrays.sort(B);

        //定义一个B中元素对应a关系的集合
        Map<Integer, Deque<Integer>> bMap = new HashMap<>();
        Deque<Integer> trabsh = new LinkedList<>();//定义一个垃圾桶。存放前期废掉的元素来匹配B中的大元素
        for (int b: B) {
            bMap.put(b,new LinkedList<>());//先把关系构造好
        }
        int j = 0;
        for (int a :A) {
            if (a> B[j]){//如果同位置A大就把这个关系存下来
                bMap.get(B[j++]).add(a);//与写在下边是一样的
//                j++;
            }else {
                trabsh.add(a);
            }
        }
        //取出刚刚建立的关系
        for (int i = 0; i < B.length; i++) {
            if (bMap.get(B[i]).size()>0){//如果能找到对应的值，就把对应的值放一个进来（顺序没有关系所以剩下的不要）
                res[i] = bMap.get(B[i]).removeLast();
            }else {//找不到对应的值，就从垃圾桶里随便放一个值与之匹配
                res[i] = trabsh.removeLast();
            }
        }


        return res;
    }

}
