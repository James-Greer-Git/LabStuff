import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Queue<String> q = new LinkedList<String>();
        //int instructions = sc.nextInt();

        while(sc.hasNext()){
            String line = sc.next();
            
            if(q.isEmpty()){
                if(line.equals("INSERT")){
                    q.add(sc.next());
                }
                else{
                    
                }
            }
            else{
                if(line.equals("INSERT")){
                    q.add(sc.next());
                }
                else if(line.equals("REMOVE")){
                        q.remove();
                    }
                }
            }
        sc.close();

        int size = q.size();
        
        if(q.isEmpty()){
            System.out.print("empty");
            System.exit(0);
        }

        else if(size%2 == 0){
            while(q.size() - 1 > size/2){
                q.remove();
            }
        }
        else{
            while(q.size() - 1 > size/2){
                q.remove();
            }
        }
        System.out.print(q.peek());
    }
}
