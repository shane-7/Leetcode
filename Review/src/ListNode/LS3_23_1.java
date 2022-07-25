package ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LS3_23_1 {
     static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            lists.length, (a, b)->(a.val - b.val));
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            if (head != null)
                pq.add(head);
        }

        while (!pq.isEmpty()) {
            // 获取最小节点，接到结果链表中
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[][] listArray = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode dummy1 = new ListNode(-1);
        ListNode p1 = dummy1;
        for(int i = 0; i < 3; i++){
            p1.next = new ListNode(listArray[0][i]);
            p1 = p1.next;
        }
        ListNode dummy2 = new ListNode(-1);
        ListNode p2 = dummy2;
        for(int i = 0; i < 3; i++){
            p2.next = new ListNode(listArray[1][i]);
            p2 = p2.next;
        }
        ListNode dummy3 = new ListNode(-1);
        ListNode p3 = dummy3;
        for(int i = 0; i < 2; i++){
            p3.next = new ListNode(listArray[2][i]);
            p3 = p3.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        ListNode[] lists = new ListNode[]{dummy1.next, dummy2.next, dummy3.next};
        ListNode ans = LS3_23_1.mergeKLists(lists);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
