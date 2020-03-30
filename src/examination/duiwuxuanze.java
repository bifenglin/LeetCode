package examination;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-03-23 19:03
 **/
public class duiwuxuanze {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.print(duiwuxuanze(a));
    }

    static int duiwuxuanze(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = nchoosek(n, i) * i + res;
        }
        res = (int) (res % (Math.pow(10, 9) + 7));
        return res;
    }


    //数学公式法
    private static int nchoosek(int n, int k) {
        if(n > 34 || (n == 34 && k >= 16 && k <= 18)){
            throw new IllegalArgumentException("N(" + n + ") and k(" + k + ") don't meet the requirements.");
        }
        checknk(n, k);
        k = (k > (n - k)) ? n - k : k;
        if(k <= 1){  // C(n, 0) = 1, C(n, 1) = n
            return k == 0 ? 1 : n;
        }
        int[][] yhTriangle = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            yhTriangle[i][0] = 1;
            yhTriangle[i][i] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                yhTriangle[i][j] = yhTriangle[i - 1][j - 1] + yhTriangle[i - 1][j];
            }
        }
        return yhTriangle[n][k];

    }


    public static void checknk(int n, int k) {
        if (k < 0 || k > n) { // N must be a positive integer.
            throw new IllegalArgumentException("K must be an integer between 0 and N.");
        }
    }

}
