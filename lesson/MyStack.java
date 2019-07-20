public class MyStack extends StackMIn<Integer> {

    StackMIn<Integer> s2;

    public  MyStack() {
        super();
        s2 = new StackMIn<Integer>();
    }

   public void push(int value){
        if (value <= min()){
            s2.push(value);
        }
        super.push(value);
   }
   public int pop(){
        int value = super.pop();
        if (value == min()){
            s2.pop();
        }
       return value;
   }


   public int min(){
        if (s2.isEmpty2()){
            return Integer.MAX_VALUE;
        }else{
            return s2.peek();
        }

   }
}
