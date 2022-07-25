package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class BT1_105_1 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i <inorder.length; i++){
            map.put(inorder[i], i);
        }
        return builder(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode builder(int[] preorder, int[] inorder, int preLow, int preHi, int inLow, int inHi){
        if(inLow > inHi || preLow > preHi){
            return null;
        }

        int rootVal = preorder[preLow];
        //中序遍历根节点索引
        int inIdx = map.get(rootVal);
        int leftNum = inIdx - inLow;

        TreeNode root = new TreeNode(rootVal);
        root.left = builder(preorder, inorder, preLow + 1, preLow + leftNum, inLow, inIdx - 1);
        root.right = builder(preorder, inorder, preLow + leftNum + 1, preHi, inIdx + 1, inHi);
        return root;
    }

}
