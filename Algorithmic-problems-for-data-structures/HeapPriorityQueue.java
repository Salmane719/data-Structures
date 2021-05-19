import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * An implementation of priority queue
 * implements priorityQueue ADT:size(), insert(k, v ) , removeMin() , min()
 *
 * isEmpty from priority Queue that is already implemented in abstractPriorityQueue
 *
 * additional functions used :toString().
 *
 * @author salmane madkour , 19724421
 * @author Aonghus lawlor
 * reference : data structures
 */

public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {
    }

    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    public HeapPriorityQueue(K[] keys, V[] values) {
        IntStream.range(0, Math.min(keys.length, values.length)).forEach((j) -> {
            this.heap.add(new PQEntry<>(keys[j], values[j]));
        });
        this.heapify();
    }

    protected int parent(int j) {
        return (j - 1) / 2;
    }//parent

    protected int left(int j) {
        return 2 * j + 1;
    }//left

    protected int right(int j) {
        return 2 * j + 2;
    }//right

    protected boolean hasLeft(int j) {
        return this.left(j) < this.heap.size();
    }//hasLeft

    protected boolean hasRight(int j) {
        return this.right(j) < this.heap.size();
    }//hasRight
    // exchange the entries at indexes i and j in the array list
    protected void swap(int i, int j) {
        Entry<K, V> temp = (Entry<K, V>)this.heap.get(i);
        this.heap.set(i, (Entry<K, V>)this.heap.get(j));
        this.heap.set(j, temp);
    }
    // moves the entry at index j higher , to restore the heap priority
    protected void upheap(int j) {
        while (true) {
            if (j == 0) break;
            int parent = parent(j);
            if (compare(heap.get(parent), heap.get(j)) >= 0) {
                swap(j, parent);
                j = parent;
            } else {
                break;
            }
        }
    }


    // moves the entry at index j lower to restore property
    protected void downheap(int j) {
        int min;
        do {
            if (!hasLeft(j)) break;
            if (!(compare(heap.get(left(j)), heap.get(right(j))) <= 0) && hasRight(j)) {
                min = right(j);
            } else {
                min = left(j);
            }
            if (compare(heap.get(min), heap.get(j)) >= 0) break;
            swap(j, min);
            j = min;
        } while (true);
    }
    //performs a construction of the heap in linear time
    protected void heapify() {
        int idx = this.parent(this.size() - 1);
        IntStream.iterate(idx, (i) -> {
            return i >= 0;
        }, (i) -> {
            return i - 1;
        }).forEach(this::upheap);
    }
    //returns the number of items in the priority queue and returns
    //number of items
    public int size() {
        return this.heap.size();
    }
    // this function doesnt remove anything but returns an entry with minimal key
    public Entry<K, V> min() {
        return (Entry<K, V>)this.heap.get(0);
    }
    // it inserts a key-value pair and return the entry created
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        Entry<K, V> n = new PQEntry<>(key, value);
        this.heap.add(n);
        this.upheap(this.heap.size() - 1);
        return n;
    }
    //removes and returns an entry with minimal key
    public Entry<K, V> removeMin() {
        if (this.heap.isEmpty()) {
            return null;
        } else {
            Entry<K, V> answer = (Entry<K, V>)this.heap.get(0);
            this.swap(0, this.heap.size() - 1);
            this.heap.remove(this.heap.size() - 1);
            this.downheap(0);
            return answer;
        }
    }
    // does the string representation of the string and return string
    //representation of the heap.
    public String toString() {
        StringBuilder pp = new StringBuilder("[");
        for (int i = 0; i < heap.size(); i++) {
            Entry<K, V> elem = heap.get(i);
            pp.append(elem.getKey()).append(", ");
        }
        pp = new StringBuilder(pp.substring(0, pp.length() - 2));
        pp.append("]");
        return pp.toString();
    }
    // return true if heap is invariant satisfied
    public Boolean sanityCheck() {
        int j = 0;
        while (j < heap.size()) {
            int l = left(j);
            int r = right(j);
            if (!(l >= heap.size() || compare(heap.get(l), heap.get(j)) >= 0) || r < heap.size() && compare(heap.get(r), heap.get(j)) < 0) {
                return false;
            }
            j++;
        }
        return true;
    }

    //displays the heap using binary tree printer and return
    //string representation of the tree map
    public static <T> String toBinaryTreeString(PriorityQueue<T> pq) {
        LinkedBinaryTree<T> bt = new LinkedBinaryTree<>();
        bt.createLevelOrder(new ArrayList<>(pq));
        return bt.toString();
    }

    public static void main(String[] args) {
        new HeapPriorityQueue();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new DefaultComparator<>());
        Integer[] rands = new Integer[]{35, 26, 15, 24, 33, 4, 12, 1, 23, 21, 2, 5};
        int var6 = rands.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Integer i = rands[var7];
            pq.add(i);
            System.out.println(toBinaryTreeString(pq));
        }

        pq.add(34);
//        HeapPriorityQueue<Integer, Integer> pq = new HeapPriorityQueue<>(new Integer[]{16,15,14,13,12,11,20,9,8,7,6,5,4,3,2,1},
//                new Integer[]{16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1});
//        System.out.println(pq);
//        pq.sanityCheck();

    }
}