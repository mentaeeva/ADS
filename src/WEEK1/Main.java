package WEEK1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a list type (1 - MyArrayList, 2 - MyLinkedList): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        MyList<Object> list;

        if (choice == 1) {
            list = new MyArrayList<>();
        } else if (choice == 2) {
            list = new MyLinkedList<>();
        } else {
            System.out.println("Invalid choice");
            return;
        }

        while (true) {
            System.out.println("\n1. Add");
            System.out.println("2. Add at index");
            System.out.println("3. Get by Index");
            System.out.println("4. Set by Index");
            System.out.println("5. Remove by Index");
            System.out.println("6. Remove First");
            System.out.println("7. Remove Last");
            System.out.println("8. Print List");
            System.out.println("9. Clear List");
            System.out.println("10. Size");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Enter value to add: ");
                    String value = scanner.nextLine();
                    list.add(value);
                    break;
                case 2:
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter value to add: ");
                    value = scanner.nextLine();
                    list.add(index, value);
                    break;
                case 3:
                    System.out.print("Enter index: ");
                    int getIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Element at index " + getIndex + ": " + list.get(getIndex));
                    break;
                case 4:
                    System.out.print("Enter index: ");
                    int setIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter value to set: ");
                    value = scanner.nextLine();
                    list.set(setIndex, value);
                    break;
                case 5:
                    System.out.print("Enter index to remove: ");
                    int removeIndex = scanner.nextInt();
                    scanner.nextLine();
                    list.remove(removeIndex);
                    System.out.println("Element removed at index " + removeIndex);
                    break;
                case 6:
                    list.removeFirst();
                    System.out.println("First element removed");
                    break;
                case 7:
                    list.removeLast();
                    System.out.println("Last element removed");
                    break;
                case 8:
                    System.out.println("List: ");
                    for (Object item : list) {
                        System.out.println(item);
                    }
                    break;
                case 9:
                    list.clear();
                    System.out.println("List cleared");
                    break;
                case 10:
                    System.out.println("Size: " + list.size());
                    break;
                case 11:
                    return;
                default:
                    System.out.println("Invalid option");
            }

            System.out.println("\nCurrent list: ");
            for (Object item : list) {
                System.out.println(item);
            }
        }
    }
}
