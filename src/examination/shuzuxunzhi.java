package examination;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-03-22 19:15
 **/
public class shuzuxunzhi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] in = line.split(" ");
        Integer[] inputs = new Integer[in.length];
        for (int i = 0; i < in.length; i++) {
            inputs[i] = Integer.parseInt(in[i]);
        }
        List list = shuzuxunzhi(inputs);
        if (list.size() == 0){
            System.out.print(-1);
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)+" ");
            }
        }

    }

    static List<Integer> shuzuxunzhi(Integer[] inputs){
        List<Integer> list = new LinkedList<>();
        if (inputs.length <= 1){
            return list;
        }
        int max;
        int min;
        if (inputs[0] > inputs [1]){
            list.add(1);
            max = inputs[0];
            min = inputs[1];
        } else {
            max = inputs[1];
            min = inputs[0];
        }

        for (int i = 2; i < inputs.length; i++) {
            if (max > inputs[i] && inputs[i] >= min){
                list.add(i);
            } else if (inputs[i] >= max) {
                min = max;
                max = inputs[i];
            }
        }
        return list;
    }
}
