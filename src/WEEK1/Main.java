package WEEK1;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyArrayList<>();
        list.add(5);
        list.add(2);
        list.add(9);
        list.addFirst(1);
        list.addLast(10);


        for (Integer num : list) {
            System.out.print(num + " ");
        }

        list.sort();
        for (Integer num : list) {
            System.out.print(num + " ");
        }
    }
}
