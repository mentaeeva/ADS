package WEEK1;

import java.util.Scanner;
public class ADS2 {
    // Complexity: sublinear O(n^(1/2)
    private static boolean PrimeDetermine(int n,int d){
        if (n<2)return false;
        if ((d*d)>n) return true;
        if (n%d ==0) return false;
        return PrimeDetermine(n,d+1);
    }
    // Complexity: sublinear O(n^(1/2)
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println((PrimeDetermine(n,2) ? "Prime" : "Composite"));

    }
}
