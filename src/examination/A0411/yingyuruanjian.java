package examination.A0411;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-11 18:
 * 小易是班级的英语课代表, 他开发了一款软件开处理他的工作。
 * 小易的软件有一个神奇的功能，能够通过一个百分数来反应你的成绩在班上的位置。“成绩超过班级 ...% 的同学”。
 * 设这个百分数为 p，考了 s 分，则可以通过以下式子计算得出 p：
 * p = ( 分数不超过 s 的人数 - 1)  班级总人数
 * 突然一天的英语考试之后，软件突然罢工了，这可忙坏了小易。成绩输入这些对于字写得又快又好的小易当然没有问题，但是计算这些百分数……这庞大的数据量吓坏了他。
 * 于是他来找到你，希望他编一个程序模拟这个软件：给出班级人数 n，以及每个人的成绩，请求出某几位同学的百分数。
 * <p>
 * 输入描述:
 * 第一行一个整数 n，表示班级人数。
 * 第二行共 n 个自然数，第 i 个数表示第 i 位同学的成绩 a_i。
 * 第三行一个整数 q，表示询问的次数。
 * 接下来 q 行，每行一个数 x，表示询问第 x 位同学的百分数。
 * <p>
 * <p>
 * 输出描述:
 * 输出应有 q 行，每行一个百分数，对应每一次的询问。
 * <p>
 * 为了方便，不需要输出百分号，只需要输出百分号前的数字即可。四舍五入保留六位小数即可。
 * <p>
 * 输入例子1:
 * 3
 * 100 98 87
 * 3
 * 1
 * 2
 * 3
 * <p>
 * 输出例子1:
 * 66.666667
 * 33.333333
 * 0.000000
 **/
public class yingyuruanjian {
    public static void main(String[] args) {
//        int[] sores = new int[]{100, 98, 97};
//        int[] arr = new int[]{100, 98, 97};
//        int target = 1;
//        Arrays.sort(arr);

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sores = new int[n];
        for (int i = 0; i < n; i++) {
            sores[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        int[] searchSore = new int[q];
        for (int i = 0; i < q; i++) {
            int t = scanner.nextInt();
            searchSore[i] = sores[t-1];
        }
        Arrays.sort(sores);
        for (int i = 0; i < q; i++) {
            int res = getResult(sores, searchSore[i]) - 1;
            double r = (double)res/ (double) sores.length * 100;
            DecimalFormat decimalFormat = new DecimalFormat("#.######");
            System.out.println(decimalFormat.format(r));
        }



    }

    static int getResult(int[] arr, int targetSore) {
        int left = 0;
        int right = arr.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (targetSore == arr[mid]){
                left = mid + 1;
            }else if(targetSore > arr[mid]){
                left = mid + 1;
            } else if (targetSore < arr[mid]){
                right = mid;
            }
        }
        return left -1;
    }
}
