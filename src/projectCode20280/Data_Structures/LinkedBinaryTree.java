package projectCode20280.Data_Structures;

/**
 * Concrete implementation of a binary tree using a node-based, linked structure.
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {


  /** Nested static class for a binary tree node. */
  protected static class Node<E> implements Position<E>
  {
    private E element;
    private Node<E> parent;
    private Node<E> left;
    private Node<E> right;

    public Node(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
      this.element = e;
      this.parent = parent;
      this.left = leftChild;
      this.right = rightChild;
    }

    @Override
    public E getElement()
    {
      return element;
    }

    public Node<E> getParent()
    {
      return parent;
    }

    public Node<E> getLeft()
    {
      return left;
    }

    public Node<E> getRight()
    {
      return right;
    }

    public void setElement(E element)
    {
      this.element = element;
    }

    public void setLeft(Node<E> left)
    {
      this.left = left;
    }

    public void setParent(Node<E> parent)
    {
      this.parent = parent;
    }

    public void setRight(Node<E> right)
    {
      this.right = right;
    }

    @Override
    public String toString() {
      return "(" + element + ")";
    }
  }

  /** Factory function to create a new node storing element e. */
  protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right)
  {
    return new Node<E>(e, parent, left, right);
  }

  // LinkedBinaryTree instance variables
  /** The root of the binary tree */
  protected Node<E> root = null;     // root of the tree

  /** The number of nodes in the binary tree */
  private int size = 0;              // number of nodes in the tree

  // constructor
  /** Construts an empty binary tree. */
  public LinkedBinaryTree() { }      // constructs an empty binary tree

  // nonpublic utility
  /**
   * Verifies that a Position belongs to the appropriate class, and is
   * not one that has been previously removed. Note that our current
   * implementation does not actually verify that the position belongs
   * to this particular list instance.
   *
   * @param p   a Position (that should belong to this tree)
   * @return    the underlying Node instance for the position
   * @throws IllegalArgumentException if an invalid position is detected
   */
  protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
    if (!(p instanceof Node))
      throw new IllegalArgumentException("Not valid position type");
    Node<E> node = (Node<E>) p;       // safe cast
    if (node.getParent() == node)     // our convention for defunct node
      throw new IllegalArgumentException("p is no longer in the tree");
    return node;
  }

  // accessor methods (not already implemented in AbstractBinaryTree)
  /**
   * Returns the number of nodes in the tree.
   * @return number of nodes in the tree
   */
  @Override
  public int size() {
    return size;
  }

  @Override
  public void createLevelOrder(Integer[] arr) {
      //TODO
  }

  /**
   * Returns the root Position of the tree (or null if tree is empty).
   * @return root Position of the tree (or null if tree is empty)
   */
  @Override
  public Position<E> root() {
    return this.root;
  }

  /**
   * Returns the Position of p's parent (or null if p is root).
   *
   * @param p    A valid Position within the tree
   * @return Position of p's parent (or null if p is root)
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  @Override
  public Position<E> parent(Position<E> p) throws IllegalArgumentException {
	Node<E> pos = (Node<E>) p;
    return pos.getParent();
  }

  /**
   * Returns the Position of p's left child (or null if no child exists).
   *
   * @param p A valid Position within the tree
   * @return the Position of the left child (or null if no child exists)
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   */
  @Override
  public Position<E> left(Position<E> p) throws IllegalArgumentException {
    Node<E> pos = (Node<E>) p;
    return pos.getLeft();
  }

  /**
   * Returns the Position of p's right child (or null if no child exists).
   *
   * @param p A valid Position within the tree
   * @return the Position of the right child (or null if no child exists)
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   */
  @Override
  public Position<E> right(Position<E> p) throws IllegalArgumentException {
    Node<E> pos = (Node<E>) p;
    return pos.getRight();
  }

  // update methods supported by this class
  /**
   * Places element e at the root of an empty tree and returns its new Position.
   *
   * @param e   the new element
   * @return the Position of the new element
   * @throws IllegalStateException if the tree is not empty
   */
  public Position<E> addRoot(E e) throws IllegalStateException {
    if (!isEmpty()) {
      throw new IllegalStateException("There is already a root");
    }
    Node<E> node = createNode(e, null, null, null);
	this.root = node;
	size++;
    return node;
  }

  public void insert(E e){
      //recursively add from root
      //root = addRecursive(root,null, e);
      ++size;
  }
  
  // recursively add Nodes to binary tree in proper position
//  private Node<E> addRecursive(Node<E> curr, Node<E> p, E e){
//	// Base Cases
//    if (isEmpty()) {
//      root = createNode(e, null, null, null);
//      return root;
//    } else if (curr == null) {
//      return createNode(e, p, null, null);
//    }
//
//    // Recursive Cases
//	if (curr.getElement().compareTo(e) > 0) {
//	  // e>curr -> add to the left recursively
//      curr.left = addRecursive(curr.left, curr,  e);
//      return curr;
//    } else if (curr.getElement().compareTo(e) < 0){
//      // e<curr -> add to the right recursively
//	  curr.right = addRecursive(curr.right, curr, e);
//      return curr;
//    } else {
//	  // e already exists in the tree
//	  return curr;
//    }
//  }

  
  /**
   * Creates a new left child of Position p storing element e and returns its Position.
   *
   * @param p   the Position to the left of which the new element is inserted
   * @param e   the new element
   * @return the Position of the new element
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   * @throws IllegalArgumentException if p already has a left child
   */
  public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
      Node<E> pos = (Node<E>) p;
      Node<E> newN = new Node<E>(e, pos, null, null);
      pos.setLeft(newN);
      size++;
      return newN;

  }

  /**
   * Creates a new right child of Position p storing element e and returns its Position.
   *
   * @param p   the Position to the right of which the new element is inserted
   * @param e   the new element
   * @return the Position of the new element
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   * @throws IllegalArgumentException if p already has a right child
   */
  public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> pos = (Node<E>) p;
    Node<E> newN = new Node<E>(e, pos, null, null);
    pos.setRight(newN);
    size++;
    return newN;
  }

  /**
   * Replaces the element at Position p with element e and returns the replaced element.
   *
   * @param p   the relevant Position
   * @param e   the new element
   * @return the replaced element
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   */
  public E set(Position<E> p, E e) throws IllegalArgumentException {
    Node<E> node = (Node<E>) p;
    E old = node.getElement();
    node.setElement(e);
    return old;
  }

  /**
   * Attaches trees t1 and t2, respectively, as the left and right subtree of the
   * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
   *
   * @param p   a leaf of the tree
   * @param t1  an independent tree whose structure becomes the left child of p
   * @param t2  an independent tree whose structure becomes the right child of p
   * @throws IllegalArgumentException if p is not a valid Position for this tree
   * @throws IllegalArgumentException if p is not a leaf
   */
  public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
    //TODO
  }

  /**
   * Removes the node at Position p and replaces it with its child, if any.
   *
   * @param p   the relevant Position
   * @return element that was removed
   * @throws IllegalArgumentException if p is not a valid Position for this tree.
   * @throws IllegalArgumentException if p has two children.
   */
  public E remove(Position<E> p) throws IllegalArgumentException {
    Node<E> n = (Node<E>) p;

	if (numChildren(n) == 2) {
	  throw new IllegalArgumentException("Can't remove node with 2 children");
    }

	//Fix up the child pointers
	Node<E> child = n.getLeft() != null ? n.getLeft() : n.getRight();
	if (child != null) {
	  child.setParent(n.getParent());
    }

	//Fix up the parent pointers
	if (n == root) {
	  root = child;
    } else {
	  Node<E> parent = n.getParent();
	  if (n == parent.getLeft()) {
	    parent.setLeft(child);
      } else {
	    parent.setRight(child);
      }
    }

	//Reduce the size
    size--;

	//Return the removed element
	return n.getElement();
  }
  
  public String toString() {
	  StringBuilder sb = new StringBuilder();
	  sb.append("[");
	  for(Position<E> p : positions()) {
		  sb.append(p.getElement());
		  sb.append(", ");
	  }
	  sb.append("]");
	  return sb.toString();
  }
  
  public static void main(String [] args)
  {
	  LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<>();

	  int [] arr = {12, 25, 31, 58, 36, 42, 90, 62, 75};
	  for(int i : arr) {
		  bt.insert(i);
	  }
	  System.out.println("bt: " + bt.size() + " " + bt );
	  
  }
} 

