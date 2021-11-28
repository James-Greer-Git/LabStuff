public class recursion1{
    public static void main(String args[]){
        System.out.print(function(68));
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
