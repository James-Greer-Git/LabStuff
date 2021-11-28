public class recursion3{
    public static void main(String args[]){
        System.out.print(1 - function(23));
    }
    public static double function(int n){
        if(n == 1){
            return 1;
        }
        else{
            double temp = (365 - (n - 1));
            return temp*function(n - 1)/365;
        }
    }
}
