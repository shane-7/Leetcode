package 宫水三叶.树的搜索;



import java.util.ArrayList;
import java.util.List;

/** 653.两数之和IV
 * @author shkstart
 * @create 2022-04-18 4:53
 */
public class Easy1_653 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        if(res.size() == 1){
            return false;
        }
        for(int i : res){
            if(res.contains(k -i)){
                if((k - i) == i)
                    continue;
                return true;
            }
        }
        return false;

    }
    public void inorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
