import java.io.*;
import java.util.Arrays;
import java.io.FileInputStream;
import java.util.Scanner;

public class StaticSETofints {
    private  int [] a;
    public StaticSETofints(int [] keys){
        a = new int[keys.length];
        for (int i = 0; i < keys.length;i++) {
            a[i] = keys[i];
        }
        Arrays.sort(a);
    }
    public boolean contains(int key){
        return rank(key) != -1;
    }
    private int rank(int kay)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi){
            int mid = (lo + hi) / 2;
            if (kay < a[mid]) return hi = mid + 1;
            else if (kay > a[mid]) return lo = mid - 1;
            else
                return mid;
        }
        return -1;
    }
    public static void main(String args[]) {

        int[] array = null;
        try (BufferedReader in = new BufferedReader(new FileReader("src/test.txt")))
        {
            array = in.lines().mapToInt(Integer::parseInt).toArray();
        }
        catch (IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
        if (array != null)
        {
            StaticSETofints set = new StaticSETofints(array);
            for (int i = 0; i < array.length;i++){
                if (set.contains(array[i])) {
                    System.out.print(array[i] + " Принадлежит" + " ");
                }
                else
                    System.out.print("нет\n");
            }
        }
    }


}

