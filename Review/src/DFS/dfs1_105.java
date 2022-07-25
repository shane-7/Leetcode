package DFS;

import BinaryTree.TreeNode;

public class dfs1_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder){
        return buildHelper(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    private TreeNode buildHelper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart == preEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = 0;
        for(int i = inStart; i < inEnd; i++){
            if(inorder[i] == rootVal){
                rootIdx = i;
                break;
            }
        }
        //左子树的数量：
        int leftNum = rootIdx - inStart;
        //遍历左子树
        root.left = buildHelper(preorder, inorder, preStart + 1, preStart + leftNum + 1, inStart, rootIdx);
        //遍历右子树
        root.right = buildHelper(preorder, inorder, preStart + leftNum + 1, preEnd, rootIdx + 1, inEnd);
        return root;
    }
}
