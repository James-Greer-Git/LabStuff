import java.lang.Math;
import java.util.Scanner;
public class Outliers{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[3];

        for(int i = 0; i < array.length; i++){  //intializing the array
            array[i] = scanner.nextInt();
        }
        scanner.close();

        bubbleSort(array);
        int outlier = 0;

        //with 3 values the outliers can only be array[0] or array[2] when sorted
        if(Math.abs(array[0] - array[1]) > Math.abs(array[1] - array[2])){
            outlier = array[0];
        }
        else if(Math.abs(array[0] - array[1]) < Math.abs(array[1] - array[2])){
            outlier = array[2];
        }
        else if(outlier == 0){
            System.out.println("NA");
        }
        System.out.println(outlier);
    }

    public static int[] bubbleSort(int[] array){    //sorting the array
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(array[i] < array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
