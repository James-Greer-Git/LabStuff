import java.util.Scanner;
public class recursion2{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print(function(scanner.nextInt(), scanner.nextDouble(), scanner.nextDouble()));
        scanner.close();
    }
    public static double function(int y, double i, double x){     //x : account balance, i : interest rate, y : number of years
        if(x == 0 || x < 0){
            return 0.0;
        }
        else if(y > 0){
            return function(y - 1, i, x * (1 + i/100));
        }
        else{
            return x;
        }
    }
}
