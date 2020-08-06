package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//LC-103
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if(root == null){
            return list;
        }
        boolean normal = true;//will use the flag to change the order
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            LinkedList<Integer> tempList = new LinkedList();
            for(int i=0 ; i<count ; i++){
                TreeNode temp = q.remove();
                if(temp != null){
                    //changing the order of adding order every level here
                    if(normal){
                        tempList.addLast(temp.val);
                    }else{
                        tempList.addFirst(temp.val);
                    }
                    if(temp.left != null){
                        q.add(temp.left);
                    }
                    if(temp.right != null){
                        q.add(temp.right);
                    }
                }
            }
            list.add(tempList);
            normal = !normal;
        }
        return list;
    }
}
