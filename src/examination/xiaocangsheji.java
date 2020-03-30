package examination;

import java.util.Scanner;

public class xiaocangsheji {

    private static double r = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int n = Integer.valueOf(line.split(" ")[0]);
        double p = Double.valueOf(line.split(" ")[1]);
        double q = Double.valueOf(line.split(" ")[2]);
        String line2 = scanner.nextLine();
        String[] splits = line2.split(" ");
        int s[] = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            s[i] = Integer.valueOf(splits[i]);
        }
        int a[] = new int[n];
        double probability =  1;
        double nP = 1;
        for (int i = 0; i < n; i++) {
            probability = probability * (p / q);
            nP = nP * (1- (p/q));
        }
        xiaocangsheji(n, probability, p/q, a, 1, s);
//        r = s[n-1] * n * nP + r;
//        r = Math.pow(s[n-1] * n, probability) + r;
        System.out.print(r);
    }

    static void xiaocangsheji(int n, double probability, double pq, int a[], int count,int s[]){
        if (count > n){
//            r = s[n-1] * count * Math.pow(probability, count) + r;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (a[i] != 1){
                a[i] = 1;
                r = s[i] * count * probability + r;
                probability = probability * (1-pq) / pq;
                xiaocangsheji(n, probability, pq, a, count+1, s);
                a[i] = 0;
            }
        }
    }

}
