package BinaryTree;


import com.sun.xml.internal.ws.encoding.RootOnlyCodec;

public class BT1_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int p_start, int p_end, int i_start, int i_end){
        //preorder为空，直接返回null
        if(p_start == p_end){
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for(int i = i_start; i < i_end; i++){
            if(root_val == inorder[i]){
                i_root_index = i;
                break;
            }
        }
        //左子树数量
        int leftNum = i_root_index - i_start;
        //递归构造左子树
        root.left = buildTreeHelper(preorder, inorder, p_start + 1, p_start + leftNum + 1, i_start, i_root_index);
        //递归构造右子树
        root.right = buildTreeHelper(preorder, inorder, p_start + leftNum + 1, p_end, i_root_index + 1, i_end);
        return root;
    }

}
