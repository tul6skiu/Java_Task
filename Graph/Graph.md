
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
                System.out.println(s + " ");
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
            return lineGraph;
        }
```
