package 宫水三叶.DFS;
import 宫水三叶.Node;

import java.util.Deque;
import java.util.LinkedList;


/**
 * @author shkstart
 * @create 2022-04-19 0:46
 */
public class Easy1_559 {

    //DFS
    public int maxDepth(Node root){
        if(root == null) return 0;
        int ans = 0;
        for(Node node : root.children){
            ans = Math.max(ans, maxDepth(node));
        }
        return ans+1;
    }

    //BFS
    public int maxDepth1(Node root){
        int ans = 0;
        if(root == null) return 0;
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            while(size-- > 0){
                Node node = deque.pollFirst();
                for(Node temp : node.children){
                    deque.addLast(temp);
                }
            }
            ans++;
        }
        return ans;
    }

}
