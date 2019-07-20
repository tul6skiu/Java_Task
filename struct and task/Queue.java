import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

public class Queue<Item> implements  Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    public class Node{
        Item item;
        Node next;
    }
    public boolean isEmpety() {
        return first == null;
    }
    public int size() {return N;}
    public void enqueue(Item item) {
        //Добавление в конец списка
        Node oldlast = last; //Cохраняем ссылку на последний элемент
        last = new Node();  //Создаем новый узел списка
        last.item = item;   //записываем значение  item в переменные экземпляра класса Node
        last.next = null;   //Указатель на следующий элемени списка ссылкаем на null
        if (isEmpety())     //Если список пуст то новый item является первы в списке
            first = last;
        else
            oldlast.next = last; // иначе новый элемент списка сылаем с ссылкой на последний элемент
        N++;    //увеличиваем размер очереди
    }
    public Item dequeue() {
        //Удаление из начала списка
        Item item = first.item;   //сохраняем значение firest.item в переменую item
        first = first.next;     //ссылаем на слудущий элемент списка
        if (isEmpety())     //Если first = null то и last тоже null
            last = null;
        N--;        //уменьшаем размер очереди
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner = null;
         Queue<String> s = new Queue<String>();


        try {
            scanner = new Scanner(new BufferedReader(new FileReader("src/result.txt")));
            while (scanner.hasNext()){
                String item = scanner.next();
                if (item != null){
                    s.enqueue(item);
                }
            }

        } finally {
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("в очереди осталось " + s.size());
            for (String a : s){
                System.out.println(a);
            }
       }
    }
}

