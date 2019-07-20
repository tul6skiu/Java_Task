import java.util.Arrays;
//Прадва ли что каждый элемент в строке встречается один раз
public class OnlyOnce {

    //Сложность O(NlogN)
    public static void MyquickSort( char[] array,int low, int hi){
        if (array.length == 0) {return;}
        if (low >= hi) {return;}

        int middle = low + (hi - low) / 2;
        int opora = array[middle];
        int i = low,j = hi;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            MyquickSort(array, low, j);

        if (hi > i)
            MyquickSort(array, i, hi);
    }

    public static boolean OnlyOnce(String s){
        String original = s;
        char[] chars = original.toCharArray();

        for (int i = 0;i < chars.length;i++){
            for (int j = i + 1;j < chars.length;j++){
                if (chars[i] == chars[j])
                    return false;
            }
        }
        return true;
    }
    //Сложность O(N)
    public static boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }


    public static void main(String[] args)
    {
        String s = "cbac";
//        char[] s1 = s.toCharArray();
//        int size = s1.length;
//        MyquickSort(s1,0, size - 1);
//        for (int i = 0; i < size;i++){
//            System.out.println(s1[i]);
//        }
        System.out.println(isUniqueChars(s));

    }
}
