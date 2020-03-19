package stringArithmetic;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-02-29 19:49
 **/
public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String s = scan.nextLine();
            System.out.print(test(s));
        }
    }

    public static String test(String s){
        StringBuffer sb = new StringBuffer();
        HashSet<String> set = new HashSet<String>();

        for(int i=0; i < s.length(); i++){
            if(!set.contains(s.substring(i, i+1))){
                set.add(s.substring(i,i+1));
                sb.append(s.substring(i,i+1));
            }
        }
        return sb.toString();
    }
}
