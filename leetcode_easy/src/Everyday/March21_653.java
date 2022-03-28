package Everyday;



import java.util.*;

/**
 * @author shkstart
 * @create 2022-03-21 10:19
 */
public class March21_653 {
    public boolean findTarget(TreeNode root, int k){
//        List<Integer> res = new ArrayList<>();
        if(root.left == null && root.right == null){
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        deque.addFirst(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.pop();
            if(set.contains(k - node.val)) return true;
            set.add(node.val);
//            res.add(node.val);
            if(node.right != null) deque.addFirst(node.right);
            if(node.left != null) deque.addFirst(node.left);
        }
        return false;


        //自己的笨方法
//        if(res.size() == 1){
//            return false;
//        }

//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < res.size(); i++){
//            int temp = res.get(i);
//            if(map.containsKey(temp)){
//                map.put(temp, map.get(temp) + 1);
//            }else{
//                map.put(temp, 1);
//            }
//        }
//        for(int i = 0; i < res.size(); i++){
//            int temp = res.get(i);
//            int a = k - res.get(i);
//            if(a == temp){
//                if(map.containsKey(a) && map.get(a) >= 2){
//                    return true;
//                }else {
//                    continue;
//                }
//            }
//            if(map.containsKey(a)){
//                if(map.get(a) > 0){
//                    return true;
//                }
//            }
//        }
//        return false;
    }


}
