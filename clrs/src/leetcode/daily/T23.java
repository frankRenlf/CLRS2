package leetcode.daily;

import leetcode.algorithm.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : clrs
 * @Package : leetcode.daily
 * @createTime : 2023/4/7 21:51
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        int n = lists.length;
        while (true) {
            int pos = 0;
            while (pos < n && lists[pos] == null) {
                pos++;
            }
            if (pos == n) break;
            boolean k = true;
            for (int i = pos; i < n; i++) {
                if (lists[i] != null) {
                    if (lists[i].val <= lists[pos].val) {
                        pos = i;
                    }
                    k = false;
                }
            }
            if (k) break;
            pre.next = lists[pos];
            pre = pre.next;
            lists[pos] = lists[pos].next;
        }
        return head.next;
    }
}
