import java.util.*;

public class DFSGraph {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static void dfs(int node) {

        visited[node] = true;
        System.out.print(node + " ");

        for(int neighbor : graph[node]) {

            if(!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        graph = new ArrayList[vertices];

        for(int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        int start = sc.nextInt();

        visited = new boolean[vertices];

        System.out.println("DFS Traversal:");
        dfs(start);
    }
}