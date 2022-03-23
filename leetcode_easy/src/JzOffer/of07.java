package JzOffer;

import java.util.HashMap;

/**
 * @author shkstart
 * @create 2022-03-23 20:35
 */
public class of07 {
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

    public static void main(String[] args) {
        of07 test = new of07();
        int[] pre = {3,9,2,1,7};
        int[] inorder = {9,3,1,2,7};
        TreeNode root = test.buildTree(pre, inorder);
        System.out.println(root);
    }


}
