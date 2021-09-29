package Simple;

/**
 * @Author: Urey
 * @Date: 2021/4/27
 */
public class Title938 {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){this.val = val;}
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int result = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root,low,high);
        return result;
    }

    private void dfs(TreeNode root,int low,int high) {
        if (root.left != null){
            dfs(root.left,low,high);
        }
        if (root.val >= low && root.val <= high){
            result += root.val;
        }
        if (root.right != null){
            dfs(root.right,low,high);
        }
    }
}
