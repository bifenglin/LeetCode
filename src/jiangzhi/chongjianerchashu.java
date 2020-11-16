package jiangzhi;

import java.util.HashMap;

/**
 * @version 1.0
 * @program: LeetCode
 * @description: 重建二叉树
 * @author: bifenglin
 * @create: 2020-09-15 13:58
 */
public class chongjianerchashu {


    public static HashMap<Integer, Integer> map = new HashMap<>();


    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        TreeNode root = reConstruct(0, in.length - 1, 0, pre);
        System.out.println(root.left.value);
    }

    public static TreeNode reConstruct(int preL, int preR, int inL, int[] pre) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.value = pre[preL];
        int index = map.get(pre[preL]);
        int leftTreeSize = index - inL;
        //左子树
        root.left = reConstruct(preL + 1, preL + leftTreeSize, inL, pre);
        // 右子树
        root.right = reConstruct(preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1, pre);
        return root;
    }

}
