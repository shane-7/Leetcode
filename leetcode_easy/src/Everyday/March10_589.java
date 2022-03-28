package Everyday;

import Dynamic_Programming.TreeNode;
import com.sun.org.apache.xpath.internal.objects.XNodeSet;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/** 589.n叉树的前序遍历
 * @author shkstart
 * @create 2022-03-10 14:10
 */

//递归法
//public class March10_589 {
//    public List<Integer> preorder(Node root) {
//        List<Integer> result = new ArrayList<>();
//        preorder1(root, result);
//        return result;
//    }
//
//    public void preorder1(Node root, List<Integer> result){
//        if(root == null) return;
//        result.add(root.val);
//        for(Node node : root.children){
//            preorder1(node, result);
//        }
//    }
//}

//迭代法
public class March10_589 {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return null;

        //用队列来做
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            Node node_origin = deque.pop();
            res.add(node_origin.val);
            for(int i = node_origin.children.size() - 1; i >= 0; i--){
                if(node_origin.children.get(i) != null){
                    deque.addFirst(node_origin.children.get(i));
                }
            }
        }
        return res;
    }
}
