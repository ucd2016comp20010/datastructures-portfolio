package projectCode20280.Algorithms;

import projectCode20280.PriorityQueues.HeapPriorityQueue;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

public class PQSort<E> {
    /*
    Performs a sort on Integer array a, ordering elements from lowest to highest.
    This sort uses a Heap Type Priority Queue algorithm.
     */
    public static void hpqSort(Integer[] a) {
        HeapPriorityQueue<Integer, Integer> pq = new HeapPriorityQueue<>(a, a);
        int i=0;
        while(!pq.isEmpty()) {
            Integer e = pq.removeMin().getValue();
            a[i] = e;
            i++;
        }
    }

    /*
    Performs a sort on Integer array a, ordering elements from lowest to highest.
    This sort uses a Linked List Type Priority Queue algorithm.
     */
    public static void llpqSort(LinkedList<Integer> a) {
        LinkedList<Integer> pq = new LinkedList<>();
        while (!a.isEmpty()) {
            pq.addLast(a.removeFirst());
        }
        while (!pq.isEmpty()) {
            a.addLast(removeMin(pq));
        }
    }

    /*
    A helper function for llpq sort.
    Removes and returns the minimum value of a givenLinkedList<Integer>.
     */
    private static Integer removeMin(LinkedList<Integer> ll) {
        int minIndex = 0;
        Integer min = ll.get(minIndex);
        for (int i = 1; i < ll.size(); i++) {
            Integer curr = ll.get(i);
            if (curr < min) {
                min = curr;
                minIndex = i;
            }
        }
        ll.remove(minIndex);
        return min;
    }

    /*
    Checks if the given array is sorted or not.
    Returns true if it is sorted.
    Returns false if not.
     */
    private static boolean isSorted(Comparable[] array, int length) {
        if (array == null || length < 2)
            return true;
        if (array[length - 2].compareTo(array[length - 1]) > 0)
            return false;
        return isSorted(array, length - 1);
    }

    public static void main(String[] args) {
        int n = 100;
        long start, timeTaken;
        Random random = new Random();

        System.out.println("Testing Linked List Type Priority Queue Sort...");
        System.out.println("Array Size | Time Taken | IsSorted?");
        while (n < 1000) {
            LinkedList<Integer> arr = random.ints(0, 1000).distinct().limit(n).boxed()
                    .collect(Collectors.toCollection(LinkedList<Integer>::new));

            start = System.nanoTime();
            llpqSort(arr);
            timeTaken = System.nanoTime() - start;


            System.out.println(n + " " + timeTaken + " " + isSorted(arr.toArray(new Integer[arr.size()]), arr.size()));

            n *= 1.1;
        }

        n=100;
        System.out.println("\nTesting Heap Type Priority Queue Sort...");
        System.out.println("Array Size | Time Taken | IsSorted?");
        while (n < 1000000) {
            LinkedList<Integer> arr = random.ints(0, 1000000).distinct().limit(n).boxed()
                    .collect(Collectors.toCollection(LinkedList<Integer>::new));
            Integer[] a = arr.toArray(new Integer[arr.size()]);

            start = System.nanoTime();
            hpqSort(a);
            timeTaken = System.nanoTime() - start;


            System.out.println(n + " " + timeTaken);

            n *= 1.1;
        }

    }

}
