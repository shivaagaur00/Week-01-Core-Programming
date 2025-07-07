import java.util.*;
class Stack{
    List<Integer> arr;
    Stack(){
        arr=new ArrayList<>();
    }
    void push(int a){
        arr.add(a);
        return;
    }
    int peek(){
        return arr.get(arr.size()-1);
    }
    int pop(){
        int a=arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        return a;
    }
    boolean isEmpty(){
        return arr.size()==0;
    }

}
public class StackStructure{
    public static void main(String[] args) {
        Stack st=new Stack();
        st.push(1);
        System.out.println(st.pop());
    }
}
class ArrStack {
    int[] arr;
    int i;
    ArrStack(){
        arr=new int[1];
        i = 0;
    }

    void push(int val) {
        if (i==arr.length) {
            arr=incSize();
        }
        arr[i++]=val;
    }
    int[] incSize(){
        int[] newArr = new int[arr.length*2];
            for (int j=0;j<arr.length;j++) {
                newArr[j]=arr[j];
            }
            return newArr;
    }
    int pop() {
        if (i == 0) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[--i];
    }
    int peek() {
        if (i==0) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[i - 1];
    }

    int size() {
        return i;
    }
    boolean isEmpty() {
        return i==0;
    }
}
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class StackUsingLinkedList {
    Node top;
    public StackUsingLinkedList() {
        this.top = null;
    }
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        Node current = top;
        System.out.print("Stack: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}


