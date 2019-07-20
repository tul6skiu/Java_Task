public class isSubstring {

    public static  boolean isSubstring(String a, String res){
        int finish = res.lastIndexOf(a);
        System.out.print(finish);
        if (finish != -1) {return true;}
        else {return false;}

    }

    public static String SearchSubstring(String a, String b){
        char last = b.charAt(0);
        char first = a.charAt(0);
        StringBuilder s = new StringBuilder();
        for (int i = 1; i < a.length();i++){
            if (first != last)
            {
                char count = first;
                first = a.charAt(i);
                s.append(count);
            }
            else
                break;

        }
        return String.valueOf(s);
    }

    public static void main(String args[]){
        String a = "waterbottle";
        String b = "erbottlewat";
        String res = SearchSubstring(a,b);
        System.out.println(isSubstring(res, b));
    }
}
