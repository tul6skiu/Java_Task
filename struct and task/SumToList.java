import java.util.Collections;
import java.util.LinkedList;
import java.util.List;




//сумма двух списков
// В том же порядке входа, без рекурсии
public class SumToList {
    int CountNextNumber = 0;
    int countSize = 0;
    List<Integer> sum = null;
    public LinkedList<Integer> SumToList(List<Integer> a, List<Integer> b){
        int ressum = 0;
        if (countSize == 0) {
            sum = isSize(a, b);
            countSize = 1;
        }

        for (int i = a.size() - 1; i >= 0; i--) {
            ressum = (a.get(i) + b.get(i));
            if (ressum >= 10) {
                if (a.size() == 1) {
                    ressum = ((ressum) + CountNextNumber);
                    sum.set(i,ressum % 10);
                    ressum = ressum / 10;
                }
                else
                    ressum = ((ressum % 10) + CountNextNumber);
                sum.set(i,ressum);
                CountNextNumber = 1;
                ressum = 0;

            } else if (ressum < 10) {
                ressum = ressum + CountNextNumber;
                sum.set(i,ressum);
                CountNextNumber = 0;
                ressum = 0;

            }
        }
        sum.remove(a.size());
        return (LinkedList<Integer>) sum;
    }

    public LinkedList<Integer> isSize(List<Integer> a, List<Integer> b){
        int count = 0;
        LinkedList<Integer> sum = new LinkedList<Integer>();

        if (a.size() < b.size())
            count = (b.size() + 1);
        else
            count = (a.size() + 1);

            while (count > 0)
            {
                 sum.add(0);
                 count--;
            }

        return  sum;
    }

    public static void main(String [] args){
        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();
        a.add(2);
        a.add(1);
        a.add(8);


        System.out.println(a);
        b.add(1);
        b.add(4);
        b.add(3);

        System.out.println(b);
        SumToList t = new SumToList();
        System.out.print(t.SumToList(a, b));

    }
}

//рекурсивно
//обратый порядок входа [6,1,2] = 216
public class SumToList2 {
    int CountNextNumber = 0;
    int countSize = 0;
    List<Integer> sum = new LinkedList<Integer>();

    public LinkedList<Integer> SumToList(List<Integer> a, List<Integer> b) {
        int ressum = 0;
        if (countSize == 0) {
            isSize(a, b);
            countSize = 1;
        }
        for (int i = 0; i < a.size(); i++) {
            ressum = (a.get(i) + b.get(i));
            if (ressum >= 10) {
                if (a.size() == 1) {
                    ressum = ((ressum) + CountNextNumber);
                    sum.add(ressum % 10);
                    ressum = ressum / 10;
                } else
                    ressum = ((ressum % 10) + CountNextNumber);
                sum.add(ressum);
                CountNextNumber = 1;
                ressum = 0;
                a.remove(i);
                b.remove(i);
            } else if (ressum < 10) {
                ressum = ressum + CountNextNumber;
                sum.add(ressum);
                CountNextNumber = 0;
                ressum = 0;
                a.remove(i);
                b.remove(i);
            }

            SumToList(a, b);
        }
        return (LinkedList<Integer>) sum;
    }

    public void isSize(List<Integer> a, List<Integer> b) {
        if (a.size() < b.size()) {
            int count = (b.size() - a.size());
            while (count > 0) {
                a.add(0);
                count--;
            }

        } else if (a.size() > b.size()) {
            int count = (a.size() - b.size());
            while (count > 0) {
                b.add(0);
                count--;
            }

        }
    }

    public static void main(String[] args) {
        List<Integer> a = new LinkedList<>();
        List<Integer> b = new LinkedList<>();
        a.add(6);
        a.add(1);
        a.add(7);

        System.out.println(a);
        b.add(2);
        b.add(9);
        b.add(5);
        System.out.println(b);
        SumToList2 t = new SumToList2();
        System.out.print(t.SumToList2(a, b));

    }
}
