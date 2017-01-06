package com.leetcode.searchMatrix74;

/**
 * search matrix
 * Created by pengyt on 2017/1/4.
 */
public class Solution {

    /**
     * 方法1：
     * 第一行最后一列的数大于target则删除一列
     * 第一行最后一列的数小于target则删除一行
     * 相等则找到目标
     * @param matrix 待查找矩阵
     * @param target 目标
     * @return 结果
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)
            return false;
        int n = matrix[0].length;
        for(int r = 0, c = n -1; r < m && c >= 0; ) {
            if(matrix[r][c] > target) {
                c--;
            } else if(matrix[r][c] < target) {
                r++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法2：分治
     * AB
     * CD
     * 根据中间位置的判断，可以剔除A或者D
     */

    public boolean find(int[][] matrix, int x1, int y1, int x2, int y2, int target) {
        if((x1 > x2) || (y1 > y2)) {
            return false;
        }
        int midx = (x1 + x2) >> 1;
        int midy = (y1 + y2) >> 1;
        if(matrix[midx][midy] == target) {
            return true;
        }
        return target < matrix[midx][midy] ?
                (find(matrix, x1, y1, midx - 1, y2, target) || find(matrix, midx, y1, x2, midy - 1, target)) :
                (find(matrix, x1, midy + 1, x2, y2, target) || find(matrix, midx + 1, y1, x2, midy, target)) ;
    }
    /**
     *
     * @param matrix 待查找矩阵
     * @param target 目标
     * @return 结果
     */
    public boolean searchMatrixOpt2(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)
            return false;
        int n = matrix[0].length;
        return find(matrix, 0, 0, m - 1, n - 1, target);
    }

    /**
     * 方法3
     * AB
     * CD
     * 根据中位线剔除A和D，从B和C中寻找
     */

    // matrix[mid]的中位线
    public int help(int[] matrix, int y1, int y2, int target) {
        int left = y1;
        int right = y2;
        while(left <= right) {
            int mid = (left + right) >> 1;
            if(matrix[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }


    public boolean find2(int[][] matrix, int x1, int y1, int x2, int y2, int target) {
        if((x1 > x2) || (y1 > y2)) {
            return false;
        }
        int midx = (x1 + x2) >> 1;
        int indy = help(matrix[midx], y1, y2, target);
        if(indy >= y1 && matrix[midx][indy] == target) {
            return true;
        }
        return find2(matrix, x1, indy + 1, midx - 1, y2, target) || find2(matrix, midx + 1, y1, x2, indy, target);
    }


    public boolean searchMatrixOpt3(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)
            return false;
        int n = matrix[0].length;
        return find2(matrix, 0, 0, m - 1, n - 1, target);
    }

    public static void main(String[] args) {
        int[][] matrix = {};//{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;
        Solution solution = new Solution();
        System.out.print(solution.searchMatrixOpt3(matrix, target));
    }
}
