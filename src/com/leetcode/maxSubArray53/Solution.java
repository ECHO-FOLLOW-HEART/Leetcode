package com.leetcode.maxSubArray53;

/**
 * Maximum Subarray
 * Created by pengyt on 2017/1/4.
 */
public class Solution {

    /**
     * ����1 sum��¼��ǰ������������(����)��
     * ���ǰ����������С��0����sum���´���һ������ʼ
     * max���ڼ�¼��ǰ���������ĺ�
     * ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
     * @param nums ��������
     * @return �����
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
