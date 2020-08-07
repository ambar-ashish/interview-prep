package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//LC-993
public class CousinsinBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || root.val == x || root.val == y){
            return false;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            HashMap<Integer, Integer> map = new HashMap();
            for(int i=0; i<count; i++){
                TreeNode temp = q.remove();
                if(temp.left != null){
                    map.put(temp.left.val, temp.val);
                    q.add(temp.left);
                }
                if(temp.right != null){
                    map.put(temp.right.val, temp.val);
                    q.add(temp.right);
                }
            }
            if(map.containsKey(x) && map.containsKey(y)){
                int xParent = map.get(x);
                int yParent = map.get(y);
                if(xParent != yParent){
                    return true;
                }
            }
        }
        return false;
    }
}
