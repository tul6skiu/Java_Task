//мерж двух остсортированных по возрастанию списков
public class MergeTwoSortedList {
    private ListNode head;
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void add(ListNode node)
    {
        if (head == null)
        {
            head = node;
        }
        else
        {
            ListNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
    public static void printList(ListNode cur){
        ListNode tmp = cur;
        while (tmp != null){
            System.out.println(tmp.val + " ");
            tmp = tmp.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp;
        tmp = dummy;

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val < l2.val){
            tmp.next = l1;
            tmp = tmp.next;
            l1.next = mergeTwoLists(l1.next, l2);
            return dummy.next;
        }else {
            tmp.next = l2;
            tmp = tmp.next;
            l2.next = mergeTwoLists(l2.next, l1);
            return dummy.next;
        }
    }
}
