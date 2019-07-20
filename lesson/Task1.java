
public class Task1 {


        public static void main(String[] args) throws IOException {
            solve();

        }

        private static void solve() throws IOException {

            Reader in  =  new Reader();
            Map<String, Map<String,Integer>> map = new HashMap<>();
            Map<String, Integer> to = new HashMap<>();
            int count = 0;


            String s, prev, from;
            int numPairs = 0;

            int T = in.nextInt();
            for (int i = 0; i < T; i++) {
                s = in.next();
                prev =s.substring(0 , 3);
                for (int j = 1; j < s.length() - 2; j++) {
                    from = s.substring(j, j + 3);

                    to = map.containsKey(prev)? map.get(prev): new HashMap<>();
                    if (!to.containsKey(from))
                        numPairs++;

                    to.put(from, (to.containsKey(from)? to.get(from) : 0) + 1);
                    map.put(prev, to);
                    prev = from;

                }
                String last = s.substring(s.length() - 3, s.length());
                if (!map.containsKey(last)){
                    map.put(last,new HashMap<>());
                }
            }
            System.out.println(map.size());
            StringBuilder sb = new StringBuilder();

            numPairs = 0;

            for (String srcStr : map.keySet()) {

                to = map.get(srcStr);

                for (String dstSrc : to.keySet()) {
                    sb.append(srcStr)
                            .append(" ")
                            .append(dstSrc)
                            .append(" ")
                            .append(to.get(dstSrc))
                            .append("\n");
                    numPairs++;
                }
            }
            System.out.println(numPairs);
            System.out.println(sb);

        }

        static class Reader{

            BufferedReader br;
            StringTokenizer st;

            public Reader(){
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            public String next() throws IOException{
                if (st == null || !st.hasMoreElements()){
                    st = new StringTokenizer(br.readLine());
                }
                return st.nextToken();
            }

            public int nextInt() throws IOException{
                return Integer.parseInt(next());
            }
        }
}
