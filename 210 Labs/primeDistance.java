import java.util.Scanner;
public class primeDistance {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        if(isPrime(N)){
            System.out.print(subsequentPrime(N));
        }
        else{
            System.out.print(preceedingPrime(N) + subsequentPrime(N));
        }
    }    
    public static int subsequentPrime(int N){
        int distance = 0;
        for(int i = N + 1; i <= N*N; i++){
            if(isPrime(i) == false){
                distance++;
            }
            else{
                distance++;
                break;
            }
        }
        return distance;
    }
    public static int preceedingPrime(int N){
        int distance = 0;
        for(int i = N - 1; i >= 2; i--){
            if(isPrime(i) == false){
                distance++;
            }
            else{
                distance++;
                break;
            }
        }
        return distance;
    }
    public static boolean isPrime(int N){
        boolean isPrime = true;
        for(int i = 2; i <= N/2; i++){
            if(N%i == 0 && N != i){
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
