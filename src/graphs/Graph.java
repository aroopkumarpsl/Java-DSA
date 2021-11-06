package graphs;

import java.util.*;

public class Graph {

    private final LinkedList<List<Integer>> adj;

    public Graph(int v) {
        adj = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new LinkedList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

    public int bfs(int source, int destination) {

        boolean[] vis = new boolean[adj.size()];
        int[] parent = new int[adj.size()];
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        parent[source] = -1;
        vis[source] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == destination)
                break;

            for (int neighbor : adj.get(cur)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                    parent[neighbor] = cur;
                }
            }
        }

        int cur = destination;
        int distance = 0;

        while (parent[cur] != -1) {
            System.out.print(cur + " -> ");
            cur = parent[cur];
            distance++;
        }
        System.out.println(source);

        return distance;
    }

    public boolean dfs(int source, int destination) {
        boolean[] vis = new boolean[adj.size()];
        vis[source] = true;

        return dfsUtil(source, destination, vis);
    }

    private boolean dfsUtil(int source, int destination, boolean[] vis) {
        if (source == destination)
            return true;

        for (int neighbor : adj.get(source)) {
            if (!vis[neighbor]) {
                vis[neighbor] = true;
                boolean isConnected = dfsUtil(neighbor, destination, vis);
                if (isConnected)
                    return true;
            }
        }

        return false;
    }

    public boolean dfsStack(int source, int destination) {
        boolean[] vis = new boolean[adj.size()];
        vis[source] = true;
        Stack<Integer> stack = new Stack<>();

        stack.push(source);

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (cur == destination)
                return true;

            for (int neighbor : adj.get(cur)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices and edges");

        int v = sc.nextInt();
        int e = sc.nextInt();

        Graph graph = new Graph(v);
        System.out.println("Enter " + e + " edges");
        for (int i = 0; i < e; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();

            graph.addEdge(source, destination);
        }

        System.out.println("Enter source and destination");

        int source = sc.nextInt();
        int destination = sc.nextInt();

        int distance = graph.bfs(source, destination);
        System.out.println("min distance is " + distance);

        System.out.println("possible " + graph.dfsStack(source, destination));
        System.out.println("possible " + graph.dfs(source, destination));

        sc.close();
    }
}