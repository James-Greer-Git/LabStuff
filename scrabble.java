import java.util.HashMap;

public class scrabble{
    public void Solution(String[] strList){

        HashMap<Integer, String> strings = new HashMap<Integer, String>();

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('a', 1); hm.put('e', 1); hm.put('i', 1); hm.put('o', 1); hm.put('u', 1); hm.put('l', 1); hm.put('n', 1); hm.put('s', 1); hm.put('t', 1); hm.put('r', 1);
        hm.put('d', 2); hm.put('g', 2);
        hm.put('b', 3); hm.put('c', 3); hm.put('m', 3); hm.put('p', 3);
        hm.put('f', 4); hm.put('h', 4); hm.put('v', 4); hm.put('w', 4); hm.put('y', 4);
        hm.put('k', 5);
        hm.put('j', 8);  hm.put('x', 8);
        hm.put('q', 10); hm.put('z', 10);

        int max = 0;
        for(int i = 0; i < strList.length; i++){
            int len = strList[i].length();
            int value = 0;
            int temp = 0;
            for(int j = 0; j < len; j++){
                temp = hm.get(strList[i].charAt(j));
                value = value + temp;
            }
            if(value > max){
                max = value;
            }
            strings.put(value, strList[i]);
        }
        
        int min = 0;
        do{
            if(strings.containsKey(min)){
                System.out.println(strings.get(min));
                min++;
            }
            else{
                min++;
            }
        }while(max >= min );
    }
    public static void main (String args[]){
        scrabble s = new scrabble();
        String [] strList = new String [] {"one", "two", "three"};
        s.Solution(strList);
    }
}
