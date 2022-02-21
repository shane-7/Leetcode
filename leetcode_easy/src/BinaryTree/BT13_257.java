package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/** 257.二叉树的所有路径
 * @author shkstart
 * @create 2021-10-28 16:36
 */
public class BT13_257 {
    //递归法
    public List<String> binaryTreePaths(TreeNode root){
        List<String> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }


    private void traversal(TreeNode root, List<Integer> paths, List<String> res){
        paths.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < paths.size() - 1; i++){
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
        }
        if(root.left != null){
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1); //这里用到了回溯，在本次递归完成后用res保存结果，
                                                  // 再回溯到本次递归前的状态，非常棒。
        }
        if(root.right != null){
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1); //这里再次回溯
        }
    }

}
