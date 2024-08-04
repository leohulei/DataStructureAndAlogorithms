package src.main.java.classical;

import java.util.LinkedList;
import java.util.Queue;

/**
 *Dota2 的世界里有两个阵营：Radiant(天辉)和 Dire(夜魇)
 * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们
 * 以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的一项：
 * 禁止一名参议员的权利：参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
 * 宣布胜利： 如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的
 * 有关变化。
 * 给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜
 * 魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。
 * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结
 * 束。所有失去权利的参议员将在过程中被跳过。
 * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并
 * 在 Dota2 游戏中决定改变。输出应该是 Radiant 或 Dire。
 */
public class RD {
    public static void main(String[] args) {
        String str = "RDDR";
        System.out.println(victory(str));

    }

    public static String victory(String str){
        //分析可知，谁的位置靠前谁先投票，先禁掉对方靠前的议员则获胜的概率就大
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        for (int i=0; i<str.length(); i++){//把R D的下标分辨放到两个队列中
            if (str.charAt(i) == 'R') {
                r.add(i);
            }else {
                d.add(i);
            }
        }
        //当r 或者 d 为空的时候结果明确，循环终止
        while (!r.isEmpty() && !d.isEmpty()){
            int rPoll = r.poll(),dPoll = d.poll();
            if (rPoll < dPoll){//谁小谁先投
                //这里把可以进入下一轮的重新入队
                r.offer(rPoll + str.length());//下标增加至少字符串长度避免第二轮的禁掉第一轮还没结束的
            }else {
                d.offer(dPoll + str.length());
            }
        }

        return r.isEmpty()? "D" : "R";
    }
}
