package WEEK1;
import java.util.Scanner;
public class ADS7 {
    //O(n)
    private static boolean DigitCheck (String input, int index){
        if (index == input.length()) return true;
        if (!Character.isDigit(input.charAt(index))) return false;
        return DigitCheck(input, index+1);
    }
    //O(n)
    public static void main (String[] args){
        Scanner scan= new Scanner(System.in);
        String input =scan.next();
        if (DigitCheck(input,0)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

}
