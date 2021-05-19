/**
 * @author salmane madkour
 * @author Aonghus lawlor
 * reference: data structures
 * implementation of a binary tree using a node basically linked structure
 * implementing previous methods from abstract tree : root , parent , size
 *
 * Binarytree are implemented in abstractTree and abstractBinary tree
 *
 *additional public functions: addRoot , addLeft, addRight , insert ,set , attach , remove
 * toString , countLeftExternalNodes , countDescendants
 *
 *contains an inner node class which represents a tree node
 */

import java.util.ArrayList;

/**
 * Concrete implementation of a binary tree using a node-based, linked
 * structure.
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    static java.util.Random rnd = new java.util.Random();
    /**
     * The root of the binary tree
     */
    protected Node<E> root = null; // root of the tree

    // LinkedBinaryTree instance variables
    /**
     * The number of nodes in the binary tree
     */
    private int size = 0; // number of nodes in the tree

    /**
     * Constructs an empty binary tree.
     */
    public LinkedBinaryTree() {
    } // constructs an empty binary tree

    // constructor

    // main method to run the tests and checking if the function works properly
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> bt = new LinkedBinaryTree<Integer>();


        // Direct construction of Tree
        Position<Integer> root = bt.addRoot(12);
        Position<Integer> p1 = bt.addLeft(root, 25);
        Position<Integer> p2 =
                bt.addRight(root, 31);

        Position<Integer> p3 = bt.addLeft(p1, 58);
        bt.addRight(p1, 36);

        Position<Integer> p5 = bt.addLeft(p2, 42);
        bt.addRight(p2, 90);

        Position<Integer> p4 = bt.addLeft(p3, 62);
        bt.addRight(p3, 75);


        // Can you write a level order constructor?
        // Level order construction
        Integer[] arr = {12, 25, 31, 58, 36, 42, 90, 62, 75};
        bt.createLevelOrder(arr);

        System.out.println("bt inorder: " + bt.size() + " " + bt.inorder());
        System.out.println("bt preorder: " + bt.size() + " " + bt.preorder());
        System.out.println("bt preorder: " + bt.size() + " " + bt.postorder());

        System.out.println("bt height: " + bt.height(bt.root()));
        System.out.println("bt depth: " + bt.depth(bt.root()));

        System.out.println(bt.toString());
    }


    /**
     * Factory function to create a new node storing element e.
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    /**
     * Verifies that a Position belongs to the appropriate class, and is not one
     * that has been previously removed. Note that our current implementation does
     * not actually verify that the position belongs to this particular list
     * instance.
     *
     * @param p a Position (that should belong to this tree)
     * @return the underlying Node instance for the position
     * @throws IllegalArgumentException if an invalid position is detected
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getParent() == node) // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    /**
     * Returns the number of nodes in the tree.
     *
     * @return number of nodes in the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the root Position of the tree (or null if tree is empty).
     *
     * @return root Position of the tree (or null if tree is empty)
     */
    @Override
    public Position<E> root() {
        return root;
    }

    /**
     * Returns the Position of p's parent (or null if p is root).
     *
     * @param p A valid Position within the tree
     * @return Position of p's parent (or null if p is root)
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {

        return ((Node<E>) p).parent;
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
        return ((Node) p).left;
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
        return ((Node<E>) p).right;
    }

    /**
     * Places element e at the root of an empty tree and returns its new Position.
     *
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty())
            throw new IllegalArgumentException("Root already exists");

        size++;
        root = createNode(e, null, null, null);
        return root;
    }


    /**
     * Creates a new left child of Position p storing element e and returns its
     * Position.
     *
     * @param p the Position to the left of which the new element is inserted
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p already has a left child
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = (Node<E>) p;
        Node<E> newest = createNode(e, parent, null, null);
        parent.left = newest;
        size++;
        return newest;
    }

    /**
     * Creates a new right child of Position p storing element e and returns its
     * Position.
     *
     * @param p the Position to the right of which the new element is inserted
     * @param e the new element
     * @return the Position of the new element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p already has a right child
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = (Node<E>) p;
        Node<E> newest = createNode(e, parent, null, null);
        parent.right = newest;
        size++;
        return newest;
    }

    /**
     * Replaces the element at Position p with element e and returns the replaced
     * element.
     *
     * @param p the relevant Position
     * @param e the new element
     * @return the replaced element
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E ans = node.getElement();
        node.setElement(e);
        return ans;
    }

    // returning adding nodes to binary tree in proper position.
    private Node<E> addRecursive(Node<E> p, E e) {
        if (p == null) {
            p = createNode(e, null, null, null);
            return p;
        } else {
            String data = e.toString();
            String position = p.element.toString();

            if (data.compareTo(position) < 0) {
                p.left = addRecursive(p.left, e);
                if (data.compareTo(position) > 0) {
                    p.right = addRecursive(p.right, e);
                } else return p;
                return p;
            } else {
                if (data.compareTo(position) > 0) {
                    p.right = addRecursive(p.right, e);
                } else return p;
                return p;
            }

        }
    }

    /**
     * Attaches trees t1 and t2, respectively, as the left and right subtree of the
     * leaf Position p. As a side effect, t1 and t2 are set to empty trees.
     *
     * @param p  a leaf of the tree
     * @param t1 an independent tree whose structure becomes the left child of p
     * @param t2 an independent tree whose structure becomes the right child of p
     * @throws IllegalArgumentException if p is not a valid Position for this tree
     * @throws IllegalArgumentException if p is not a leaf
     */
    public void attach (Position<E> p, LinkedBinaryTree < E > t1, LinkedBinaryTree < E > t2) throws
            IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null || parent.getRight() != null)
            throw new IllegalArgumentException("the Node is not a leaf !");
        parent.setLeft(t1.root);
        parent.setRight(t2.root);
    }

    /**
     * Removes the node at Position p and replaces it with its child, if any.
     *
     * @param p the relevant Position
     * @return element that was removed
     * @throws IllegalArgumentException if p is not a valid Position for this tree.
     * @throws IllegalArgumentException if p has two children.
     */
    public E remove (Position < E > p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null)
            child.setParent(node.getParent());
        if (node == root) root = child;
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E store = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return store;
    }

    // returning a toString which is useful in separating them with comma
    public String toString () {
        // you can use either the StringBuilder or ArrayList...
        StringBuilder sb = new StringBuilder();
        ArrayList<E> buf = new ArrayList<>();
        //sb.append("[");
        for (Position<E> p : positions()) {
            //sb.append(p.getElement());
            //sb.append(", ");
            buf.add(p.getElement());
        }
        //sb.append("]");
        //return sb.toString();
        return buf.toString();
    }
    // fills in the binary tree from in level order given from a given array
    public void createLevelOrder (ArrayList < E > l) {
        root = createLevelOrderHelper(l, root, 0);
    }
    // helper for level order tree construction from an array
    private Node<E> createLevelOrderHelper (ArrayList < E > l, Node < E > p,int i){
        if (i < l.toArray().length) {
            Node<E> newest = createNode(l.get(i), p, null, null);
            newest.left = createLevelOrderHelper(l, newest.left, 2 * i + 1);
            newest.right = createLevelOrderHelper(l, newest.right, 2 * i + 2);
            ++size;
            return newest;
        }
        return p;
    }
    //fills in the binary tree from in level order given from a given array
    public void createLevelOrder (E[]arr){
        root = createLevelOrderHelper(arr, root, 0);
    }
    // helper level order tree from an array
    private Node<E> createLevelOrderHelper (E[]arr, Node < E > p,int i){
        if (i < arr.length) {
            Node<E> newest = createNode(arr[i], p, null, null);
            newest.left = createLevelOrderHelper(arr, newest.left, 2 * i + 1);
            newest.right = createLevelOrderHelper(arr, newest.right, 2 * i + 2);
            ++size;
            return newest;
        }
        return p;
    }


    /**
     * Nested static class for a binary tree node.
     */
    public static class Node<E> implements Position<E> {
        private E element;
        private Node<E> left, right, parent;

        //constructor passing in element node element , parent in the parent node ,
        //left for left child node , right for right child node in the parameters.

        public Node(E e, Node<E> p, Node<E> l, Node<E> r) {
            // TODO
            element = e;
            parent = p;
            left = l;
            right = r;

        }


        @Override
        //returns elements sorted at this position
        public E getElement() throws IllegalStateException {
            return element;
        }

        // setter
        public void setElement(E element) {
            this.element = element;
        }

        //  using toString here
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(element);
            return sb.toString();
        }

        // getter
        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }


        // accessor
        // TODO implement the class

    }

}