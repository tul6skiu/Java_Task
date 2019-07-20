//Односвязный список метод добавление в конеч за O(n) удаление по задоному значению сложность O(n); метод печати списка
public class myLinkedList2 {
    private Node head;



    private static class Node{
        private int data;
        private Node next;

        public Node(int data) {
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
    public void delet(int data){
        if (head == null) {return;}
        if (head.data == data){
            head = head.next;
        }
        Node tmp = head;
        while (tmp.next != null){
            if (tmp.next.data == data){
                tmp.next = tmp.next.next;
                return;
            }
            tmp = tmp.next;
        }
    }

    public void printList(){
        Node tmp = head;
        while (tmp != null){
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println("");
    }

    public static void main(String [] args){
        myLinkedList2.Node  head = new myLinkedList2.Node(12);
        myLinkedList2 list = new myLinkedList2();
        list.add(head);
        list.add(new myLinkedList2.Node(44));
        list.add(new myLinkedList2.Node(4));
        list.add(new myLinkedList2.Node(22));
        list.add(new myLinkedList2.Node(13));
        list.add(new myLinkedList2.Node(12));
        list.add(new myLinkedList2.Node(33));
        list.printList();
        list.delet(12);
        list.printList();


    }
}
