package labuladong;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @version 1.0
 * @program: LeetCode
 * @description:
 * @author: bifenglin
 * @create: 2020-11-16 11:47
 */
public class ErChaShuZuiXiaoGaoDu {

    public class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

    }

    public int minHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int result = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left == null && treeNode.right == null) {
                    return result;
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            result++;
        }
        return result;
    }
}
