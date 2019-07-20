

public class intersectionList {
    private Node head;
    int N;

    public static class Node{
        private int data;
        private Node next;

        Node(int data){
            this.data = data;
        }

    }
    public int size() {return N;}

    public void add(Node node){
        if (head == null) {
            head = node;
            N++;
        }
        else{
            Node tmp = head;
            while (tmp.next != null){
                    tmp = tmp.next;
            }
            tmp.next = node;
            N++;
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

    //Посик разницы двух длин
    public static int findDifference(intersectionList list1, intersectionList list2){
        int s1 = list1.size();
        int s2 = list2.size();
        int diff = 0;
        if (s1 > s2)
            diff = (s1 - s2);
        else
            diff = (s2 - s1);
        return diff;
    }
    //поиск узла пересечения
    public int findInteresectionList(Node head1, Node head2, intersectionList list1, intersectionList list2){
        Node n1 = head1;
        Node n2 = head2;
        int i = 1;
        int diff = findDifference(list1, list2);
        if (diff > 0) {
            if (list1.size() < list2.size()) {
                while (n2 != null && i < diff) {
                    n2 = n2.next;
                    i++;
                }
            }
            else{
                while (n1 != null && i < diff){
                    n1 = n1.next;
                    i++;
                }
            }
        }

        while (n1 != null && n2 != null){
            if (n1 == n2){
                Node res = n1;
                return res.data;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        System.out.print("пересечений нет");
        return 0;
    }

    public static void main(String args []){
        intersectionList.Node head1 = new intersectionList.Node(2);
        intersectionList.Node head2 = new intersectionList.Node(6);
        intersectionList list1 = new intersectionList();
        intersectionList list2 = new intersectionList();

        list1.add(head1);
        list2.add(head2);
        intersectionList.Node node1 = new intersectionList.Node(55);
        intersectionList.Node node2 = new intersectionList.Node(12);
        list1.add(node1);
        list2.add(node2);
        intersectionList.Node node5 = new intersectionList.Node(41);
        intersectionList.Node node6 = new intersectionList.Node(42);
        intersectionList.Node node7 = new intersectionList.Node(43);
        intersectionList.Node node8 = new intersectionList.Node(44);
        intersectionList.Node node9 = new intersectionList.Node(45);
        intersectionList.Node node10 = new intersectionList.Node(46);
        intersectionList.Node node11 = new intersectionList.Node(20);
        list1.add(node5);
        list1.add(node6);
        list1.add(node7);
        list1.add(node8);
        list1.add(node9);
        list1.add(node10);
        list1.add(node11);

        list2.add(node11);
        intersectionList.Node node12 = new intersectionList.Node(5);
        list1.add(node12);

        int size1 = list1.size();
        int size2 = list2.size();
        System.out.println(list1.findInteresectionList(head1,head2,list1, list2));

    }
}
