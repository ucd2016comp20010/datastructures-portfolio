package projectCode20280.PriorityQueues;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * An implementation of a priority queue using an array-based heap.
 */
public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

  /** An ArrayList that will be used to store the heap. */
  private final ArrayList<Entry<K, V>> heap = new ArrayList<>();

  /** Creates an empty priority queue based on the natural ordering of its keys. */
  public HeapPriorityQueue() { super(); }

  /**
   * Creates an empty priority queue using the given comparator to order keys.
   * @param comp comparator defining the order of keys in the priority queue
   */
  public HeapPriorityQueue(Comparator<K> comp) { super(comp); }

  /**
   * Creates a priority queue initialized with the respective
   * key-value pairs.  The two arrays given will be paired
   * element-by-element. They are presumed to have the same
   * length. (If not, entries will be created only up to the length of
   * the shorter of the arrays)
   * @param keys an array of the initial keys for the priority queue
   * @param values an array of the initial values for the priority queue
   */
  public HeapPriorityQueue(K[] keys, V[] values) {
    super();
    for (int i = 0; i < keys.length; i++) {
      heap.add((new PQEntry<>(keys[i], values[i])));
    }
    heapify();
  }

  // protected utilities
  protected int parent(int j) {
    if (j%2 == 1) {
      //j is a left node
      return (j-1)/2;
    } else {
      //j is a right node
      return (j-2)/2;
    }
  }
  protected int left(int j) {
    return (2*j)+1;
  }

  protected int right(int j) {
    return  (2*j)+2;
  }

  protected boolean hasLeft(int j) {
    return left(j) < size();
  }

  protected boolean hasRight(int j) {
    return right(j) < size();
  }

  /** Exchanges the entries at indices i and j of the array list. */
  protected void swap(int i, int j) {
    Entry<K,V> temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }

  /** Moves the entry at index j higher, if necessary, to restore the heap property. */
  protected void upHeap(int j) {
    if (j == 0) {
      return;
      //is root, so do nothing. (Base Case)
    } else if (compare(heap.get(j), heap.get(parent(j))) <= 0) {
      //Parent is greater so swap
      swap(j, parent(j));
      upHeap(parent(j));
    }
    //Otherwise child is greater than/equal to parent so its in the correct position. (Base Case)
  }
  
  /** Moves the entry at index j lower, if necessary, to restore the heap property. */
  protected void downHeap(int j) {
    int min = j;
    if(hasLeft(j) && compare(heap.get(left(j)), heap.get(j)) < 0) {
      min = left(j);
    }
    if (hasRight(j) && compare(heap.get(right(j)), heap.get(j)) < 0 && compare(heap.get(right(j)), heap.get(left(j))) < 0) {
      min = right(j);
    }
    if (min != j) {
      swap(j, min);
      downHeap(min);
    }
  }

  /** Performs a bottom-up construction of the heap in linear time. */
  protected void heapify() {
    // Treat the heap as though all of its levels are full.
    // n represents the size of the heap as though it its final level was full by rounding size up to the nearest power of 2.
    int n = (int) Math.pow(2, Math.ceil(Math.log(size())/Math.log(2)));
    int div=2;
    int layerStart = Math.floorDiv(n-1, div*2);
    int nextLayerStart = n-1-(n/div);
    while (div*2 <= n){
      for (int i = layerStart; i < nextLayerStart; i++) {
        downHeap(i);
      }
      nextLayerStart=layerStart;
      div *= 2;
      layerStart = Math.floorDiv(n-1, div*2);
    }
  }

  /**
   * Returns the number of items in the priority queue.
   * @return number of items
   */
  @Override
  public int size() { return heap.size(); }

  /**
   * Returns (but does not remove) an entry with minimal key.
   * @return entry having a minimal key (or null if empty)
   */
  @Override
  public Entry<K,V> min() {
    return heap.get(0);
  }

  /**
   * Inserts a key-value pair and return the entry created.
   * @param key     the key of the new entry
   * @param value   the associated value of the new entry
   * @return the entry storing the new key-value pair
   * @throws IllegalArgumentException if the key is unacceptable for this queue
   */
  @Override
  public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
    Entry<K,V> newEntry = new PQEntry<>(key, value);
    heap.add(newEntry);
    upHeap(heap.size()-1);
    return newEntry;
  }

  /**
   * Removes and returns an entry with minimal key.
   * @return the removed entry (or null if empty)
   */
  @Override
  public Entry<K,V> removeMin() {
    Entry<K,V> temp = heap.get(0);
    swap(heap.size()-1, 0);
    heap.remove(size()-1);
    downHeap(0);
    return temp;
  }

  @Override
  public String toString() {
    return "HeapPriorityQueue " + heap;
  }

  /** Used for debugging purposes only */
  private void sanityCheck() {
    for (int j=0; j < heap.size(); j++) {
      int left = left(j);
      int right = right(j);
      if (left < heap.size() && compare(heap.get(left), heap.get(j)) < 0) {
        System.out.println("Invalid left child relationship");
        return;
      }
      if (right < heap.size() && compare(heap.get(right), heap.get(j)) < 0) {
        System.out.println("Invalid right child relationship");
        return;
      }
    }
    System.out.println("No invalid heap relationships found!");
  }

  public static void main(String[] args) {
    Integer[] keys = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    //Test constructor, toString, insert and upHeap functions
    HeapPriorityQueue<Integer, Integer> hpq = new HeapPriorityQueue<>(keys, values);

    System.out.println(hpq);
    hpq.sanityCheck();
    //Test min() function
    System.out.println("Minimum value: " + hpq.min());

    //Test removeMin and downHeap functions
    hpq.removeMin();
    System.out.println("After removing minimum value: " + hpq);
    hpq.sanityCheck();
  }
}

