package examination.A409;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-09 19:11
 **/
public class meituan2 {
    public static void main(String[] args) {
//        int[] start = new int[]{5,3,1,4,2};
//        int[] end = new int[]{2,4,5,1,3};
//        System.out.print(getResult(start, end));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            end[i] = scanner.nextInt();
        }
        System.out.print(getResult(start, end));
    }

    static int getResult(int[] start, int[] end){
        int res = 0;
        HashSet set = new HashSet();
        for (int i = 0; i < start.length; i++) {
            for (int j = end.length-1; j >= 0; j--) {
                if (end[j] == start[i]){
                    break;
                }
                if (set.contains(end[j])){
                    res++;
                    break;
                }
            }
            set.add(start[i]);
        }
        return res;
    }
}
