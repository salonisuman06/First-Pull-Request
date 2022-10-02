package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int prev;
    int curr;

    public Pair(int curr, int prev) {
        this.prev = prev;
        this.curr = curr;
    }
}

public class UndirectedGraph {
    private int V;
    private ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public UndirectedGraph(int V) {
        this.V = V;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void BFS(int src) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        visited[src] = true;
        queue.offer(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node);
            for(Integer in: adj.get(node)) {
                if(!visited[in]) {
                    queue.offer(in);
                    visited[in]= true;
                }
            }
        }

    }

    public void DFS(int src, boolean[] visited) {
        visited[src] = true;
        System.out.println(src);
        for(Integer node: adj.get(src)) {
            if(!visited[node]) {
                DFS(node, visited);
            }
        }
    }

    public boolean detectCycle(int src) {
        boolean[] visited = new boolean[V];
        Queue<Pair> queue = new LinkedList<>();
        visited[src] = true;
        queue.offer(new Pair(src, -1));

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            for(Integer node: adj.get(pair.curr)) {
                if(!visited[node]) {
                    queue.offer(new Pair(node, pair.curr));
                    visited[node]= true;
                }else if(node != pair.prev ){
                    return true;
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(4, 3);
        graph.addEdge(5, 4);
        graph.addEdge(4, 5);
        graph.addEdge(1, 5);
        graph.addEdge(5, 1);


//		graph.BFS(0);

        //start of DFS
//		boolean[] visited = new boolean[graph.V];
//		graph.DFS(0, visited);

        //start of cycle detection BFS
        graph.detectCycle(0);
    }

}
