import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Doublylinkedlist {
    Node head = null;
    Node tail = null;

    void insertBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Node inserted.");
    }

    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Node inserted.");
    }

    void insertPosition(int data,int position) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            insertBeginning(data);
            return;
        }

        Node temp = head;
        for (int i=1;i<position-1 && temp!=null;i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        if (temp == tail) {
            insertEnd(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;

        System.out.println("Node inserted.");
    }

    void insertAfter(int value,int data) {
        Node temp = head;

        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Node not found.");
            return;
        }

        if (temp == tail) {
            insertEnd(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;

        System.out.println("Node inserted.");
    }

    void insertBefore(int value,int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Node not found.");
            return;
        }

        if (temp == head) {
            insertBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.prev = temp.prev;
        newNode.next = temp;
        temp.prev.next = newNode;
        temp.prev = newNode;

        System.out.println("Node inserted.");
    }

    void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        System.out.println("Node deleted.");
    }

    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        System.out.println("Node deleted.");
    }

    void deletePosition(int position) {
        if (head == null || position <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            deleteBeginning();
            return;
        }

        Node temp = head;

        for (int i=1;i<position && temp!=null;i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position.");
            return;
        }

        if (temp == tail) {
            deleteEnd();
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        System.out.println("Node deleted.");
    }

    void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
 
        Node temp = head;

        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Value not found.");
            return;
        }

        if (temp == head) {
            deleteBeginning();
            return;
        }

        if (temp == tail) {
            deleteEnd();
            return;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        System.out.println("Node deleted.");
    }

    void search(int value) {
        Node temp = head;
        int position = 1;

        while (temp != null) {
            if (temp.data == value) {
                System.out.println("Value found at position: "+position);
                return;
            }
            temp = temp.next;
            position++;
        }

        System.out.println("Value not found.");
    }

    void update(int oldValue,int newValue) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == oldValue) {
                temp.data = newValue;
                System.out.println("Value updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Value not found.");
    }

    void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }

        System.out.println();
    }

    void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }

        System.out.println();
    }

    void countNodes() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total nodes: "+count);
    }

    void findMaximum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        int max = head.data;
        Node temp = head.next;

        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }

        System.out.println("Maximum: "+max);
    }

    void findMinimum() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        int min = head.data;
        Node temp = head.next;

        while (temp != null) {
            if (temp.data < min) {
                min = temp.data;
            }
            temp = temp.next;
        }

        System.out.println("Minimum: "+min);
    }

    void findMiddle() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle element: "+slow.data);
    }

    void reverse() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;

        System.out.println("List reversed.");
    }

    void sort() {
        if (head == null || head.next == null) {
            return;
        }

        Node current = head;

        while (current != null) {
            Node temp = current.next;

            while (temp != null) {
                if (current.data > temp.data) {
                    int value = current.data;
                    current.data = temp.data;
                    temp.data = value;
                }
                temp = temp.next;
            }

            current = current.next;
        }

        System.out.println("List sorted.");
    }

    void removeDuplicates() {
        Node current = head;

        while (current != null) {
            Node temp = current.next;

            while (temp != null) {
                Node nextNode = temp.next;

                if (temp.data == current.data) {
                    if (temp == tail) {
                        tail = temp.prev;
                        tail.next = null;
                    } else {
                        temp.prev.next = temp.next;
                        temp.next.prev = temp.prev;
                    }
                }

                temp = nextNode;
            }

            current = current.next;
        }

        System.out.println("Duplicates removed.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Doublylinkedlist list = new Doublylinkedlist();
        int choice;

        do {
            System.out.println("\n1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Insert After a Node");
            System.out.println("5. Insert Before a Node");
            System.out.println("6. Delete from Beginning");
            System.out.println("7. Delete from End");
            System.out.println("8. Delete from Position");
            System.out.println("9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display Forward");
            System.out.println("13. Display Backward");
            System.out.println("14. Count Nodes");
            System.out.println("15. Find Maximum");
            System.out.println("16. Find Minimum");
            System.out.println("17. Find Middle Element");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove Duplicates");
            System.out.println("21. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    list.insertBeginning(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    list.insertEnd(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter value: ");
                    int data = sc.nextInt();
                    System.out.print("Enter position: ");
                    int position = sc.nextInt();
                    list.insertPosition(data,position);
                    break;

                case 4:
                    System.out.print("Enter existing value: ");
                    int afterValue = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int afterData = sc.nextInt();
                    list.insertAfter(afterValue,afterData);
                    break;

                case 5:
                    System.out.print("Enter existing value: ");
                    int beforeValue = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int beforeData = sc.nextInt();
                    list.insertBefore(beforeValue,beforeData);
                    break;

                case 6:
                    list.deleteBeginning();
                    break;

                case 7:
                    list.deleteEnd();
                    break;

                case 8:
                    System.out.print("Enter position: ");
                    list.deletePosition(sc.nextInt());
                    break;

                case 9:
                    System.out.print("Enter value to delete: ");
                    list.deleteByValue(sc.nextInt());
                    break;

                case 10:
                    System.out.print("Enter value to search: ");
                    list.search(sc.nextInt());
                    break;

                case 11:
                    System.out.print("Enter old value: ");
                    int oldValue = sc.nextInt();
                    System.out.print("Enter new value: ");
                    int newValue = sc.nextInt();
                    list.update(oldValue,newValue);
                    break;

                case 12:
                    list.displayForward();
                    break;

                case 13:
                    list.displayBackward();
                    break;

                case 14:
                    list.countNodes();
                    break;

                case 15:
                    list.findMaximum();
                    break;

                case 16:
                    list.findMinimum();
                    break;

                case 17:
                    list.findMiddle();
                    break;

                case 18:
                    list.reverse();
                    break;

                case 19:
                    list.sort();
                    break;

                case 20:
                    list.removeDuplicates();
                    break;

                case 21:
                    System.out.println("Program exited.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 21);

        sc.close();
    }
}
