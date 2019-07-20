import java.util.Arrays;

import static java.util.Collections.replaceAll;

public class TranspositionPoilindrom {

    public static boolean Transposition(char [] array) {
        int j = array.length - 1;
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[j]) {
                return false;
            }
            j--;
        }
        return true;
    }

        public static boolean TranspositionPoilindrom(String s) {

            String s1 = s.replaceAll("\\s+", "");
            char[] s2 = s1.toCharArray();
            int count = 0;
            int j = s2.length - 1;
            Arrays.sort(s2);
            for (int i = 0; i < s2.length - 1;i++){
                if (s2[i] == s2[i + 1])
                    count++;
            }
            System.out.println(count);
            if (count == s2.length/2)
                return true;
            else
                return false;
        }
        public static  boolean BitArray(String s){
            int BitArray = 0;
            int count = 0;
            for (int i = 0; i < s.length();i++){
                int val = s.charAt(i) - ('a');
                if ((BitArray & (1 << val)) > 0){
                    count++;
                }
                BitArray |= (1 << val);
            }
            if (count == s.length()/2)
                return true;
            else
                return false;

        }

    public static void main(String args[]){
        String s = "TactCoa";

        System.out.println(TranspositionPoilindrom(s));
        System.out.println(BitArray(s));
    }
}
