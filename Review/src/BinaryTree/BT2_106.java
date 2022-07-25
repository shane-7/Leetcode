package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class BT2_106 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i <inorder.length; i++){
            map.put(inorder[i], i);
        }
        return builder(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode builder(int[] postorder, int[] inorder, int postLow, int postHi, int inLow, int inHi){
        if(inLow > inHi || postLow > postHi){
            return null;
        }

        int rootVal = postorder[postHi];
        //中序遍历根节点索引
        int inIdx = map.get(rootVal);
        int leftNum = inIdx - inLow;

        TreeNode root = new TreeNode(rootVal);
        root.left = builder(postorder, inorder, postLow, postLow + leftNum - 1, inLow, inIdx - 1);
        root.right = builder(postorder, inorder, postLow + leftNum, postHi - 1, inIdx + 1, inHi);
        return root;
    }
}
