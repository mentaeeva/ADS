package WEEK1;
import java.util.Scanner;
public class ADS5 {
    //O(n)
    private static int Pow(int a, int n){
        if (n==0) return 1;
        if (a==0) return 0;
        return a*Pow(a, n-1);
    }
    //O(n)
    public static void main(String[] args){
        Scanner scan = new Scanner (System.in);
        int a= scan.nextInt();
        int n = scan.nextInt();
        System.out.println(Pow(a,n));


    }
}
