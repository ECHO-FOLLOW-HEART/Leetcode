package com.leetcode.minPathSum64;

/**
 * Minimum Path Sum
 * Created by pengyt on 2017/1/4.
 */
public class Solution {
    // 方法1：时间复杂度O(m * n) 空间复杂度O(m * n)
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0) {
                    if(j == 0) {
                        dp[i][j] = grid[i][j];
                    } else {
                        dp[i][j] = dp[i][j-1] + grid[i][j];
                    }
                } else {
                    if(j == 0) {
                        dp[i][j] = dp[i-1][j] + grid[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }


    // 方法2： 优化空间：时间复杂度O(m * n) 空间复杂度O(min(m , n))
    public int minPathSumOpt(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m > n) {
            int[] dp = new int[n];
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(i == 0) {
                        if(j == 0) {
                            dp[j] = grid[i][j];
                        } else {
                            dp[j] = dp[j-1] + grid[i][j];
                        }
                    } else {
                        if(j == 0) {
                            dp[j] = dp[j] + grid[i][j];
                        } else {
                            dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
                        }
                    }
                }
            }
            return dp[n-1];
        } else {
            int[] dp = new int[m];
            for(int j = 0; j < n; j++) {
                for(int i = 0; i < m; i++) {
                    if(j == 0) {
                        if(i == 0) {
                            dp[i] = grid[i][j];
                        } else {
                            dp[i] = dp[i-1] + grid[i][j];
                        }
                    } else {
                        if(i == 0) {
                            dp[i] = dp[i] + grid[i][j];
                        } else {
                            dp[i] = Math.min(dp[i], dp[i-1]) + grid[i][j];
                        }
                    }
                }
            }
            return dp[m-1];
        }
    }
}
