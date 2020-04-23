package examination.jingdong;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-18 20:01
 **/
public class liechepaizuo2 {




    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int getRes(int n, int[][] data) {
        // 从小到大排序
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int count = 1;
        int temp = 1;
        int x_end = data[0][1];
        for (int i = 0; i < n; i++) {
            int start = data[i][0];
            // 如果开始小于上一个的end temp++
            if (start <= x_end){
                temp++;
                x_end = Math.min(data[i][1],x_end);
            } else { // 重新开始记数，留最大值
                count = Math.max(temp, count);
                temp = 1;
            }
        }
        count = Math.max(temp, count);
        return count;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] data = new int[n][2];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                data[i][j] = scanner.nextInt();
            }
        }

        int res;res = getRes(n, data);


        System.out.println(res);

    }
    public static void main1(String[] args) {
//        n=5;
//        int h0=1;
//        data=new int[]{2,3,2,4,3};

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] traveller = new int[n][2];
        for(int i=0; i<n; i++) {
            traveller[i][0] = scanner.nextInt();
            traveller[i][1] = scanner.nextInt();
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (traveller[j][1] < traveller[i][0] || traveller[i][1] < traveller[j][0])
                    continue;
                else
                    cur++;
            }
            res = Math.max(res, cur);
        }
        System.out.println(res);
    }


}
