package stringArithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description: 构造回文
 * @author: maple
 * @create: 2020-02-29 18:40
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
输出需要删除的字符个数。

输入描述:

输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.



输出描述:

对于每组数据，输出一个整数，代表最少需要删除的字符个数。


输入例子1:
abcda
google

输出例子1:
2
2
 **/
public class constructPalindromes {

    public static void main(String[] args){
//        Scanner scan= new Scanner(System.in);
//        List<String> list = new ArrayList();
//        System.out.println("开始输入");
//        while(scan.hasNext()){
//            list.add(scan.nextLine());
//        }
        List<String> list = new ArrayList();
        list.add("abcda");
        list.add("google");
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            result.add(construct(list.get(i)));
        }
        for (int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static int construct(String s){
        int[][] dp = new int[s.length()+1][s.length()+1];
        String s2 = new StringBuilder(s).reverse().toString();
        for (int i =1; i < dp.length; i++) {
            for (int j=1; j < dp[0].length; j++){
                dp[i][j]=s.charAt(i-1) == s2.charAt(j-1)? dp[i-1][j-1] +1: Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return s.length() - dp[s.length()][s.length()];
    }
}
