package projectCode20280.Algorithms;

import projectCode20280.PriorityQueues.HeapPriorityQueue;

import java.util.Arrays;

public class PQSort<E> {
    public static void sort(Integer[] a) {
        HeapPriorityQueue<Integer, Integer> pq = new HeapPriorityQueue<>(a, a);
        System.out.println(pq);
        int i=0;
        while(!pq.isEmpty()) {
            Integer e = pq.removeMin().getValue();
            a[i] = e;
            i++;
        }
    }

    public static void main(String[] args) {
        //TODO Make framework for testing time.
        Integer[] a = {65, 23, 16, 53, 68, 24, 86, 1, 87};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
