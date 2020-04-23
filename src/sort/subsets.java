package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-22 11:57
 **/
public class subsets {

    static List<List<Integer>> res = new ArrayList();

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3};
        subSets(data);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    static void subSets(int[] data) {
        backtrack(data, 0, new LinkedList<Integer>());
    }

    static void backtrack(int[] data, int start, LinkedList path) {
        res.add((List<Integer>) path.clone());
        for (int i = start; i < data.length; i++) {
            path.add(data[i]);
            backtrack(data, start + 1, path);
            path.removeLast();
        }
    }
}
