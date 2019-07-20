public class RepitCount {

    public static String compressBad(String str) {

        int size = countCompression(str);
        if (size > str.length())
            return str;


        StringBuilder mystr = new StringBuilder();
        char last = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                mystr.append(last);
                mystr.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        mystr.append(last);
        mystr.append(count);
        return mystr.toString();
    }


    public static int countCompression(String s){
        char last = s.charAt(0);
        int count = 0;
        int size = 1;
        for (int i = 0;i < s.length();i++){
            if (s.charAt(i) == last){
                count++;
                size += 1 + String.valueOf(count).length();
                count = 0;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }

    public static void main(String argc[]){
        String s = "aabbccddd";
       System.out.print(compressBad(s));
    }
}
