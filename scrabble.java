import java.util.HashMap;
import java.util.Arrays;

public class scrabble{
    public void Solution(String[] strList){

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('a', 1); hm.put('e', 1); hm.put('i', 1); hm.put('o', 1); hm.put('u', 1); hm.put('l', 1); hm.put('n', 1); hm.put('s', 1); hm.put('t', 1); hm.put('r', 1);
        hm.put('d', 2); hm.put('g', 2);
        hm.put('b', 3); hm.put('c', 3); hm.put('m', 3); hm.put('p', 3);
        hm.put('f', 4); hm.put('h', 4); hm.put('v', 4); hm.put('w', 4); hm.put('y', 4);
        hm.put('k', 5);
        hm.put('j', 8);  hm.put('x', 8);
        hm.put('q', 10); hm.put('z', 10);                       //HashMap to call character scores

        String[] orderedList = new String[strList.length];      
        int[] values = new int[strList.length];

        int max = 0;
        for(int i = 0; i < strList.length; i++){
            int value = 0;
            for(int j = 0; j < strList[i].length(); j++){
                value = value + hm.get(strList[i].charAt(j));
                if(value > max){
                    max = value;
                }
            }
            orderedList[i] = strList[i];                        //Filling new array with strings
            values[i] = value;                                  //Keeping track of the score of each word in a separate array
        }

        for(int i = strList.length - 1; i >= 0; i--){            //Selection Sort to sort String array and Values array based on score
            int min_index = i;
            for(int j = i - 1; j >= 0; j--){
                if(values[j] < values[min_index]){
                    min_index = j;
                }
            }
            int tempValue = values[min_index];
            String tempWord = orderedList[min_index];
            values[min_index] = values[i];
            orderedList[min_index] = orderedList[i];
            values[i] = tempValue;
            orderedList[i] = tempWord;
        }

        int valueCount = 0;
        String[] reverseArray = new String[orderedList.length];             //Creating new array to fill with reversed list and alphabetically order
        int[] reverseValues = new int[values.length];

        for(int i = 0; i < orderedList.length; i++){
            reverseArray[i] = orderedList[orderedList.length - i - 1];
            reverseValues[i] = values[orderedList.length - i - 1];
        }
        for(int i = 0; i < strList.length; i++){
            for(int j = i + 1; j < strList.length; j++){
                int start_index = i;
                if(reverseValues[i] == reverseValues[j]){
                    //start_index = i;
                    valueCount++;
                }
                if((reverseValues[i] != reverseValues[j] && valueCount > 0) || (j == reverseArray.length - 1 && valueCount > 0)){
                    int stop_index = j;
                    Arrays.sort(reverseArray, start_index, stop_index);
                    valueCount = 0;
                }
            }
        }

        for(int i = 0; i < reverseArray.length; i++){
            System.out.println(reverseArray[i]);
        }
    }
    public static void main (String args[]){
        scrabble s = new scrabble();
        String [] strList = new String [] {"one", "eno", "one", "eno", "one"};
        s.Solution(strList);
    }
}
