import java.util.*;

public class integerStacks{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<Integer>();
        int instructions = sc.nextInt();

        while(instructions > 0){
            String line = sc.next();
            if(line.equals("PUSH")){
                    s.push(sc.nextInt());
                    instructions--;
                }
            else if(line.equals("POP") && (! s.isEmpty())){
                    s.pop();
                    instructions--;
            }
            else{
                instructions--;
            }
        }
        sc.close();
        if(s.isEmpty()){
            System.out.print("empty");
        }
        else{
        System.out.println(s.peek());
        }
    }
}
