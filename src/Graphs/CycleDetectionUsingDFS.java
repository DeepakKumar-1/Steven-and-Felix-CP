package Graphs;

import java.util.Arrays;
import java.util.Scanner;

public class CycleDetectionUsingDFS {
    public static boolean dfsRec(int [][]adjMatrix, int currentVertex, boolean []visited, int parent){
        visited[currentVertex] = true;
        for(int i=0; i<adjMatrix.length; i++){
            if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
                if(dfsRec(adjMatrix, i, visited, currentVertex))
                    return true;
                else if(i != parent){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(int [][]adjMatrix){
        boolean []visited = new boolean[adjMatrix.length];
        // this is for Disconnected Components of the Graph
        for(int i=0; i<adjMatrix.length; i++){
            if(!visited[i]){
                if (dfsRec(adjMatrix, i, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String []args){
        // Creating a Graph
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter Number of Edges: ");
        int e = sc.nextInt();
        int [][]adjMatrix = new int[n][n];
        for(int i=0; i<e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = sc.nextInt();
            adjMatrix[v2][v1] = sc.nextInt();
        }
        System.out.print("Displaying Graph: ");
        for(int []row: adjMatrix){
            System.out.println(Arrays.toString(row));
        }
        // Check if there is a Cycle of Not
        System.out.println(dfs(adjMatrix));
    }
}
