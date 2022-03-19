package Graphs;

import java.util.Arrays;
import java.util.Scanner;

public class DFS {
    public static void dfs(int [][]adjMatrix){
        boolean []visited = new boolean[adjMatrix.length];
        for(int i=0; i<adjMatrix.length; i++) {
            if(!visited[i]) {
                dfs(adjMatrix, i, visited);
                System.out.println();
            }
        }
    }
    private static void dfs(int [][]adjMatrix, int currentVertex, boolean []visited){
        visited[currentVertex] = true;
        System.out.println(currentVertex + " ");
        for(int i=0; i<adjMatrix.length; i++){
            if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
                // i is the unvisited neighbour of Current Vertex
                dfs(adjMatrix, i, visited);
            }
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter Number of Edges: ");
        int e = sc.nextInt();
        int [][]adjMatrix = new int[n][n];
        System.out.print("Graphs is 1. Directed or 2. Undirected : ");
        int choice = sc.nextInt();
        if(choice == 1){
            for(int i=0; i<e; i++){
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                adjMatrix[v1][v2] = 1;
            }
        } else{
            for(int i=0; i<e; i++){
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                adjMatrix[v1][v2] = 1;
                adjMatrix[v2][v1] = 1;
            }
        }

        System.out.println("Displaying Graph: ");
        for(int []row: adjMatrix){
            System.out.println(Arrays.toString(row));
        }

        dfs(adjMatrix);
    }
}
