//pretty sure this doesn't work but I forget
import java.util.Scanner;
public class LCM {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[3];

        for(int i = 0; i <= array.length - 1; i++){
            array[i] = scanner.nextInt();
        }
        scanner.close();

        for(int i = 1; i <= 1000; i++){
            if(i%array[0] == 0 && i%array[1] == 0 && i%array[2] == 0){
                System.out.println(i);
                break;
            }
        }
    }
}
