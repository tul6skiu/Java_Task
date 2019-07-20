import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FixedCapacityStackOfStrings {

    private String [] a;
    private int N;
    public  FixedCapacityStackOfStrings(int cap){
        a = new String[cap];
    }
    public boolean isEmpety(){
        return N == 0;
    }

    public int size(){
        return N;
    }
    public void push(String item){
        a[N++] = item;
    }
    public String pop(){
        return a[--N];
    }

    public static void main (String args[]) throws IOException {

        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(10);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("src/result.txt")));

            while (scanner.hasNext()) {

               s.push(scanner.next());

            }
            System.out.print(" в стеке осталось " + s.size());


        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        }


}
