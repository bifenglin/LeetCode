package binary;


/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-03-22 15:27
 **/
public class leastCommonAncestor {

    public static void main(String[] args) {
        BTree bTree = new BTree();
        BTree t1 = new BTree();
        BTree t2 = new BTree();
        dfs(bTree, false, false, t1, t2, 0);
    }

    // 结果
    static Integer res = 0;

    // b遍历的子二叉树 n遍历到第几层 t1寻找的二叉树 t2寻找的二叉树 b1确定t1是否找到 b2确定t2是否找到
    static void dfs(BTree b, boolean b1, boolean b2, BTree t1, BTree t2, int n){
        // 如果左子树和右子树都为null 跳出循环
        if (b.left == null && b.right == null){
            return;
        }
        // 如果左子树和右子树都找到则停止
        if (b1 && b2){
            if (res > n){
                res = n;
            }
            return;
        }
        // 确定t2节点
        if (b.left == t2 || b.right == t2){
            b2 = true;
        }
        // 确定t1节点
        if (b.left == t1 || b.right == t1){
            b1 = true;
        }
        // 如果左子树不为空则递归
        if (b.left != null){
            dfs(b.left, b1, b2, t1, t2 ,n+1);
        }
        // 如果右子树不为空递归
        if (b.right != null){
            dfs(b.right, b1, b2, t1, t2 , n+1);
        }
    }

    static class BTree{
        BTree left;
        BTree right;
    }
}
