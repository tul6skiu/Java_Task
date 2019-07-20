public class FindLoopList {
    private Node head;

    public static class Node{
        private int data;
        private Node next;

        Node(int data){
            this.data = data;
        }
    }
    public void add(Node node){
        if (head == null) {
            head = node;
        }else{
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
            tmp = tmp.next;
        }
        System.out.println("");
    }
    public int FindNodeLoop(Node current){
        Node tmp = current;
        Node prev = current;
        int flag = 0;
        while (tmp != null && tmp.next != null){
            tmp = tmp.next.next;
            prev = prev.next;
            if (prev == tmp)
            {
                 flag = 1;
            }
            if (flag == 1){
                prev = head;
                while (prev != null && prev.next != null){
                    prev = prev.next;
                    tmp = tmp.next;
                    if (tmp == prev)
                    {
                        return prev.data;
                    }
                }
            }

        }


        return 0;
    }

    public static void main(String args[]){
        FindLoopList.Node head = new FindLoopList.Node(5);
        Node loop  = new Node(77);

        FindLoopList list = new FindLoopList();

        list.add(head);
        list.add(new Node(6));
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(2));
        list.add(new Node(12));
        list.add(new Node(324));
        list.add(new Node(345));
        list.add(new Node(22342));
        list.add(new Node(2223));
        list.add(new Node(1122));
        list.add(new Node(-1));
        list.add(new Node(-2));
        list.add(loop);
        list.add(new Node(-3));
        list.add(new Node(-4));
        list.add(new Node(-5));
        list.add(new Node(-6));
        list.add(loop);
        System.out.print(list.FindNodeLoop(head));

    }
}
//FindLoopList$Node@77459877