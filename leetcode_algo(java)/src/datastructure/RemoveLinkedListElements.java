package datastructure;

/**
 * @author: huhao
 * @time: 2020/2/4 10:02
 * @desc: 不使用头节点
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val){
        // 当头节点就是待删除节点
        while(head!=null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode = null;
        }

        // 当整个链表都是待删除节点
        if(head == null){
            return head;
        }

        ListNode prev = head;
        while(prev.next!=null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }
        }

        return head;
    }
}
