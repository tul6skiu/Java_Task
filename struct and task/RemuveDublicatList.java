import java.awt.*;
import java.util.LinkedList;
import java.util.HashSet;


//удаление дубликатов в односвязном списке
public class RemuveDublicatList {

    private Node head;

    public RemuveDublicatList(Node head) {
        this.head = head;
    }


    static class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    public void add(Node node){
        Node first = head;
        while (first != null){
            if (first.next == null){
                first.next = node;
                break;
            }
            first = first.next;
        }
    }
    public void print(){
       Node tmp = head;
       while (tmp != null){
           System.out.print(tmp.data + " ");
           tmp = tmp.next;
       }
       System.out.print("");
    }

    void remove_duplcates(){
        Node ptr1 = null,ptr2 = null,duplicat = null;
        ptr1 = head;

        while (ptr1 != null && ptr1.next != null)
        {
            ptr2 = ptr1;

            while (ptr2.next != null)
            {
                if (ptr1.data == ptr2.next.data)
                {
                    ptr2.next = ptr2.next.next;
                }
                else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }
    //Удаление через hashSet за линейное время
    void revove_dublicate2(){
        HashSet<Integer> hs = new HashSet<>();
        Node curr = head;
        Node prev = null;

        while (curr != null){

            int res = curr.data;
            if (hs.contains(res)){
                prev.next = curr.next;
            }else
            {
                hs.add(res);
                prev = curr;
            }
            curr = curr.next;
        }




    }
    public static void main(String args[]){
        RemuveDublicatList.Node head = new RemuveDublicatList.Node(3);
        RemuveDublicatList removeList = new RemuveDublicatList(head);
        removeList.add(new RemuveDublicatList.Node(3));
        removeList.add(new RemuveDublicatList.Node(3));
        removeList.add(new RemuveDublicatList.Node(3));
        removeList.add(new RemuveDublicatList.Node(3));
        removeList.add(new RemuveDublicatList.Node(5));
        removeList.add(new RemuveDublicatList.Node(5));
        removeList.add(new RemuveDublicatList.Node(5));
        removeList.add(new RemuveDublicatList.Node(5));
        removeList.add(new RemuveDublicatList.Node(5));
        removeList.print();
        System.out.println("");
//        removeList.remove_duplcates();
        removeList.revove_dublicate2();
        removeList.print();
        removeList.revove_dublicate2();



    }
}
