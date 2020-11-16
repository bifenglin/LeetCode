package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @program: LeetCode
 * @description:
 * @author: bifenglin
 * @create: 2020-09-13 14:52
 */
public class quanpailie {

    public static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        LinkedList<Integer> temp = new LinkedList<>();
        int[] visited = new int[nums.length];
        backtrack(nums, 3, temp, visited);
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }

    public static void backtrack(int[] nums, int length, LinkedList<Integer> temp, int[] visited){
        if (temp.size() == length){
            res.add(new LinkedList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1){
                continue;
            }
            visited[i] = 1;
            temp.add(nums[i]);
            backtrack(nums, length, temp, visited);
            visited[i] = 0;
            temp.removeLast();
        }
    }

}
