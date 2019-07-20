import java.util.LinkedList;
import java.util.List;



//реверс односвязного списка
public class ReversLinckedList {

    private Node head;

    static  class Node {
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }
        public int data(){
            return data;
        }
        public Node next(){
            return next;
        }
    }
    public ReversLinckedList(Node head){
        this.head = head;
    }

    public void add(Node node){
        Node current = head;
        while (current != null){
            if (current.next == null){
                current.next = node;
                break;
            }
            current = current.next;
        }
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data() + " ");
            node = node.next();
        }
        System.out.println("");
    }

    public void reverse(){

        Node point = head;
        Node prev = null;
        Node res = null;

        while (point != null){
            res = point;
            point = point.next;

            res.next = prev;
            prev = res;
            head = res;
        }
    }



    public static void main(String [] args){
        ReversLinckedList.Node head = new ReversLinckedList.Node(1);
        ReversLinckedList linklist = new ReversLinckedList(head);

        linklist.add(new ReversLinckedList.Node(2));
        linklist.add(new ReversLinckedList.Node(3));

        linklist.print();
        linklist.reverse();
        linklist.print();

    }
}
