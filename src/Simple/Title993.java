package Simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Urey
 * @Date: 2021/5/17
 */
public class Title993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        map.put(x,0);
        map.put(y,0);
        map.put(-x,0);
        map.put(-y,0);
        revert(root,0,x,y,map,root.val);
        return map.get(x).compareTo(map.get(y)) == 0 && map.get(-x).compareTo(map.get(-y)) != 0;
    }

    private void revert(TreeNode root,int index,int x,int y,Map<Integer,Integer> map,int parent) {
        if (root.val == x){
            map.put(x,index);
            map.put(-x,parent);
        }
        if (root.val == y){
            map.put(y,index);
            map.put(-y,parent);
        }
        if (map.get(x) > 0 && map.get(y) > 0){
            return;
        }
        index++;
        if (root.left != null){
            revert(root.left,index,x,y,map,root.val);
        }
        if (root.right != null){
            revert(root.right,index,x,y,map,root.val);
        }
    }

    public static void main(String[] args) {
        Title993 title993 = new Title993();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(title993.isCousins(root,4,3));
    }
}
