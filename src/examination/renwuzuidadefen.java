package examination;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-03-19 19:26
 **/
public class renwuzuidadefen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int[] time = new int[k];
        for (int i =0 ; i < k; i++){
            time[i] = scanner.nextInt();
        }
        Arrays.sort(time);
        System.out.print(renwuzuidadefen(n, k, m, p, q, time));
    }

    public static int renwuzuidadefen(int n, int k, int m,int p, int q, int[] time){
        int a = 0;
        int res = 0;
         while (m >= time[0]){
             if (a > n){
                 return res;
             }
             boolean flag = true;
             for (int i = 0; i < k; i++){
                 if (m-time[i] >= 0){ // 如果符合条件
                     m = m - time[i];
                     res = res+p;
                 } else {  // 如果不符合条件
                     flag = false;
                 }
             }
             if (flag){
                 res = res+q;
             }
             a++;
         }
         return res;
    }
}
