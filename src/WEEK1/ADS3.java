package WEEK1;
import java.util.Scanner;
public class ADS3 {
    //Complexity: linear O(n)
    private static int Fact (int n){
        if (n==0) return 1;
        return n*Fact (n-1);
    }
    //Complexity: linear O(n)
    public static void main (String[] args){
        Scanner scan=new Scanner (System.in);
        int n=scan.nextInt();
        System.out.println(Fact(n));
        scan.close();
    }
}
