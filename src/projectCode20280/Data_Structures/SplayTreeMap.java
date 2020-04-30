package projectCode20280.Data_Structures;

import java.util.Comparator;

/**
 * An implementation of a sorted map using an Splay tree.
 * Implements all methods of the Binary Search Tree ADT.
 * Thomas Reilly - thomas.reilly@ucdconnect.ie
 */
public class SplayTreeMap<K,V> extends TreeMap<K,V> {
    
	  /** Constructs an empty map using the natural ordering of keys. */
	  public SplayTreeMap() { super(); }

	  /**
	   * Constructs an empty map using the given comparator to order keys.
	   * @param comp comparator defining the order of keys in the map
	   */
	  public SplayTreeMap(Comparator<K> comp) { super(comp); }

	  /** Utility used to rebalance after a map operation. */
	  private void splay(Position<Entry<K,V>> p) {
		  while (!isRoot(p)) {
			Position<Entry<K,V>> parent = parent(p);
			Position<Entry<K,V>> grandParent = parent(parent);
			if (grandParent == null) { //Zig
				tree.rotate(p);
			} else if ((parent == left(grandParent)) == (p == left(parent))) { // Zig Zig
				tree.rotate(parent);
				tree.rotate(p);
			} else { // Zig Zag
				tree.rotate(p);
				tree.rotate(p);
			}
		  }
	  }

	  /** Overrides the TreeMap rebalancing hook that is called after a node access. */
	  @Override
	  protected void rebalanceAccess(Position<Entry<K,V>> p) {
		  if (isExternal(p))
		  	p = parent(p);
		  if (p != null)
		  	splay(p);
	  }

	  /** Overrides the TreeMap rebalancing hook that is called after an insertion. */
	  @Override
	  protected void rebalanceInsert(Position<Entry<K,V>> p) {
	  	splay(p);
	  }

	  /** Overrides the TreeMap rebalancing hook that is called after a deletion. */
	  @Override
	  protected void rebalanceDelete(Position<Entry<K,V>> p) {
		  if (!isRoot(p))
		  	splay(parent(p));
	  }

	  public String toBinaryTreeString() {
			BinaryTreePrinter< Entry<K, V> > btp = new BinaryTreePrinter<>(this.tree);
			return btp.print();
	  }

	public static void main(String [] args) {
		// Construct and fill an SplayTreeMap
		SplayTreeMap<Integer, Integer> splayTree = new SplayTreeMap<>();
		Integer[] arr = new Integer[] { 44, 17, 88, 8, 32, 65, 97, 28, 54, 82, 93, 21, 29, 76, 80 };
		for (Integer i : arr) {
			splayTree.put(i, i);
		}

		// Print the tree and do a sanity check
		System.out.println("SplayTreeMap size: " + splayTree.size());
		System.out.println(splayTree.toBinaryTreeString());
		System.out.println("SplayTreeMap: " + splayTree.toString());

		// Remove 44 from the tree
		System.out.println("\nRemoving 44 from the SplayTreeMap");
		splayTree.remove(arr[0]);

		// Print the tree again and do a sanity check...
		System.out.println("\nSplayTreeMap size: " + splayTree.size());
		System.out.println(splayTree.toBinaryTreeString());
	}

	}
