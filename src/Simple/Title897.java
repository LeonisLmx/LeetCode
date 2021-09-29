package Simple;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Urey
 * @Date: 2021/4/25
 */
public class Title897 {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> list = new LinkedList<>();

    public TreeNode increasingBST(TreeNode root) {
        if (root == null){
            return root;
        }
        dfs(root);
        TreeNode node = new TreeNode(list.get(0)),resultNode = node;
        for (int i = 1; i < list.size(); i++) {
            node.right = new TreeNode(list.get(i));
            node = node.right;
        }
        return resultNode;
    }

    private void dfs(TreeNode root) {
        if (root.left != null){
            dfs(root.left);
        }
        list.add(root.val);
        if (root.right != null){
            dfs(root.right);
        }
    }

    public static void main(String[] args) {
        Title897 title897 = new Title897();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(3);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(4);
        node.left.left.left = new TreeNode(1);
        node.right.right = new TreeNode(8);
        node.right.right.left = new TreeNode(7);
        node.right.right.right = new TreeNode(9);
        title897.increasingBST(node);
    }
}
