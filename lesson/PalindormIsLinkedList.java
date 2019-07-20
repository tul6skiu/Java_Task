import java.util.List;
import java.util.Stack;
//Является ли список плиндромом
public class PalindormIsLinkedList{

    private Node head;
    private static class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public void addLast(Node node){

        if (head == null)
            head = node;
        else{
            Node tmp = head;
            while (tmp.next != null)
            {
                tmp = tmp.next;
            }
            tmp.next = node;
        }

    }

    public static Node findEndFillStack(Node head, Stack<Integer> stack){
        Node slow = head;
        Node fast = head;
        while ((fast != null && fast.next != null)){
                stack.push(slow.data);
                slow = slow.next;
                fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;
        return slow;
    }
    public static boolean isPalindrom(Node head){
        Stack<Integer> stack = new Stack<>();
        Node current = null;

       current = findEndFillStack(head, stack);

       while (current != null){
               int top  = stack.pop();
               if (top != current.data){
                   return false;
               }
               current = current.next;
           }
        return true;
    }
}
