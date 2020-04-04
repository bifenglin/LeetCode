package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 二进制矩阵中的最短路径
 * @author: maple
 * @create: 2020-04-01 14:46
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 * <p>
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 * <p>
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[0,1],[1,0]]
 * <p>
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：[[0,0,0],[1,1,0],[1,1,0]]
 * <p>
 * 输出：4
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 * <p>
 **/
public class shortestPathBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,0},{1,1,0},{1,1,0}};
//        int[][] grid = new int[][]{{0,1},{1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));

    }

    static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0) return -1;
        if (grid[0][0] == 1) return -1;
        int m = grid.length;
        int n = grid[0].length;
        LinkedList<int[]> linkedList = new LinkedList();
        linkedList.add(new int[]{0,0});
        grid[0][0] = 1;
        int[][] dir = {{1,0}, {1,1}, {1,1,},{0, 1}, {-1, 1}, {-1,0},{-1, -1}, {0, -1}};
        int path = 0;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] =true;
        while (!linkedList.isEmpty()){
            int len = linkedList.size();
            path++;
            for (int i = 0; i < len; i++) {
                int[] data = linkedList.poll();
                int x = data[0];
                int y = data[1];
                if (x == m-1 && y == n-1) return path;
                for (int[] d: dir) {
                    int x1 = x + d[0];
                    int y1 = y + d[1];
                    if (x1 < 0 || y1 <0 || x1 >= m || y1 >= n || grid[x1][y1] == 1 || visited[x1][y1]){
                        continue;
                    }
                    visited[x1][y1] = true;
                    linkedList.add(new int[]{x1, y1});
                }
            }
        }
        return -1;
    }

}
