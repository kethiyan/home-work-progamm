import java.util.*;

public class Graph{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        int[][] matrix = new int[v][v];
        ArrayList<Integer>[] list = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            list[i] = new ArrayList<>();
        }

        System.out.println("Enter edges:");
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            matrix[src][dest] = 1;
            matrix[dest][src] = 1;

            list[src].add(dest);
            list[dest].add(src);
        }

        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nAdjacency List:");
        for (int i = 0; i < v; i++) {
            System.out.print(i + " -> ");
            for (int node : list[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}