package src.main.java.剑指offer;

import java.util.HashSet;

/**
 *
 */
public class offer03 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
        System.out.println(findRepeatNumberBySet(nums));
    }

    /**
     * 暴力解法
     * @param nums
     * @return
     */
    private static int findRepeatNumber(int[] nums) {
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }

    private static int findRepeatNumberBySet(int[] nums) {
        HashSet<Integer> dict = new HashSet<>();//利用hashset 不重复存储元素
        for (int num : nums) {
            if (dict.contains(num)){
                return num;
            }else {
                dict.add(num);
            }

        }
        return -1;
    }

}
