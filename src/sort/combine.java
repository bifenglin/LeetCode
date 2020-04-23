package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-22 12:06
 **/
public class combine {
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        combine(4, 2);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    static void combine(int n, int k){
        backtrack(n, k, 0, new LinkedList());
    }

    static void backtrack(int n, int k, int start, LinkedList path){
        if (k == path.size()){
            res.add((List<Integer>) path.clone());
            return;
        }
        for (int i = start; i < n; i++) {
            if (path.contains(n)){
                continue;
            }
            path.add(i);
            backtrack(n, k, start+1, path);
            path.removeLast();
        }
    }
}
