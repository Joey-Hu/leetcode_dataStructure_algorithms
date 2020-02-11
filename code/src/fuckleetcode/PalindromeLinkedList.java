package fuckleetcode;

import java.util.Queue;
import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/2/11 12:31
 * @desc:
 */
public class PalindromeLinkedList {
    public class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int x){
            val = x;
        }
    }

    public boolean isPalidrome(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // odd nodes: let right half smaller
        // 如: 1 -> 2 -> 3 -> 4 -> 3 -> 2 -> 1 -> NULL 是回文数
        // 经过while后，fast指向1，slow指向4
        // 再经过下面一步，slow直线3，右边更小
        if(fast != null){
            slow = slow.next;
        }

        slow = reverse(slow);
        fast = head;

        while(slow != null && fast != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
