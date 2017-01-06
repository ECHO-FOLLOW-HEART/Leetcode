package com.leetcode.maxSubArray53;

/**
 * Maximum Subarray
 * Created by pengyt on 2017/1/4.
 */
public class Solution {

    /**
     * 方法1 sum记录当前最长连续子数组和(正数)，
     * 如果前面的子数组和小于0，则sum重新从下一个数开始
     * max用于记录当前最大子数组的和
     * 时间复杂度O(n)，空间复杂度O(1)
     * @param nums 输入数组
     * @return 最大数
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int len = nums.length;
        int sum = nums[0];
        for(int i = 1; i < len; i++) {
            if(sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if(max < sum)
                max = sum;
        }
        return max;
    }

    public int maxSubArrayDp(int[] nums) {
        int max = nums[0];
        int len = nums.length;
        int endHere = nums[0];
        for(int i = 1; i < len; i++) {
            endHere = Math.max(endHere + nums[i], nums[i]);
            max = Math.max(max, endHere);
        }
        return max;
    }
}
