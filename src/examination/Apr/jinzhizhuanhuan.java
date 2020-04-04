package examination.Apr;

import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-01 06:47
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 * <p>
 * <p>
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 * <p>
 * <p>
 * 输出描述:
 * 输出该数值的十进制字符串。
 * <p>
 * <p>
 * 输入例子1:
 * 0xA
 * <p>
 * 输出例子1:
 * 10
 **/
public class jinzhizhuanhuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            System.out.println(jinzhizhuanhuan(s));
        }
    }

    static int jinzhizhuanhuan(String s){
        char[] chars = s.toCharArray();
        if (chars.length < 3) return 0;
        int res = 0;
        for (int i = 2; i < chars.length; i++) {
            if (chars[i] - 'A' >= 0){
                res = chars[i] - 'A' + 10 + res*16;
            } else {
                res = chars[i] - '0' + res*16;
            }
        }
        return res;
    }
}
