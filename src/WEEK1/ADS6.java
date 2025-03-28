package WEEK1;
import java.util.Scanner;

public class ADS6 {
    // O(n⋅n!)
    private static void permute(String str, String result) {
        if (str.isEmpty()) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            permute(str.substring(0, i) + str.substring(i + 1), result + str.charAt(i));
        }
    }
    //O(n⋅n!)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();

        permute(input, "");
    }
}

