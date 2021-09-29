package Simple;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: Urey
 * @Date: 2021/5/10
 */
public class Title872 {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();

    public boolean leafSimilar(TreeNode root1,TreeNode root2){
        dfs(root1);
        return dfs2(root2);
    }

    private void dfs(TreeNode root) {
        if (root.left != null){
            dfs(root.left);
        }
        if (root.right != null){
            dfs(root.right);
        }
        if (root.left == null && root.right == null){
            queue.offer(root.val);
        }
    }

    private boolean dfs2(TreeNode root){
        if (root.left != null){
            return dfs2(root.left);
        }
        if (root.right != null){
            return dfs2(root.right);
        }
        if (queue.size() == 0){
            return false;
        }
        if (queue.poll() != root.val){
            return false;
        }
        return true;
    }
}
