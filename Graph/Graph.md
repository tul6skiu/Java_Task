
# Graph

+ [BFS](#BFS)

## BFS
```java
public class Solution {
    static class Graph {
        private int v;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            this.v = v;
            this.adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        List<Integer> BFS(int s) {
            boolean[] visited = new boolean[v];
            int[] lineGraph = new int[v];
            LinkedList<Integer> queue = new LinkedList<>();
            visited[s] = true;
            queue.add(s);
            while (queue.size() != 0) {
                s = queue.poll();
      
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        lineGraph[s] = n;
                        queue.add(n);

                    }
                    count++;
                }
            }
            return find(lineGraph);
        }
        
          public int[] find(int[] arr) {
            int[] res = new int[arr.length -1];
            int k = 0;
            res[k++] = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == 0) {continue;}
                res[k++] = arr[i];
                i = arr[i] - 1;
            }
            return res;
        }
```
