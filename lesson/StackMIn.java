import java.util.EmptyStackException;
// реализуйте стек так, что бы по мимо метода pop() и push() был метод min() который бы возвращал значение за O(1);
// реализация в файле MyStack.java
public class StackMIn<Integer> {
    public int value;
    public int min;

    public StackMIn(){
        this.value = value;
        this.min = min;
    }
    //узел стека
    private static class  StackNode{
        private int data;
        private StackNode next;

        public StackNode(int data){
            this.data = data;
        }
    }

    private StackNode top;

    public int pop(){
        if (top == null) throw new EmptyStackException();
        int item = top.data;
        top = top.next;
        return item;
    }

    public void push(int item){
        StackNode t = new StackNode(item);
        t.next = top;
        top = t;
    }

    public int peek(){
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty2(){
        return top == null;
    }

    public void print(){
        StackNode tmp = top;
        while (tmp != null){
            System.out.println(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.print("");
    }
}
