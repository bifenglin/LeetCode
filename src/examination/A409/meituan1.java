package examination.A409;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-09 19:31
 **/
import java.util.Scanner;

public class meituan1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        System.out.printf("%d", n);
        String str = scanner.nextLine();
        System.out.printf("%s", str);
        int minutes = Integer.valueOf(scanner.nextLine());

        int days = minutes / 60 / 24;
        days %= 7;
        // 星期几
        int d = (n+7-days)%7 == 0 ? 7 : (n+7-days)%7;
        // 当前天的分钟数
        int m = minutes % (60*24);
        int cur = 60*Integer.valueOf(str.substring(0, 2)) + Integer.valueOf(str.substring(3, 5));
        if(cur>m) {
            cur -= m;
        } else {
            d--;
            cur = 24*60-(m-cur);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cur/60);
        sb.append(':');
        sb.append(cur%60);

        System.out.println(d);
        System.out.println(sb.toString());
    }

}
