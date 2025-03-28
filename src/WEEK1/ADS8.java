package WEEK1;
import java.util.Scanner;
public class ADS8 {
    //O(2^n)
    private static int Binomial(int n, int k){
        if (k==0 | k==n) return 1;
        return Binomial(n-1,k-1)+Binomial(n-1,k);
    }
    //O(2^n)
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        System.out.println(Binomial(n,k));

    }

}
