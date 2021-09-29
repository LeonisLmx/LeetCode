package Simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: Urey
 * @Date: 2021/7/27
 */
public class Title671 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int findSecondMinimumValue(TreeNode root){
        Set<Integer> set = new HashSet<>();
        dfs(root,set);
        if (set.size() == 1){
            return -1;
        }
        List<Integer> list = set.stream().sorted().collect(Collectors.toList());
        return list.get(1);
    }

    private void dfs(TreeNode min,Set<Integer> set) {
        if (min == null){
            return;
        }
        set.add(min.val);
        dfs(min.left,set);
        dfs(min.right,set);
    }

    int ans;
    int rootValue;
    public int findSecondMinimumValue2(TreeNode root){
        // 这个是最小的值
        rootValue = root.val;
        ans = -1;
        dfs2(root);
        return ans;
    }

    private void dfs2(TreeNode node) {
        if (node == null){
            return;
        }
        if (ans != -1 && node.val >= ans){
            return;
        }
        if (node.val > rootValue) {
            ans = node.val;
        }
        dfs2(node.left);
        dfs2(node.right);
    }
}
