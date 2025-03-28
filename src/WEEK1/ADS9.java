package WEEK1;
import java.util.Scanner;
public class ADS9 {
    //O(logb)
    private static int GCD(int a,int b){
        if (b==0) return a;
        return GCD(b,a%b);
    }
    //O(logb)
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int a =scan.nextInt();
        int b= scan.nextInt();
        scan.close();
        System.out.println(GCD(a,b));

    }
}
