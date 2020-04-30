package projectCode20280.Data_Structures;

import java.util.ArrayList;

/**
 * Map implementation using hash table with separate chaining.
 * Implements all methods of the HashMap ADT.
 * @author: Thomas Reilly - thomas.reilly@ucdconeect.ie
 */
public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
	// a fixed capacity array of UnsortedTableMap that serve as buckets
	private UnsortedTableMap<K, V>[] table; // initialized within createTable

	/** Creates a hash table with capacity 11 and prime factor 109345121. */
	public ChainHashMap() {
		super();
	}

	/** Creates a hash table with given capacity and prime factor 109345121. */
	public ChainHashMap(int cap) {
		super(cap);
	}

	/** Creates a hash table with the given capacity and prime factor. */
	public ChainHashMap(int cap, int p) {
		super(cap, p);
	}

	/** Creates an empty table having length equal to current capacity. */
	@Override
	@SuppressWarnings({ "unchecked" })
	protected void createTable() {
		table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
	}

	/**
	 * Returns value associated with key k in bucket with hash value h. If no such
	 * entry exists, returns null.
	 * 
	 * @param h the hash value of the relevant bucket
	 * @param k the key of interest
	 * @return associate value (or null, if no such entry)
	 */
	@Override
	protected V bucketGet(int h, K k) {
		UnsortedTableMap<K,V> bucket = table[h];
		return bucket == null ? null : bucket.get(k);
	}

	/**
	 * Associates key k with value v in bucket with hash value h, returning the
	 * previously associated value, if any.
	 * 
	 * @param h the hash value of the relevant bucket
	 * @param k the key of interest
	 * @param v the value to be associated
	 * @return previous value associated with k (or null, if no such entry)
	 */
	@Override
	protected V bucketPut(int h, K k, V v) {
		UnsortedTableMap<K,V> bucket = table[h];
		if (bucket == null) { // If the bucket doesn't exist, make one.
			bucket = new UnsortedTableMap<>();
			table[h] = bucket;
		}
		int oldSize = bucket.size();
		V old = bucket.put(k, v);
		n -= (oldSize - bucket.size()); // Only increment size if a new element has been created.
		return old;
	}

	/**
	 * Removes entry having key k from bucket with hash value h, returning the
	 * previously associated value, if found.
	 * 
	 * @param h the hash value of the relevant bucket
	 * @param k the key of interest
	 * @return previous value associated with k (or null, if no such entry)
	 */
	@Override
	protected V bucketRemove(int h, K k) {
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null) { //if the bucket doesn't exist, just return null
			return null;
		}
		int oldSize = bucket.size();
		V old = bucket.remove(k);
		n += (bucket.size() - oldSize);
		return old;
	}

	/**
	 * Returns an iterable collection of all key-value entries of the map.
	 *
	 * @return iterable collection of the map's entries
	 */
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		ArrayList<Entry<K,V>> set = new ArrayList<>();
		for (UnsortedTableMap<K,V> bucket:table) {
			if (bucket != null) { //Don't bother printing empty buckets
				for (Entry<K,V> entry:bucket.entrySet()) {
					set.add(entry);
				}
			}
		}
		return set;
	}

	@Override
	public String toString() {
		return entrySet().toString();
	}

	public static void main(String[] args) {
		//Test construction
		System.out.println("Creating a ChainHashMap");
		ChainHashMap<Integer, String> m = new ChainHashMap<>();
		System.out.println("ChainHashMap: " + m);

		//Test putting entries
		System.out.println("\nAdding the following (key, value) entries:");

		System.out.println("1, \"One\"");
		System.out.println("size before: " + m.size());
		String n = m.put(1, "One");
		System.out.println("size after: " + m.size());
		System.out.println("return value of put: " + n);


		System.out.println("10, \"Ten\"");
		m.put(10, "Ten");
		System.out.println("11, \"Eleven\"");
		m.put(11, "Eleven");
		System.out.println("20, \"Twenty\"");
		m.put(20, "Twenty");
		
		System.out.println("\nChainHashMap: " + m);

		//Test getting
		System.out.println("\nGetting key 20");
		n = m.get(20);
		System.out.println("returned value: " + n);

		//Test removing
		System.out.println("\nRemoving key 11");
		n = m.remove(11);
		System.out.println("return value of remove: " + n);
		System.out.println("ChainHashMap: " + m);
	}
}
