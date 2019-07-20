import java.util.Iterator;


public class ResizingArrayStack<Item> implements Iterable<Item> {


    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpyte() {return N == 0;}
    public int size () {return N;}

    private void resize (int max) {
        // Перенос стека размером N <= max в новый массив размером max.
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item) {
        //Проверка исчерпана ли емкасть массива,если массив полон то мы увеличиваем его в2 раза
        if (N == a.length)
            resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop (){
        Item item = a[--N];
        a[N] = null;
        //проверка если массив слишком велик то мы уменьшаем его в двое
        if (N > 0 && N == a.length/4)
            resize(a.length/2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayItearator();

    }

    private class ReverseArrayItearator implements Iterator<Item> {
        // Поддержка итерации по правилу LIFO,
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
        public void remove() {}
    }
}
