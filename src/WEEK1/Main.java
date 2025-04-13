package WEEK1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to choose structure
        System.out.println("Choose a structure to test:");
        System.out.println("1 - MyArrayList");
        System.out.println("2 - MyLinkedList");
        System.out.println("3 - MyStack");
        System.out.println("4 - MyQueue");
        System.out.println("5 - MyMinHeap");
        int choice = scanner.nextInt();

        if (choice == 1) {
            MyList<String> list = new MyArrayList<>();
            runListMenu(list, scanner);
        } else if (choice == 2) {
            MyList<String> list = new MyLinkedList<>();
            runListMenu(list, scanner);
        } else if (choice == 3) {
            System.out.println("Choose a list for MyStack: 1 - MyArrayList, 2 - MyLinkedList");
            int listChoice = scanner.nextInt();
            MyList<String> list = (listChoice == 1) ? new MyArrayList<>() : new MyLinkedList<>();
            MyStack<String> stack = new MyStack<>(list);
            runStackMenu(stack, scanner);
        } else if (choice == 4) {
            System.out.println("Choose a list for MyQueue: 1 - MyArrayList, 2 - MyLinkedList");
            int listChoice = scanner.nextInt();
            MyList<String> list = (listChoice == 1) ? new MyArrayList<>() : new MyLinkedList<>();
            MyQueue<String> queue = new MyQueue<>(list);
            runQueueMenu(queue, scanner);
        } else if (choice == 5) {
            MyMinHeap<Integer> heap = new MyMinHeap<>(new MyArrayList<>());
            runHeapMenu(heap, scanner);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Menu for MyList (MyArrayList, MyLinkedList)
    public static void runListMenu(MyList<String> list, Scanner scanner) {
        while (true) {
            System.out.println("\nList Menu: 1 - Add, 2 - Get, 3 - Remove, 4 - Show All, 5 - Sort, 0 - Exit");
            int op = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (op) {
                case 1 -> {
                    System.out.print("Enter value to add: ");
                    String value = scanner.nextLine();
                    list.add(value);
                }
                case 2 -> {
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    System.out.println("Element: " + list.get(index));
                }
                case 3 -> {
                    System.out.print("Enter index to remove: ");
                    int index = scanner.nextInt();
                    list.remove(index);
                }
                case 4 -> {
                    Object[] array = list.toArray();
                    System.out.print("List: ");
                    for (Object obj : array) {
                        System.out.print(obj + " ");
                    }
                    System.out.println();
                }
                case 5 -> list.sort();
                case 0 -> { return; }
            }
        }
    }

    // Menu for MyStack
    public static void runStackMenu(MyStack<String> stack, Scanner scanner) {
        while (true) {
            System.out.println("\nStack Menu: 1 - Push, 2 - Pop, 3 - Peek, 0 - Exit");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Enter value to push: ");
                    String value = scanner.nextLine();
                    stack.push(value);
                }
                case 2 -> System.out.println("Popped: " + stack.pop());
                case 3 -> System.out.println("Top: " + stack.peek());
                case 0 -> { return; }
            }
        }
    }

    // Menu for MyQueue
    public static void runQueueMenu(MyQueue<String> queue, Scanner scanner) {
        while (true) {
            System.out.println("\nQueue Menu: 1 - Enqueue, 2 - Dequeue, 3 - Peek, 0 - Exit");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Enter value to enqueue: ");
                    String value = scanner.nextLine();
                    queue.enqueue(value);
                }
                case 2 -> System.out.println("Dequeued: " + queue.dequeue());
                case 3 -> System.out.println("Front: " + queue.peek());
                case 0 -> { return; }
            }
        }
    }

    // Menu for MyMinHeap
    public static void runHeapMenu(MyMinHeap<Integer> heap, Scanner scanner) {
        while (true) {
            System.out.println("\nMinHeap Menu: 1 - Insert, 2 - Extract Min, 3 - Get Min, 0 - Exit");
            int op = scanner.nextInt();

            switch (op) {
                case 1 -> {
                    System.out.print("Enter value to insert: ");
                    int val = scanner.nextInt();
                    heap.insert(val);
                }
                case 2 -> System.out.println("Extracted Min: " + heap.extractMin());
                case 3 -> System.out.println("Min: " + heap.getMin());
                case 0 -> { return; }
            }
        }
    }
}
