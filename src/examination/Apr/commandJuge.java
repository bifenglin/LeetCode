package examination.Apr;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-01 19:01
 **/
public class commandJuge {

    public static void main(String[] args) {
        HashSet<String> command = new HashSet<>();
        command.add("AND");
        command.add("OR");
//        command.add("NOT");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            int i = commandJuge(s, command);
            System.out.println(i);
        }
    }

    static int commandJuge(String s, HashSet command){
        if (s.length() == 0) return 1;
        String[] strings = s.split(" ");
        int flag = 0;
        int notFlag = 0;
        for (int i = 0; i < strings.length; i++) {
            String temp = strings[i];
            if (flag == 0){
                if (temp.equals("NOT")){
                    if (notFlag == 1){
                        return 0;
                    }
                    notFlag = 1;
                    continue;
                }
                if (isValue(temp)){
                    flag = 1;
                    notFlag = 0;
                } else {
                    return 0;
                }
            } else {
                if (command.contains(temp)){
                    flag = 0;
                } else {
                    return 0;
                }
            }
        }
        if (flag == 0){
            return 0;
        }
        return 1;
    }

    static boolean isValue(String s) {
        if (s.length() != 1) return false;
        if (s.charAt(0) - 'a' >= 0 && 'z' - s.charAt(0) >= 0){
            return true;
        }
        return false;
    }
}
