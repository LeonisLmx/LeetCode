package Simple;

/**
 * @Author: Urey
 * @Date: 2021/5/11
 */
public class Title965 {

    /**
     * Definition for a binary tree node.
     */
     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    public static boolean isUnivalTree(TreeNode root) {
         int val = root.val;
         return revert(root,val);
    }

    private static boolean revert(TreeNode root, int val) {
        if (root.val != val){
            return false;
        }
         if (root.left != null){
             if (!revert(root.left,val))
                return false;
         }
         if (root.right != null){
             if (!revert(root.right,val))
                 return false;
         }
         return true;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(9);
        node.left = new TreeNode(9);
        node.right = new TreeNode(6);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(9);
        System.out.println(isUnivalTree(node));
    }
}
