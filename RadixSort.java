
import java.util.LinkedList;

public class RadixSort {

    public static void radixSort(LinkedList<Integer> list) {

        LinkedList<LinkedList<Integer>> buckets = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            buckets.add(new LinkedList<>());
        }

        int max = 0;
        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }

        for (long exp = 1; max / exp > 0; exp *= 10) {

            for (int num : list) {
                int digit = (int) ((num / exp) % 10);
                buckets.get(digit).add(num);
            }

            list.clear();

            for (LinkedList<Integer> bucket : buckets) {
                list.addAll(bucket);
                bucket.clear();
            }
        }
    }

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(170);
        list.add(45);
        list.add(75);
        list.add(90);
        list.add(802);
        list.add(24);
        list.add(2);
        list.add(66);

        System.out.println("Before: " + list);

        radixSort(list);

        System.out.println("After: " + list);
    }
}
