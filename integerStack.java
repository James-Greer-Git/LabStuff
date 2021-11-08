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
            else if(line.equals("POP")){
                s.pop();
                instructions--;
            }
        }
        sc.close();
        System.out.println(s.peek());
    }
}
