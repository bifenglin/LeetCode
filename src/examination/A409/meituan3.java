package examination.A409;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:补漏洞
 * @author: maple
 * @create: 2020-04-09 19:46
 **/
public class meituan3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if(n<=k) {
            System.out.println(n);
        }

        int right = n;
        int left = 1;

        while(left<=right) {
            double mid = (right-left)/2+left;
            int sum = 0;
            int i=0;
            while((int)(mid/Math.pow(k, i))>0) {
                sum += (int)(mid/Math.pow(k, i));
                i++;
            }
            if(sum>n) {
                right=(int)mid-1;
            } else if(sum<n) {
                left=(int)mid+1;
            } else if(sum==n) {
                right=(int)mid-1;
            }
        }
        System.out.println(left);
    }

}
