package com.leetcode.reverse7;

/**
 * @author: pengyuntao02
 * @date: 2017/7/30
 */
public class Solution {
    public static int reverse(int x) {

        int absX = Math.abs(x);
        long result = 0;
        while(absX > 0) {
            result = result * 10 + (absX % 10);
            absX /= 10;
        }

        if(result > Integer.MAX_VALUE)
            return 0;
        int reverse = (int) result;
        return x < 0 ? -1 * reverse : reverse;
    }

    //public static void main(String [] args) {
    //    System.out.println(reverse(321));
    //    System.out.println(reverse(-321));
    //    System.out.println(reverse(0));
    //    System.out.println(reverse(1534236469));
    //
    //    System.out.println(Integer.MAX_VALUE);
    //}
}
