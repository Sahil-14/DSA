
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

public class SQ18 {
  // store keys of cache
  private Deque<Integer> doublyQueue;

  // store references of key in cache
  private HashSet<Integer> hashSet;

  private final int CACHE_SIZE;

  SQ18(int capacity) {
    doublyQueue = new LinkedList<>();
    hashSet = new HashSet<>();
    CACHE_SIZE = capacity;
  }

  public void refer(int page) {
    if (!hashSet.contains(page)) {
      if (doublyQueue.size() == CACHE_SIZE) {
        int last = doublyQueue.removeLast();
        hashSet.remove(last);
      }
    } else {
      hashSet.remove(page);
    }
    doublyQueue.push(page);
    hashSet.add(page);
  }

  // display contents of cache
  public void display() {
    Iterator<Integer> itr = doublyQueue.iterator();
    while (itr.hasNext()) {
      System.out.print(itr.next() + " ");
    }
  }


  /**
   * method 2
   * 
   * Set<Integer> cache;
   * int capacity;
   * 
   * 
   * public LRUCache(int capacity)
   * {
   * this.cache = new LinkedHashSet<Integer>(capacity);
   * this.capacity = capacity;
   * }
   * 
   * // This function returns false if key is not
   * // present in cache. Else it moves the key to
   * // front by first removing it and then adding
   * // it, and returns true.
   * 
   * 
   * public boolean get(int key)
   * {
   * if (!cache.contains(key))
   * return false;
   * cache.remove(key);
   * cache.add(key);
   * return true;
   * }
   * 
   * 
   * public void refer(int key)
   * {
   * if (get(key) == false)
   * put(key);
   * }
   * 
   * 
   * // displays contents of cache in Reverse Order
   * public void display()
   * {
   * LinkedList<Integer> list = new LinkedList<>(cache);
   * 
   * // The descendingIterator() method of java.util.LinkedList
   * // class is used to return an iterator over the elements
   * // in this LinkedList in reverse sequential order
   * Iterator<Integer> itr = list.descendingIterator();
   * 
   * while (itr.hasNext())
   * System.out.print(itr.next() + " ");
   * }
   * 
   * 
   * public void put(int key)
   * {
   * 
   * if (cache.size() == capacity) {
   * int firstKey = cache.iterator().next();
   * cache.remove(firstKey);
   * }
   * 
   * cache.add(key);
   * }
   * 
   * @param args
   */

  public static void main(String[] args) {
    SQ18 cache = new SQ18(4);
    cache.refer(1);
    cache.refer(2);
    cache.refer(3);
    cache.refer(1);
    cache.refer(4);
    cache.refer(5);
    cache.display();
  }
}
