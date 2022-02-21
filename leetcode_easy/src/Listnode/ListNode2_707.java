package Listnode;


/**
 * @author shkstart
 * @create 2021-08-05 10:20
 */

//注意：链表的索引跟数组一样是从0开始的

//单链表创建
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//    ListNode(int val){
//        this.val = val;
//    }
//    ListNode(int val, ListNode next){
//        this.val = val;
//        this.next = next;
//    }
//}

public class ListNode2_707 {

//    public static class ListNode {
//        int val;
//        ListNode next;
//        public ListNode(int val) {
//            this.val = val;
//        }
//    }

    //size存储链表元素的个数
    int size;
    //虚拟头结点
    ListNode head;  //在同一个包中，public范围内可以直接调用，不需要导入


    /** Initialize your data structure here. */
    public ListNode2_707() {        //public MyLinkedList() 这里的MyLinkedList()这个方法的存在不是很理解！！！
        size = 0;
        head = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        //先判断index是否非法, 是则返回-1
        if(index < 0 || index >= size){
            return -1;
        }

        ListNode cur = head;
        //因为包含一个虚拟头结点head，所以实际要查找的是index + 1结点的值
        for(int i = 0; i < index + 1; i++){
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        //方法1：
        ListNode first = new ListNode(val);
        first.next = head.next;
        head.next = first;
        //方法2：
        addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    // 如果 index小于等于0，则在头部插入节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        //判断边界特殊情况
        if(index > size){
            return;  //不插入结点
        }
        if(index < 0){
            index = 0;
        }
        size++;
        //找到要插入结点的前驱
        ListNode pre = head;
        for(int i = 0; i < index; i++){
            pre = pre.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;   //这个传递顺序尤为关键，要先把原来的pre.next传递出来
        pre.next = toAdd;        //再更新pre.next的指向
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        size--;
        ListNode pre = head;
        ListNode cur = pre.next;
        for(int i = 0; i < index + 1; i++){
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = cur.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode l2 = new ListNode();
        l2.addAll(nums);
        ListNode2_707 test = new ListNode2_707();
        test.get(2);

    }
}
