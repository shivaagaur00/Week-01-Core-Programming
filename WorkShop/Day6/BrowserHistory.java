package Day6;

import java.util.Scanner;

public class BrowserHistory {
    class Node {
        String url;
        Node left;
        Node right;
        Node(String url) {
            this.url = url;
        }
    }
    private Node current;
    public void visitPage(String url) {
        Node newNode = new Node(url);
        if (current != null) {
            current.right = newNode;
            newNode.left = current;
        }
        current = newNode;
        System.out.println("Visited: " + url);
    }

    public void goBack() {
        if (current != null && current.left != null) {
            current = current.left;
            System.out.println("back to: " + current.url);
        } else {
            System.out.println("No previous page.");
        }
    }

    public void goForward() {
        if (current != null && current.right != null) {
            current = current.right;
            System.out.println("forward to" + current.url);
        } else {
            System.out.println("No next page.");
        }
    }

    public void currentPage() {
        if (current != null) {
            System.out.println("Current page: " + current.url);
        } else {
            System.out.println("No pages visited yet.");
        }
    }

    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Visit Page");
            System.out.println("2. Go Back");
            System.out.println("3. Go Forward");
            System.out.println("4. Current Page");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
            	System.out.print("Enter URL: ");
            	String url = sc.nextLine();
            	bh.visitPage(url);
            	}
            else if (choice == 2) {
            	bh.goBack();
            	} 
            else if (choice == 3) {
            	bh.goForward();
            	} 
           else if (choice == 4) {
        	   bh.currentPage();
        	   } 
           else {
        	   System.out.println("Exit");
        	   sc.close();
        	   return;
        	   }

        }
    }
}
