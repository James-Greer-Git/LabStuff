import java.util.Scanner;
public class recursion1{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print(function(scanner.nextInt()));
        scanner.close();
    }
    public static long function(long n){
        if(n == 1){
            return 2;
        }
        else if (n > 1){
            return 4*(function(n - 1)) - 3*n;
        }
        return n;
    }
}
