package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-22 12:12
 **/
public class permute {
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4};
        permute(data, 3);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    static void permute(int[] data, int n) {
//        backtrack(data, new LinkedList());
        backtrack2(data, n, new LinkedList());
    }

    static void backtrack(int[] data, LinkedList path) {
        if (path.size() == data.length) {
            res.add((List<Integer>) path.clone());
            return;
        }
        for (int i = 0; i < data.length; i++) {
            if (path.contains(data[i]))
                continue;
            path.add(data[i]);
            backtrack(data, path);
            path.removeLast();
        }
    }

    static void backtrack2(int[] data, int n, LinkedList path) {
        if (path.size() == n) {
            res.add((List<Integer>) path.clone());
        }
        for (int i = 0; i < data.length; i++) {
            if (path.contains(data[i]))
                continue;
            path.add(data[i]);
            backtrack2(data, n, path);
            path.removeLast();
        }
    }
}
