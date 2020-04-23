package examination.A0411;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: LeetCode
 * @description: 4.12快手-不满意度
 * @author: maple
 * @create: 2020-04-12 16:10
 **/
public class kuaishouBumanyidu {
    static int res = Integer.MAX_VALUE;
    static LinkedList<Integer> list;

    public static void main(String[] args) {
        int[] a = new int[]{8, 9, 7};
        int[] b = new int[]{5, 8, 3};
        System.out.println(Arrays.toString(waitInLine(a, b)));
    }

    static int[] waitInLine(int[] a, int[] b){
        int[] num = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            num[i] = i;
        }
        LinkedList<Integer> track = new LinkedList<Integer>();
        backtrack(a, b, num, track);
        int[] r = list.stream().mapToInt(Integer::valueOf).toArray();
        return r;
    }


    static void backtrack(int[] a, int[] b, int[] num, LinkedList<Integer> track){
        if (track.size() == num.length){
            int sore = 0;
            for (int i = 0; i < track.size(); i++) {
                int index = track.get(i);
                sore = sore + (i+1) * a[index] + (num.length - i) * b[index];
            }
            if (res > sore){
                res = sore;
                LinkedList<Integer> temp = new LinkedList();
                for (int i = 0; i < num.length; i++) {
                    temp.add(track.get(i)+1);
                }
                list = temp;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (track.contains(num[i])){
                continue;
            }
            track.add(i);
            backtrack(a, b , num, track);
            track.removeLast();
        }
    }
}
