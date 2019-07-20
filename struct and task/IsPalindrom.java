import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class IsPalindrom {

    private Node head;

    private static class Node {
        private int data;
        private Node next;

        Node(int data){
            this.data = data;
        }
    }

    public void add(Node node){
        if (head == null)
            head = node;
        else{
            Node tmp = head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }
    public void print(){
        Node tmp = head;
        while (tmp != null){
            System.out.print(tmp.data + " ");
        }
        System.out.println("");
    }

    public static   Node findMiddleNode(Node head){
        Node slow, fast;
        slow = head;
        fast = head;
        while (fast != null){
            fast = fast.next;
            if (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }
    public static Node revers(Node curr){
        Node prev = null;
        Node nextNode;
        while (curr != null){
            nextNode = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public static boolean checkPalindrom(Node head)
    {

        Node middle =findMiddleNode(head);

        Node second = middle.next;

        middle.next=null;

        Node reverse = revers(second);

        while(head!=null && reverse != null)
        {
            if(head.data == reverse.data)
            {
                head = head.next;
                reverse = reverse.next;
                continue;
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        IsPalindrom.Node head = new IsPalindrom.Node(1);
        IsPalindrom list = new IsPalindrom();
        list.add(head);
//        list.add(new Node(1));
//

        System.out.print(checkPalindrom(head));
    }
}