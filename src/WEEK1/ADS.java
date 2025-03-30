package WEEK1;

import java.util.Scanner;

public class ADS {
    //O(n) (Linear)
    private static int MinValue(int[] arr, int n,int index,int min){
        if (index == n) return min;
        if (arr[index] <min)
            min= arr[index];
        return MinValue (arr, n, index+1,min );

    }
    //O(n) (Linear)
    public static void Task1(String[] args){
        Scanner scan= new Scanner(System.in);
        int n=scan.nextInt();
        int[] arr= new int[n];
        for(int i=0; i<n;i++){
            arr[i]=scan.nextInt();
        }
        System.out.println(MinValue(arr,n,0,999));

    }
    //O(n) (Linear)
    private static int SumFinder(int[] arr, int n, int index,int sum){
        if (index==n) return sum/n;
        return (SumFinder(arr,n,index+1,sum+arr[index]));
    }
    // Complexity: linear O(n)
    public static void Task2(String[] args){
        Scanner scann= new Scanner(System.in);
        int n= scann.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scann.nextInt();
        }
        System.out.println((SumFinder(arr,n,0,0)));
    }
    // Complexity: sublinear O(n^(1/2)
    private static boolean PrimeDetermine(int n,int d){
        if (n<2)return false;
        if ((d*d)>n) return true;
        if (n%d ==0) return false;
        return PrimeDetermine(n,d+1);
    }
    // Complexity: sublinear O(n^(1/2)
    public static void Task3(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println((PrimeDetermine(n,2) ? "Prime" : "Composite"));

    }
    //Complexity: linear O(n)
    private static int Fact (int n){
        if (n==0) return 1;
        return n*Fact (n-1);
    }
    //Complexity: linear O(n)
    public static void Task4 (String[] args){
        Scanner scan=new Scanner (System.in);
        int n=scan.nextInt();
        System.out.println(Fact(n));
        scan.close();
    }
    // Complexity: exponential O(2^n)
    private static int Fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return Fib(n - 1) + Fib(n - 2);
    }

    // Complexity: exponential O(2^n)
    public static void Task5(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(Fib(n));
        scan.close();
    }
    //O(n)
    private static int Pow(int a, int n){
        if (n==0) return 1;
        if (a==0) return 0;
        return a*Pow(a, n-1);
    }
    //O(n)
    public static void Task6(String[] args){
        Scanner scan = new Scanner (System.in);
        int a= scan.nextInt();
        int n = scan.nextInt();
        System.out.println(Pow(a,n));


    }
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
    public static void Task7(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();

        permute(input, "");
    }
    //O(n)
    private static boolean DigitCheck (String input, int index){
        if (index == input.length()) return true;
        if (!Character.isDigit(input.charAt(index))) return false;
        return DigitCheck(input, index+1);
    }
    //O(n)
    public static void Task8(String[] args){
        Scanner scan= new Scanner(System.in);
        String input =scan.next();
        if (DigitCheck(input,0)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
    //O(2^n)
    private static int Binomial(int n, int k){
        if (k==0 | k==n) return 1;
        return Binomial(n-1,k-1)+Binomial(n-1,k);
    }
    //O(2^n)
    public static void Task9 (String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        System.out.println(Binomial(n,k));

    }
    //O(logb)
    private static int GCD(int a,int b){
        if (b==0) return a;
        return GCD(b,a%b);
    }
    //O(logb)
    public static void Task10(String[] args) {
        Scanner scan= new Scanner(System.in);
        int a =scan.nextInt();
        int b= scan.nextInt();
        scan.close();
        System.out.println(GCD(a,b));

    }
    public static void main (String[] args) {
        Task1(args);
    }

}

