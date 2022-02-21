package Listnode;

/**203 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
 * @author shkstart
 * @create 2021-08-04 9:26
 */


//  Definition for singly-linked list.
    //创建一个链表的类
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) {
          this.val = val;
      }
      ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }

      //添加新的结点，方式一：
    public void add(int newval){
        ListNode newNode = new ListNode(newval);
        if(this.next == null){
            this.next = newNode;
        }else {
            this.next.add(newval);   //一直递归执行下去，直到找到this.next == null
        }
    }

    //通过数组添加结点
    public void addAll(int[] nums){
          for(int i = 1; i < nums.length; i++){
              ListNode newNode = new ListNode(nums[i]);
              if(this.next == null){
                  this.next = newNode;
              }else {
                  this.next.add(nums[i]);
              }
          }
    }

    //打印链表
    //方式1：
    public void print1(){
        System.out.print(this.val);
        if(this.next != null){
            System.out.print("-->");
            this.next.print1();
        }
    }
    //方式2：
    public void print2(ListNode l){
        StringBuilder sb = new StringBuilder();
        l = l.next;
        while(l != null){
            sb.append(l.val);
            l = l.next;
        }
        System.out.println(sb.toString());
    }
 }

public class ListNode1_203 {
    /**
     * 添加虚拟头节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements1(ListNode head, int val){
        //先判断特殊情况1：头结点为null
        if(head == null){
            return head;
        }
        //因为可能head.value == value，所以设置dummy结点
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                 pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;    //注意：这一步很关键！！！

    }

    public ListNode removeElements(ListNode head, int val){
        //先从头结点开始判断
        //head.val == val
        while(head != null && head.val == val){
            head = head.next;
        }
        //head.val != val时
        //判断head == null时
        if(head == null){
            return head;
        }

        //head != null 且 head.val != val 时
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == val) {
                pre.next = cur.next;
            }else { //移动到下一个结点进行判断
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.add(2);
//        l1.add(6);
//        l1.print1();
//        l1.print2(l1);

       int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode l2 = new ListNode();
        l2.addAll(nums);
//        l2.print2(l2);

        ListNode1_203 test = new ListNode1_203();
        ListNode head = test.removeElements(l2, 6);
        head.print1();

    }
}
