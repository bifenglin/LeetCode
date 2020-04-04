package examination.Apr;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-01 19:20
 **/
public class shebaohaopaixu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }

        Arrays.sort(s);
        int index = 0;
        int count = 1;
        String[] temp = new String[s.length];
        temp[0] = s[0];
        List<Integer> counts = new ArrayList<>();
        for (int i = 1; i < s.length; i++) {
            if (i == s.length -1){
                if (s[i].equals(temp[index])){
                    index++;
                    count++;
                    counts.add(count);
                    temp[index] = s[i];
                } else {
                    index++;
                    counts.add(count);
                    counts.add(1);
                    temp[index] = s[i];
                }
                break;
            }

           if (s[i].equals(temp[index])){
               count++;
           } else {
               index++;
               temp[index] = s[i];
               counts.add(count);
               count=1;
           }
        }

        for (int i = 0; i < counts.size(); i++) {
            System.out.print(temp[i] + " ");
            System.out.println(counts.get(i));
        }
    }

}
