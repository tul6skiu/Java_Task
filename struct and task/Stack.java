public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpaty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        //Добавление нового элемента на верхушку стека
        Node oldfirst = first; //Cохраняем ссылку на первый элемент
        first = new Node();     //создаем новый узел
        first.item = item;      //заполняем переменые экземпляра узла
        first.next = oldfirst;  //Указатель на next связываем ссылкой на ранее первый элемент
        N++;    //увеличиваем размер стека
    }

    public Item pop() {
        // Удаление с верхушки стека
        Item item = first.item; //Присваиваем значение first значению item;
        first = first.next;     // first ссылается на следующий узел списка
        N--;        //Уменьшаем размер стека;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scanner scanner = null;
        Stack<String> s = new Stack<String>();

        try {
            scanner = new Scanner(new BufferedReader(new FileReader("src/result.txt")));
            while (scanner.hasNext()){
                String item = scanner.next();
                if (item != null){
                    s.push(item);
                }
                 if (!s.isEmpaty())
                    if (item.equals("-"))
                    System.out.println(s.pop() + " ");
            }

        } finally {
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("в стеке осталось " + s.size());
        }
    }
}
/*
1)Плюс данной реализации он применим к любому типу данных.
2)Объем требуемо памяти пропорционален размеру колекции.
3)время выполнение любой операции не зависит от разменра колекции
*/
