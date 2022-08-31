package com.company.Bitwise;

import java.util.Arrays;
import java.util.Scanner;

public class EvenOddXor {
    public static int []evenOddXor(int n){
        int []ans = new int[n];
        // check for Even or Odd
        // and Satisfy 3rd Condition

        if(n % 2 == 0){
           for(int i=0, j=1; i<n; i +=2, j+= 1){
               ans[i] = j;
            }

           for(int i=1, j=1; i<n; i+=2, j+=1){
               ans[i] = j;
           }
        } else{
            for(int i=1, j=1; i<n; i +=2, j+= 1){
                ans[i] = j;
            }

            for(int i=2, j=1; i<n; i+=2, j+=1){
                ans[i] = j;
            }
        }


        // Now Handle 2nd Condition
        // All Elements should be distinct
        if((((n+1)/2)& 1) == 1){
            // in case of odd partition

            for(int i=0; i+2<n; i+=2){
                ans[i] |= (1 << 30);
            }

            for(int i=2; i<n; i+= 2){
                ans[i] |= (1 << 29);
            }
        }else{
            // in case of even partition
            // make all 30th bit set
            for(int i=0; i<n; i+=2){
                ans[i] |= (1 << 30);
            }
        }
        return ans;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0){
            int n = sc.nextInt();
            int []ans = evenOddXor(n);
            System.out.println(Arrays.toString(ans));

            // Show XOR of Even and Odd Position
            int xorE = 0;
            int xorO = 0;
            for(int i=0; i<n; i++){
                if((i+1)%2 != 0) {
                    xorO ^= ans[i];
                }else{
                    xorE ^= ans[i];
                }
            }
            System.out.println(xorE + " " + xorO);
        }
    }
}
