import java.util.*;

public class stringQueues{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Queue<String> q = new LinkedList<String>();
        int instructions = sc.nextInt();

        while(instructions > 0){
            String line = sc.next();
            if(line.equals("INSERT")){
                q.add(sc.next());
                instructions--;
            }
            else if(line.equals("REMOVE") && !q.isEmpty()){
                q.remove();
                instructions--;
            }
        }
        sc.close();
        System.out.print(q);
    }
}
