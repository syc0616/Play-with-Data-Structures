package LinkList;

//Leetcode 203 Remove Linked List Elements
/*
    删除操作：
        除头结点外，删除需要找到待删除节点的前一个节点；
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val){

        // 删除的节点就是这个头结点；while循环是把所有和这个val相等的节点都删除
        while(head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null){
            return null;
        }

        ListNode prev = head;
        while(prev.next != null){ // while循环是把所有和这个val相等的节点都删除
            if (prev.next.val == val) {  // 找到中间要删除的节点的前一个节点
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next; // 一直循环，找到待删除节点的前一个节点
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head ,6);
        System.out.println(res);
    }
}
