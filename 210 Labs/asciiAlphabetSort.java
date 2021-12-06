import java.util.Arrays;
import java.util.Scanner;
public class Solution{
    public static String[] myArray;
    public static int[] asciiArray;
    public static String[] stringWorkSpace;
    public static int[] asciiWorkSpace;
    public static int lowerBound;
    public static int upperbound;
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        myArray = new String[num];
        asciiArray = new int[num];
        asciiWorkSpace = new int[num];
        stringWorkSpace = new String[num];
        lowerBound = 0;
        upperbound = num - 1;

        for(int i = 0; i < myArray.length; i++){
            myArray[i] = scanner.nextLine();
        }
        scanner.close();

        sort();


        for(int i = 0 ; i < myArray.length; i++){
            System.out.println(asciiArray[i] + ": " + myArray[i]);
        }
    }
    public static void sort(){
        ascii();
        recMergeSort(asciiWorkSpace, lowerBound, upperbound);
        for(int i = 0; i < myArray.length; i++){
            int start_index = i;
            for(int j = i + 1; j < myArray.length; j++){
                if(asciiArray[i] == asciiArray[j]){
                }
                if(asciiArray[i] != asciiArray[j] || j == myArray.length - 1){
                    int stop_index = j + 1;
                    Arrays.sort(myArray, start_index, stop_index);
                }
            }
        }

        for(int i = 0; i < myArray.length; i++){
            for(int j = myArray.length - 1; j >= i; j--){
                if(asciiArray[i] == asciiArray[j]){
                    String temp = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = temp;
                    i++;
                }
            }
        }
    }
    public static void ascii(){
        for(int i = 0; i < myArray.length; i++){
            for(int j = 0; j < myArray[i].length(); j++){
                asciiArray[i] += (int) myArray[i].charAt(j);
            } 
        }
    }
    public static void recMergeSort(int[] workSpace, int lowerBound, int upperbound){
        if(lowerBound == upperbound){
            return;
        }
        else{
            int mid = (lowerBound + upperbound)/2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperbound);
            merge(workSpace, lowerBound, mid + 1, upperbound);
        }
    }
    public static void merge(int[] asciiWorkSpace, int first, int second, int upperbound){
        int j = 0;
        int lowerBound = first;
        int mid = second - 1;
        int n = upperbound - lowerBound + 1;

        while(first <= mid && second <= upperbound){
            if(asciiArray[first] < asciiArray[second]){
                asciiWorkSpace[j] =  asciiArray[first];
                stringWorkSpace[j] = myArray[first];
                j++;
                first++;
            }
            else{
                asciiWorkSpace[j] = asciiArray[second];
                stringWorkSpace[j] = myArray[second];
                j++;
                second++;
            }
        }
        while(first <= mid){
            asciiWorkSpace[j] = asciiArray[first];
            stringWorkSpace[j] = myArray[first];
            j++;
            first++;
        }
        while(second <= upperbound){
            asciiWorkSpace[j] = asciiArray[second];
            stringWorkSpace[j] = myArray[second];
            j++;
            second++;
        }
        for(j = 0; j < n; j++){
            asciiArray[lowerBound + j] = asciiWorkSpace[j];
            myArray[lowerBound + j] = stringWorkSpace[j];
        }
    }
}
