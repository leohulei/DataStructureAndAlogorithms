package src.main.java.classical;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private int size;
    private double sum;
    private Queue<Integer> queue;

    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.offer(val);//向队列末尾添加一个元素，如果成功返回true，超出返回false
        sum += val;
        return sum / queue.size();
    }
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1)); // 输出：1.0
        System.out.println(movingAverage.next(10)); // 输出：5.5
        System.out.println(movingAverage.next(3)); // 输出：4.66667
        System.out.println(movingAverage.next(5)); // 输出：6.0

    }
}
