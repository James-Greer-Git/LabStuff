import java.util.*;
import java.security.*;
import java.io.*;

public class BonusLab{
    
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        
        int strings = scanner.nextInt();
        String[] inputs = new String[strings];
        String[] input_codes = new String[strings];
        for(int i = 0; i < strings; i++){
            inputs[i] = scanner.next();
            input_codes[i] = sha256(inputs[i]);
        }
        scanner.close();
        String mostWord1 = "";
        String mostWord2 = "";
        int mostMatch = 0;
        for(int i = 0; i < input_codes.length; i++){
            for(int j = i + 1; j < input_codes.length; j++){
                int count = 0;
                for(int k = 0; k < input_codes[i].length(); k++){
                    if(input_codes[i].charAt(j) == input_codes[j].charAt(k)){
                        count++;
                    }
                }
                if(count > mostMatch){
                    mostWord1 = inputs[i];
                    mostWord2 = inputs[j];
                    mostMatch = count;
                }
            }
        }
        System.out.println("Word1: " + mostWord1);
        System.out.println("Word2: " + mostWord2);
        System.out.println("Matches: " + mostMatch);
        System.out.println("First Word appearing in Match Pair: " + mostWord1);
    }
    public static String sha256(String input){
        try{
            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            byte[] salt = "CS210+".getBytes("UTF-8");
            mDigest.update(salt);
            byte[] data = mDigest.digest(input.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i=0;i<data.length;i++){
                sb.append(Integer.toString((data[i]&0xff)+0x100,16).substring(1));
            }
            return sb.toString();
        }catch(Exception e){
            return(e.toString());
        }
    }
}
