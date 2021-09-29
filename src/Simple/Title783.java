package Simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/4/13
 */
public class Title783 {

    private int min = Integer.MAX_VALUE;

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() { }
        TreeNode(int val){ this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minDiffInBST(TreeNode root){
        dfs(root);
        return 1;
    }

    private void dfs(TreeNode node) {
        if (node.left != null){
            dfs(node.left);
        }
        System.out.println(node.val);
        if (node.right != null){
            dfs(node.right);
        }
    }

    private int revert(Integer parent, TreeNode root) {
        if (root.left != null) {
            min = Math.min(min,Math.abs(parent - root.left.val));
            revert(root.left.val, root.left);
        }
        if (root.right != null) {
            min = Math.min(min,Math.abs(parent - root.right.val));
            revert(root.right.val, root.right);
        }
        return min;
    }

    public static void main(String[] args) {
        Title783 title783 = new Title783();
        TreeNode treeNode = new TreeNode(27);
        treeNode.right = new TreeNode(34);
        treeNode.right.right = new TreeNode(58);
        treeNode.right.right.left = new TreeNode(50);
        treeNode.right.right.left.left = new TreeNode(44);
        title783.minDiffInBST(treeNode);
    }
}
