package WEEK1;

import java.util.Scanner;

public class ADS {
    private static int MinValue(int[] arr, int n,int index,int min){
        if (index == n) return min;
        if (arr[index] <min)
            min= arr[index];
        return MinValue (arr, n, index+1,min );

    }


    public static void main(String[] args){
        Scanner scan= new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr= new int[n];
        for(int i=0; i<n;i++){
            arr[i]=scan.nextInt();
        }
        System.out.println(MinValue(arr,n,0,999));

    }

}

