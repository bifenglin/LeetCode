package examination.A0411;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-11 19:35
 * Connected to the target VM, address: '127.0.0.1:61402', transport: 'socket'
3
1 2 3 1
2 1 3 2
3 1 2 3
1 1 2 3
2 1 2 3
3 1 2 3
 **/
public class liangliangzudui {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] newUsers = new int[n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n+1; j++) {
                newUsers[i][j] = scanner.nextInt();
            }
        }
        int[][] oldUsers = new int[n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n+1; j++) {
                oldUsers[i][j] = scanner.nextInt();
            }
        }
        int[][] res = getResult(n, newUsers, oldUsers);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] getResult(int n, int[][] newUsers, int[][] oldUsers) {
        ArrayList<Integer>[] match = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            match[i] = new ArrayList<>();
        }
        int[][] res = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < n; j++) {
                match[newUsers[j][i]].add(j);
            }


            for (int j = 1; j <= n; j++) {
                if (match[j].size() == 0) {
                    continue;
                } else if (match[j].size() == 1) {
                    if (res[match[j].get(0)][0] == 0){
                        res[match[j].get(0)][0] = match[j].get(0);
                        res[match[j].get(0)][1] = j;
                    }
                } else if (match[j].size() > 1) { // 处理两个选同一个
                    int[] old = oldUsers[j-1];
                    for (int k = 0; k < old.length; k++) {
                        for (int l = 0; l < match[j].size(); l++) {
                            if (old[k] == match[j].get(l)){
                                res[match[j].get(l)][0] = match[j].get(l);
                                res[match[j].get(l)][1] = j;
                            }
                        }
                    }
                }
            }

        }
        return res;
    }
}
