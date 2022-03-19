package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    public static void bfs(int [][]adjMatrix){
        boolean []visited = new boolean[adjMatrix.length];
        Queue<Integer> queue = new LinkedList<>();
        // mark Source Vertex as Visited and add into the Queue
        visited[0] = true;
        queue.add(0);
        // keep Travelling till the Queue is not Empty
        while(!queue.isEmpty()){
            int currentVertex = queue.poll();
            // print the Current Vertex
            System.out.print(currentVertex + " ");
            for(int i=0; i<adjMatrix.length; i++){
                if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
                    // i is unvisited Neighbour of Current Vertex
                    queue.add(i);
                    visited[i] = true;
                }
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

        bfs(adjMatrix);
    }
}
