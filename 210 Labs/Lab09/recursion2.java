public class recursion2{
    public static void main(String args[]){
        System.out.print(function(7, 1.3, 100));
    }
    public static double function(double x, double i, int y){     //x : account balance, i : interest rate, y : number of years
        if(x == 0 || x < 0){
            return 0.0;
        }
        else if(y > 0){
            return function(x * (1 + i/100), i, y - 1);
        }
        else{
            return x;
        }
    }
}
