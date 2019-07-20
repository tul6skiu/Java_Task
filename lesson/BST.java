import java.awt.*;
import java.awt.event.KeyAdapter;

public class BST <Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;        //ключ
        private Value val;      //значение
        private Node left, right;    //ссылки на поддеревья
        private int N;              //количество узлов в каждом поддереве

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

        public int size() {
            return size(root);
        }

        private int size(Node x) {
            if (x == null) return 0;
            else return x.N;
        }

        public Value get(Key key) {
            return get(root, key);
        }


        // Возвращает значение, связанное с ключом в поддереве с корнем х;
        // возвращает null, если ключ в поддерреве с корнем х отсутствует.
        private Value get(Node x, Key key) {
            if (x == null) return null;

            int cmp = key.compareTo(x.key);
            if (cmp < 0) return get(x.left, key);
            else if (cmp > 0) return get(x.right, key);
            else return x.val;
        }


        //вставка
        public void put(Key key, Value val) {
            root = put(root, key, val);
        }

        private Node put(Node x, Key key, Value val) {
            if (x == null) {
                return new Node(key, val, 1);
            }

            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x.left = put(x.left, key, val);
            } else if (cmp > 0) {
                x.right = put(x.right, key, val);
            } else x.val = val;

            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        //min
        public Key min(){
            return min(root).key;
        }
        private Node min(Node x){
            if (x.left == null) return x;
            return min(x.left);
        }
        private Key floor(Key key){
            Node x = floor(root, key);
            if (x == null) return null;
            return x.key;
        }
        private Node floor(Node x, Key key){
            if (x == null) return  null;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            if (cmp < 0) return floor(x.left,key);
            Node t = floor(x.right,key);
            if (t != null) return t;
            else return x;
        }

        //max()
        public Key max(){
            return max(root).key;
        }
        private Node max(Node x){
        if (x.right == null) return x;
            return max(x.right);
        }
        private Key ceiling(Key key){
            Node x = ceiling(root, key);
            if (x == null) return null;
            return x.key;
        }

        private Node ceiling(Node x, Key key){
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x;
            if (cmp > 0) return ceiling(x.right, key);
            Node t = ceiling(x.left, key);
            if (t == null) return t;
            else return x;
        }
        //выбор
         public Key select(int k){
            return select(root, k).key;
         }

         private Node select(Node x, int k){
            if (x == null )return null;
            int t = size(x.left);
            if (t > k) return select(x.left, k);
            if (t < k) return select(x.right, k - t - 1);
            return x;
         }

         public int rank(Key key){
            return rank(key, root);
         }
         private int rank(Key key, Node x){
            int cmp = key.compareTo(x.key);
            if (cmp < 0) return rank(key,x.left);
            else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
            else return size(x.left);
         }
    //удаление минимуму
        public void deletMin()
        {
            root = deletMin(root);
        }
        private Node deletMin(Node x){
            if (x.left == null) return x.left;
            x.left = deletMin(x.left);
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        public void delet(Key key){
            root = delet(root, key);
        }
        private Node delet(Node x,Key key){
            if (x == null) return null;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x.left = delet(x.left, key);
            if (cmp < 0) x.right = delet(x.right, key);
            else {
                if (x.right == null) return x.left;
                if (x.left == null) return x.right;
                Node t = x;
                x = min(t.right);
                x.right = deletMin(t.right);
                x.left = t.left;
            }
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        public void print(Node x){
        if (x == null)return;
            print(x.left);
            System.out.println(x.key);
            print(x.right);
        }
}
