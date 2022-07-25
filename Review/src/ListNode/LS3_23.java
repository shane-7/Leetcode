package ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LS3_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        //虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        //优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b)->(a.val - b.val));
        for(ListNode head : lists){
            if(head != null){
                pq.add(head);
            }
        }

        while(!pq.isEmpty()){
            //获取最小节点，接到结果链表中
            ListNode temp = pq.poll();
            p.next = temp;
            if(temp.next != null){
                pq.add(temp.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> listArray = new ArrayList<>();
        int i = 3;
        while(i-- > 0){
            String[] s1 = sc.nextLine().split(" ");
            List<Integer> list1 = new ArrayList<>();
            for(String s : s1){
                list1.add(Integer.parseInt(s));
            }
            listArray.add(list1);
        }

        listArray.forEach(item->{
            System.out.println(item.toString());
        });
    }

}
