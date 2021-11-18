package Simple;

/**
 * @author urey.liu
 * @description
 * @date 2021/11/18 10:19 上午
 */
public class Title563 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int res = 0;

    public int findTilt(TreeNode root){
        revert(root);
        return res;
    }

    private int revert(TreeNode root) {
        if (root == null){
            return 0;
        }
       int leftSum = revert(root.left);
       int rightSum = revert(root.right);
       res += Math.abs(leftSum - rightSum);
       return leftSum + rightSum + root.val;
    }

    public static void main(String[] args) {
        Title563 title563 = new Title563();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        System.out.println(title563.findTilt(node));
    }
}
