package examination.A409;

/**
 * @program: LeetCode
 * @description: 金字塔
 * @author: maple
 * @create: 2020-04-09 20:55
 **/
import java.util.Scanner;

public class meituan4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        if(k==0) {
            System.out.println(1);
            return;
        } else if(k==1) {
            System.out.println(0);
            return;
        }
//        long[][] dp = new long[2][2];
//        dp[0][0] = 1; dp[0][1]=0;
//        dp[1][0] = 0; dp[1][1]=3;

        int dp10=0, dp11=3;
        for (int i = 2; i < k+1; i++) {
            int temp1 = dp10;
            int temp2 = dp11;
            dp10 = temp2;
            dp11 = temp1+temp1+temp1+temp2+temp2;
//            System.out.printf("%d %d %d\n", dp[i][0], dp[i-2][0], dp[i-1][1]);
        }
        System.out.println(dp10%1000000007);

    }

}
