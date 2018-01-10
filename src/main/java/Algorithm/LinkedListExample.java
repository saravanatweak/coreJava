package Algorithm;

import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}



public class LinkedListExample {
    public static Node insert(Node head,int data) {

        if(head == null)
            return new Node(data);

        Node current = head;
        Node newHead= new Node(data);

        while(current.next !=null) {
            current = current.next;
        }
        current.next = newHead;
        return head;
    }public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}