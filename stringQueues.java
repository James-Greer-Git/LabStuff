import java.util.*;

public class stringQueues{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Queue<String> q = new LinkedList<String>();
        int instructions = sc.nextInt();

        do{
            String line = sc.next();
            if(line.equals("INSERT")){
                q.add(sc.next());
                instructions--;
            }
            else if(line.equals("REMOVE") && !q.isEmpty()){
                q.remove();
                instructions--;
            }
            else{
                instructions--;
            }
        }while(instructions > 0);

        sc.close();

        int size = q.size();

        if(size%2 == 0){
            do{
               q.remove();
            }
            while(q.size() - 1 > size/2);
        }
        else{
            do{
                q.remove();
            }
            while(q.size() - 1 > size/2);
        }
        System.out.print(q.peek());
    }
}
