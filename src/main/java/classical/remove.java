package src.main.java.classical;

import java.util.Arrays;
import java.util.LinkedList;

public class remove {
    public static void main(String[] args) {
        //{2,6,1,5,3,7,1};
       LinkedList<Integer> linkedList= new LinkedList<>();
       linkedList.add(2);
       linkedList.add(1);
       linkedList.add(6);
       linkedList.add(1);
       linkedList.add(5);
        linkedList.add(1);
       linkedList.add(3);
       linkedList.add(7);
//        linkedList.add(1);
//        linkedList.add(3);
//        linkedList.add(1);
//        linkedList.add(4);
//        linkedList.add(0);

        int k = 4;
        getResult(linkedList,4);
    }

    //求移除k个数后的最小值-贪心算法，区间最优解
    public static void getResult(LinkedList<Integer> list, int k){
        int l = list.size();
        int flag = 0;//记录移除元素个数，
        while (flag<k){
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i) > list.get(i+1)){
                    list.remove(i);
                    flag++;
                    break;
                }
                if (i == list.size()-2){
                    list.removeLast();
                    flag++;
                }

            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }

}
