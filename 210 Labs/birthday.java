import java.util.Scanner;
import java.lang.Math;

public class birthday {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        scanner.close();
        double sum_prob = 0;

        for(int i = 0; i <= 1000000; i++){
            sum_prob = sum_prob + birthday_loop(n, x);
        }
        System.out.print(sum_prob/1000000.00);
    }
    public static int birthday_loop(int n, int x){
        int[] array = new int[n];
        for(int i = 0; i <= array.length - 1; i++){             //filling array with random integers between 1 and 365
            array[i] = (int)(Math.random()*((365 - 1) + 1));
        }
        int count = 0;
        for(int i = 0; i <= array.length - 1; i++){             //nested loop to check if any values in the array are equal
            for(int j = 0; j <= array.length - 1; j++){
                if(array[i] == array[j] && i != j){
                    count = count + 1;
                }
            }
        }
        if(count >= x){                                     //if x or more students are found to have the same birthday, return 1
            return 1;
        }
        else{
            return 0;
        }
    }
}
