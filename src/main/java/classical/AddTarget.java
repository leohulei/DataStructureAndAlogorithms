package src.main.java.classical;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 示例 1：

 输入：nums = [2,7,11,15], target = 9
 输出：[0,1]
 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 示例 2：

 输入：nums = [3,2,4], target = 6
 输出：[1,2]
 示例 3：

 输入：nums = [3,3], target = 6
 输出：[0,1]
 */
public class AddTarget {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        int target = 10;
        System.out.println(Arrays.toString(solution(nums,target)));
        System.out.println(Arrays.toString(solution2(nums,target)));
        System.out.println(Arrays.toString(twoSearch(nums,target)));
        System.out.println(Arrays.toString(twoPoint(nums,target)));
    }

    //暴力解法
    public static int[] solution(int[] nums,int target){
        int[] res = new int[2];
        for (int i=0; i<nums.length; i++){
            for (int j = 1; j < nums.length; j++) {//这里可以将j = i+1 来减少循环次数
                if(nums[i]+nums[j] ==target){
                    res[0] =i;
                    res[1] =j;
                    return res;
                }
            }
        }
        return res;
    }
    //x+y=target 我们找到一个数x的时候，只需要确定target-x在不在数组中即可
    public static int[] solution2(int[] nums,int target){
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                res[1] = i;
                res[0] = map.get(target-nums[i]);
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }


    //对于一个升序数组，使用二分法去解题
    public static int[] twoSearch(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            int low =i;//低位下标
            int high = nums.length-1;//高位下标
            while (low <= high){//区间压缩到重合
                int mid =(high-low)/2+low;//二分位的下标
                if (nums[mid] == target-nums[i]){
                    return new int[]{i,mid};
                }else if (nums[mid] > target-nums[i]) {//高位右移
                    high =mid-1;

                }else {
                    low =mid+1;
                }
            }
        }
        return new int[]{0};
    }

    //用双指针算法来解题：
    //l 从左往右 r 从右往左 l+r与target做对比，如果比target大，那么r往左移，如果比target小则l向右移动
    public static int[] twoPoint(int[] nums,int target) {
        int l = 0; //初始左下标
        int r = nums.length - 1;//初始右下标
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                return new int[]{l,r};
            }
            if (nums[l] + nums[r] > target) {
                r = r - 1;
            }else {
                l = l+1;
            }
        }
        return new int[]{0};
    }
}
