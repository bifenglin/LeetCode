package divide;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: LeetCode
 * @description: 不同的二叉搜索树 II
 * @author: maple
 * @create: 2020-04-05 15:38
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class generateTrees {
    public static void main(String[] args) {
        List<TreeNode> list = generateTrees(3);
        for (TreeNode t :
                list) {
            printTree(t);
            System.out.println();
        }
    }

    static void printTree(TreeNode n){
        LinkedList<TreeNode> list = new LinkedList();
        list.add(n);
        while (list.size() > 0){
            TreeNode node = list.poll();
            if (node == null){
                System.out.print("null,");
            }
            list.add(node.left);
            list.add(node.right);
        }
    }


    static List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new ArrayList<>();
        }
        return dfs(1, n);
    }

    static List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end){
            res.add(null);
            return res;
        }
        if (start == end){
            TreeNode treeNode = new TreeNode(start);
            res.add(treeNode);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = dfs(start, i - 1);
            List<TreeNode> rightTree = dfs(i + 1, end);
            for (int j = 0; j < leftTree.size(); j++) {
                for (int k = 0; k < rightTree.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree.get(j);
                    root.right = rightTree.get(k);
                    res.add(root);
                }
            }
        }
        return res;

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}