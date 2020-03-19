package examination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-03-19 19:09
 **/
public class zhayinhua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        int[][] nums = new int[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        System.out.print(zhayinhua(nums, n));

    }

    public static int zhayinhua(int[][] nums, int n) {
        Arrays.sort(nums[0]);
        Arrays.sort(nums[1]);
        int a = 0;
        int b = 0;
        if (n < 3) {
            for (int i = 0; i < n; i++) {
                a = nums[0][n - i - 1] + a;
                b = nums[1][n - i - 1] + b;
            }
        } else {
            a = nums[0][n - 1] + nums[0][n - 2] + nums[0][n - 3];
            b = nums[1][n - 1] + nums[1][n - 2] + nums[1][n - 3];
        }
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

}