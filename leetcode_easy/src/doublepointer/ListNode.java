package doublepointer;

/**
 * @author shkstart
 * @create 2021-09-26 10:10
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

