package examination.A0411;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-11 19:56
 **/
public class huangyexingdong {
    static char[][] ground;
    static int n, res;

    public static void main(String[] args) {
//        n = 6;
//        ground = new char[][]{
//                "..1.#.".toCharArray(),
//                "2##3#8".toCharArray(),
//                ".#.##.".toCharArray(),
//                ".#6#9.".toCharArray(),
//                "4###..".toCharArray(),
//                "..7..5".toCharArray(),};
//        int a = 0, b = 0;

        Scanner scanner = new Scanner(System.in);
        n = Integer.valueOf(scanner.nextLine());
        ground = new char[n][n];
        int a, b;
        for (int i = 0; i < n; i++) {
            ground[i] = scanner.nextLine().toCharArray();
        }
        String[] str = scanner.nextLine().split(" ");
        a = Integer.valueOf(str[0]);
        b = Integer.valueOf(str[1]);

        res = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        while (queue.size() > 0) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (x < 0 || x >= n || y < 0 || y >= n || ground[x][y] == '#') continue;
            if (ground[x][y] >= '0' && ground[x][y] <= '9') {
                res += (ground[x][y] - '0');
            }
            ground[x][y] = '#';
            queue.offer(new int[]{x + 1, y});
            queue.offer(new int[]{x - 1, y});
            queue.offer(new int[]{x, y + 1});
            queue.offer(new int[]{x, y - 1});
        }


//        dfs(a, b);
        System.out.println(res);
    }
}

//    static void dfs(int x, int y) {
//        if(x<0 || x>=n || y<0 || y>=n || ground[x][y] == '#') return;
//        if(ground[x][y] >= '0' && ground[x][y]<='9') {
//            res += (ground[x][y]-'0');
//        }
//        ground[x][y] = '#';
//        dfs(x+1, y);
//        dfs(x-1, y);
//        dfs(x, y+1);
//        dfs(x, y-1);
//    }
