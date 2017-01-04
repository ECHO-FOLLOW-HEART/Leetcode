package com.leetcode.twosum1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1 Two Sum
 * Created by pengyt on 2017/1/4.
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            if(map.isEmpty())
                map.put(nums[i], i);
            else {
                if(map.containsKey(target - nums[i])) {
                    result[0] = map.get(target - nums[i]);
                    result[1] = i;
                    break;
                } else {
                    map.put(nums[i], i);
                }
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        int[] numbers = {3,2,4};
//        int[] result = twoSum(numbers, 6);
//        System.out.print(result[0] + " " + result[1]);
//    }
}
