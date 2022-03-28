package Everyday;

import java.util.*;

/**  590.N叉树的后序遍历
 * @author shkstart
 * @create 2022-03-12 9:20
 */
public class March12_590 {
    //方法1：递归
    // public List<Integer> postorder(Node root) {
    //     List<Integer> result = new ArrayList<>();
    //     postorder(root, result);
    //     return result;
    // }

    // public void postorder(Node root, List<Integer> result){
    //     if(root == null){
    //         return;
    //     }
    //     for(Node node : root.children){
    //         postorder(node, result);
    //     }
    //     result.add(root.val);
    // }

    //方法2：迭代法：
    public List<Integer> postorder(Node root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        //用栈来做
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            Node node = deque.pop(); //先弹出中节点
            res.add(node.val);
            for(Node node_1 : node.children){ //从children的左边开始遍历
                if(node_1 != null){
                    deque.addFirst(node_1); //把左边的节点先压入栈中，  出栈顺序为 右→左
                }
            }
        }
        //res的顺序为 中→右→左


        //翻转结果, 最后 res顺序为：左→右→中
        Collections.reverse(res);
        return res;


    }
}
