package GoogleInterviewQuestions.EasyLevel;

import java.util.Arrays;
import java.util.Scanner;

public class TripletWithSumZero {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        // Display Array
        displayArr(arr);

        // find triplet

    }

    private static void displayArr(int []arr){
        System.out.println(Arrays.toString(arr));
    }
}
