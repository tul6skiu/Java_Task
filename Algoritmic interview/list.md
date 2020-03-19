# List

+ [Sort List](#Sort-List)
+ [Reorder List](#Reorder-List)
+ [Linked List Cycle II](#Linked-List-Cycle-II)
+ [Swap Nodes in Pairs](#Swap-Nodes-in-Pairs)
+ [Remove Nth Node From End of List](#Remove-Nth-Node-From-End-of-List)
+ [Add Two Numbers](#Add-Two-Numbers)
+ [Palindrome LinkedList](#Palindrome-LinkedList)
+ [Reverse Linked List](#Reverse-Linked-List)
+ [Remove LikedList Elements](#Remove-LinkedList-Elements)
+ [Intersection of Two Linked Lists](#Intersection-of-Two-Linked-Lists)
+ [Merge Two Sorted List](#Merge-Two-Sorted-List)

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
## Palindrome LinkedList
Given a singly linked list, determine if it is a palindrome.

```java
 public ListNode  findMiddleNode2(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode slow = head;
        ListNode fast = head;
        ListNode second = null;
        while (fast != null) {
            fast = fast.next;
            if (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    public ListNode revers2(ListNode current) {
        ListNode res;
        ListNode prev = null;
        while (current != null) {
            res = current.next;

            current.next = prev;
            prev = current;
            current = res;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null) {return true;}
        ListNode middle = findMiddleNode2(head);

        ListNode second = middle.next;

        middle.next=null;

        ListNode reverse = revers2(second);
        while (head != null && reverse != null) {
            if (head.val == reverse.val) {
                head = head.next;
                reverse = reverse.next;
                continue;
            }else
                return false;
        }
        return true;
    }
 ```
 
 ## Reverse Linked List
 Reverse a singly linked list.
 
 ```java
 public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            res = curr.next;
            curr.next = prev;
            prev = curr;
            curr = res;
        }
        head = prev;
        return head;
    }
```
## Remove LinkedList Elements
```java
   public ListNode removeElements(ListNode head, int val) {
     ListNode newHead = new ListNode(0);
     ListNode res = newHead;
        newHead.next = head;
        while (res != null && res.next != null) {
            if (res.next.val == val) {
                res.next = res.next.next;
            }else
                res = res.next;
        }
        return newHead.next;
    }
```
## Intersection of Two Linked Lists
```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         if (headA == null && headB == null) {return headA;}
        Set<ListNode> set = new HashSet<ListNode>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (!set.contains(headB)) {
                set.add(headB);
                headB = headB.next;
            }
            else
                break;
        }
        return headB;
    }
```
## Merge Two Sorted List
```java
 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode t = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                t.next = l1;
                l1 = l1.next;
            }else {
                t.next = l2;
                l2 = l2.next;
            }
            t = t.next;
        }
        if (l1 != null) {
            t.next = l1;
        }
        if (l2 != null) {
            t.next = l2;
        }
        return newHead.next;
    
    }
```
