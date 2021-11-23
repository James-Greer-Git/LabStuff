import java.util.Scanner;

public class doublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data){
            this.data = data;
        }
    }

    public doublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public int length(){
        return length;
    }

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
        }
        else{
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    public void displayForward(){
        if(head == null){
            return;
        }
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void displayBackward(){
        if(tail == null){
            return;
        }
        ListNode temp = tail;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.print("null");
        System.out.println();
    }

    public int secondSmallest(){
        if(head == null){
            return - 1;
        }
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        ListNode temp = head;
        while(temp != null){
            if(temp.data < smallest){
                smallest = temp.data;
            }
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            if(temp.data > smallest && temp.data < secondSmallest){
                secondSmallest = temp.data;
            }
            temp = temp.next;
        }

        if(secondSmallest == Integer.MAX_VALUE){
            return -1;
        }

        return secondSmallest;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        doublyLinkedList dll = new doublyLinkedList();
        
        int instructions = sc.nextInt();
        while(instructions > 0){

            dll.insertLast(sc.nextInt());
            instructions--;
        }
        sc.close();

        System.out.println(dll.secondSmallest());
    }
}
