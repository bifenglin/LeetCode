package labuladong;

import java.util.Arrays;

/**
 * @version 1.0
 * @program: LeetCode
 * @description:给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。算法的函数签名如下：
 * // coins 中是可选硬币面值，amount 是目标金额
 * int coinChange(int[] coins, int amount);
 * @author: bifenglin
 * @create: 2020-11-12 16:19
 */
public class CouLingQian {

    public static void main(String[] args) {

    }

    // coins 中是可选硬币面值，amount 是目标金额
    int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) continue;
                dp[i] = Math.min(dp[i], (dp[i - coins[j]]) + 1);
            }
        }
        return (dp[amount - 1] == amount + 1) ? -1 : dp[amount - 1];
    }
}
