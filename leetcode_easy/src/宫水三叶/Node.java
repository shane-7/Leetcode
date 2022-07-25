package 宫水三叶;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-10-27 11:16
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
