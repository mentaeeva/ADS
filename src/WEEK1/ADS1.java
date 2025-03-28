package WEEK1;

import java.util.Scanner;
public class ADS1{
    // Complexity: linear O(n)
    private static int SumFinder(int[] arr, int n, int index,int sum){
        if (index==n) return sum/n;
        return (SumFinder(arr,n,index+1,sum+arr[index]));
    }
    // Complexity: linear O(n)
    public static void main(String[] args){
        Scanner scann= new Scanner(System.in);
        int n= scann.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scann.nextInt();
        }
        System.out.println((SumFinder(arr,n,0,0)));
    }
    
}
