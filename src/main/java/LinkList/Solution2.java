package LinkList;

public class Solution2 {

    public ListNode removeElements(ListNode head, int val){
        if (head == null){
            return null;
        }

        // 头结点之后的链表删除val值
        ListNode res = removeElements(head.next, val);
        // 若头结点的值也为删除的值，则头结点也删除
        if (head.val == val){
            return res;
        }else{
            // 否则，将头结点和删除后的链表进行拼接
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution2()).removeElements(head, 6);
        System.out.println(res);
    }
}
