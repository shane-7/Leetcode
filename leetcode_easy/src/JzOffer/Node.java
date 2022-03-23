package JzOffer;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-10-27 11:16
 */
class Node {
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
