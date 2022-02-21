package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/** n叉树遍历
 *  层序遍历
 * @author shkstart
 * @create 2021-10-27 10:44
 */

public class BT9_559 {
    public int maxDepth(Node root){
       if(root == null) return 0;
        Deque<Node> deque = new LinkedList<>();
        int depth = 0;
        deque.offerLast(root);
        while(!deque.isEmpty()){
            depth++;
            int len = deque.size();
            while(len > 0){
                Node node = deque.pollFirst();
                for(int i = 0; i < node.children.size(); i++){
                    if(node.children.get(i) != null){
                        deque.offerLast(node.children.get(i));
                    }
                }
                len--;
            }
        }
        return depth;
    }

}
