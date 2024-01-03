package Simple;

/**
 * @author urey.liu
 * @description
 * @date 2023/4/4 4:25 下午
 */
public class Title617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left,root2.left);
        root2.right = mergeTrees(root2.left, root2.right);
        return root;
    }

    public static void main(String[] args) {
        // root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
        Title617 title617 = new Title617();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);
        System.out.println(title617.mergeTrees(root1,root2));
    }
}
