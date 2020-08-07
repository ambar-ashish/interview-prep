package trees;

//LC-226
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}
