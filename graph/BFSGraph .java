import java.util.*;

public class BFSGraph {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[vertices];

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

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.println("BFS Traversal:");

        while(!queue.isEmpty()) {

            int node = queue.poll();
            System.out.print(node + " ");

            for(int neighbor : graph[node]) {

                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}