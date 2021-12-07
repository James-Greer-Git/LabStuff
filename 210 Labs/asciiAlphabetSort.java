import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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
            System.out.println(/*asciiArray[i] + ": " + */myArray[i]);
        }
    }
    public static void sort(){
        ascii();
        recMergeSort(asciiWorkSpace, lowerBound, upperbound);

        List<String> reverseList = new ArrayList<String>();

        for(int i = 0; i < myArray.length - 1; i++){
            if(asciiArray[i] == asciiArray[i + 1]){
                reverseList.add(myArray[i]);
            }
            if(asciiArray[i] != asciiArray[i + 1] || i == myArray.length - 2){
                reverseList.add(myArray[i + 1]);
                Collections.sort(reverseList, Collections.reverseOrder());
                for(int j = 0; j < myArray.length; j++){
                    myArray[j] = reverseList.get(0);
                    reverseList.remove(0);
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
        int[] localAsciiArray = asciiArray;
        int[] localAsciiWorkSpace = asciiWorkSpace;
        String[] localStringWorkSpace = stringWorkSpace;
        String[] localMyArray = myArray;

        while(first <= mid && second <= upperbound){
            if(localAsciiArray[first] < localAsciiArray[second]){
                localAsciiWorkSpace[j] =  localAsciiArray[first];
                localStringWorkSpace[j] = localMyArray[first];
                j++;
                first++;
            }
            else{
                localAsciiWorkSpace[j] = localAsciiArray[second];
                localStringWorkSpace[j] = localMyArray[second];
                j++;
                second++;
            }
        }
        while(first <= mid){
            localAsciiWorkSpace[j] = localAsciiArray[first];
            localStringWorkSpace[j] = localMyArray[first];
            j++;
            first++;
        }
        while(second <= upperbound){
            localAsciiWorkSpace[j] = localAsciiArray[second];
            localStringWorkSpace[j] = localMyArray[second];
            j++;
            second++;
        }
        for(j = 0; j < n; j++){
            localAsciiArray[lowerBound + j] = localAsciiWorkSpace[j];
            localMyArray[lowerBound + j] = localStringWorkSpace[j];
        }
        myArray = localMyArray;
        asciiArray = localAsciiArray;
    }
}
