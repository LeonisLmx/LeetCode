package Simple;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/26 10:31 上午
 */
public class Title700 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int res = 0;

    public TreeNode searchBST(TreeNode root, int val) {
        res = val;
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null){
            return null;
        }
        if (root.val == res){
            return root;
        }
        TreeNode node = dfs(root.left);
        if (node != null){
            return node;
        }
        TreeNode node1 = dfs(root.right);
        if (node1 != null){
            return node1;
        }
        return null;
    }
}
