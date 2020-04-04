package examination.Apr;

import java.text.DecimalFormat;
import java.util.Scanner;


public class xiaocangsheji4 {
    static double res = 0.0;

    public static void main(String[] args) {
//        int n = 2;
//        double[] p = new double[]{0.80, 0.50};
//        int[] a = new int[]{1, 2};
//        xiaocangsheji4(n, p, a, 1, 0, 0.0);
//        System.out.println(res);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] p = new double[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        xiaocangsheji4(n, p, a, 1, 0, 0);
        DecimalFormat df = new java.text.DecimalFormat("#.00");
        System.out.println(df.format(res));
    }

    static void xiaocangsheji4(int n, double[] p, int[] a, double bp, int count, double temp) {
        if (count >= n) {
            res = Math.max(res, temp);
            return;
        }
        for (int i = 0; i < n - count; i++) {
            double nt = temp + (i+1) * a[i] * Math.pow(p[i], i + 1) * bp;
            xiaocangsheji4(n, p, a, bp * Math.pow(p[i], i + 1), count + i + 1, nt);
        }
    }
}
