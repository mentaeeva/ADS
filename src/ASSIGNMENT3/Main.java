package ASSIGNMENT3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(20); //f.e: 20 buckets

        Random random = new Random();

        // random 10000 elements
        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(100000);
            String name = "Name" + random.nextInt(100000);
            MyTestingClass key = new MyTestingClass(id, name);
            Student value = new Student("Student" + i, 18 + random.nextInt(5));
            table.put(key, value);
        }

        // print amount of elements in each bucket
        for (int i = 0; i < 20; i++) {
            int count = 0;
            MyHashTable<?, ?>.HashNode<?, ?> current = table.chainArray[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println("Bucket " + i + ": " + count + " elements");
        }
    }
}
