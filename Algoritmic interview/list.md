# List

+ [Sort List](#Sort-List)
+ [Reorder List](#Reorder-List)
+ [Linked List Cycle II](#Linked-List-Cycle-II)
+ [Swap Nodes in Pairs](#Swap-Nodes-in-Pairs)
+ [Remove Nth Node From End of List](#Remove-Nth-Node-From-End-of-List)
+ [Add Two Numbers](#Add-Two-Numbers)

## Sort List
https://leetcode.com/problems/sort-list/

```java
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = null, fast = head, slow = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            prev = slow.next;
            slow.next = null;
            slow = prev;
        }else {
            prev.next = null;
        }
        return merge(sortList(head), sortList(slow));
    }
    
    public ListNode merge(ListNode l1 , ListNode l2) {
        ListNode newH = new ListNode(0);
        ListNode p = newH;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return newH.next;
    }
}
```
## Reorder List
https://leetcode.com/problems/reorder-list/

```java
class Solution {
    public void reorderList(ListNode head) {
       if (head == null || head.next == null) return;

       ListNode low = head;
       ListNode fast = head;
       while (fast != null && fast.next != null) {
           low = low.next;
           fast = fast.next.next;
       }

       ListNode rev = revers(low.next);
       low.next = null;
       mergTwoList(head, rev);
    }

    public ListNode revers(ListNode current) {
        if (current == null || current.next == null) {
            return current;
        }
        ListNode prev = null;
        ListNode curr = current;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode mergTwoList(ListNode head, ListNode revers) {
        ListNode res = new ListNode(0);
        ListNode n = res;
        while (head != null && revers != null) {
            n.next = head;
            head = head.next;
            n = n.next;

            n.next = revers;
            revers = revers.next;
            n = n.next;
        }

        if (head == null) {
            n.next = revers;
        }else {
            n.next = head;
        }
        return res.next;
    }
}
```
## Linked List Cycle II
https://leetcode.com/problems/linked-list-cycle-ii/

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean isloopNodeStart = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {return null;}
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
```
## Swap Nodes in Pairs
https://leetcode.com/problemset/all/?topicSlugs=linked-list

```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode point = newHead;
        
        if(head == null || head.next == null) return head;
        
        while(head != null && head.next != null)
        {
            ListNode t = head.next.next;
            point.next = head.next;
            point = point.next;
            point.next = head;
            point = point.next;
            head = t;
        }
        point.next = head;
        return newHead.next;
    }
}
```
## Remove Nth Node From End of List
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

```java
public class Solution {
    public Node deletNodeElement(Node head, int k) {
        if (head == null || k == 0) return head;
        Node first = head, second = head;

        while (k-- > 0) {
            first = first.next;
        }

        while (first != null && first.next != null) {
            first = first.next;
            second = second.next;
        }

        first = first == null? second : second.next;
        if (first == head) {
            head = first.next;
        }else {
            second.next = first.next;
        }
        first.next = null;
        return head;
    }
}
```
## Add Two Numbers
https://leetcode.com/problems/add-two-numbers/

```java
public class Solution{
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        int tmp = 0;
        ListNode res = new ListNode(0);
        ListNode tail = res;
        while (list1 != null || list2 != null || tmp != 0) {
            int value = carry;
            if (list1 != null) {
                value += list1.val;
                list1 = list1.next;
            }
            if (list2 != null) {
                value += list2.val;
                list2 = list2.next;
            }

            int digit = value % 10;
            tmp = value / 10;
            tail.next = new ListNode(digit);
            tail = tail.next;
        }
        return res.next;
    }
}
```