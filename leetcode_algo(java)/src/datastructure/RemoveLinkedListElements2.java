package datastructure;

/**
 * @author: huhao
 * @time: 2020/2/4 10:18
 * @desc:  使用虚拟头节点
 */
public class RemoveLinkedListElements2 {
    public ListNode removeElements(ListNode head, int val){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next!=null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }
}
