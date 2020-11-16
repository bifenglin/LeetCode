package labuladong;

/**
 * @version 1.0
 * @program: LeetCode
 * @description:
 * @author: bifenglin
 * @create: 2020-10-10 15:15
 */
public class feibonaqie {

    public static void main(String[] args) {
        getResult(3);
    }

    public static void getResult(int n){
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i -1]+ dp[i -2];
        }
        System.out.println(dp[n]);

    }

}
