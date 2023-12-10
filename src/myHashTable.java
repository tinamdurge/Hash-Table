import java.util.LinkedList;

public class myHashTable<K, V> {
    private LinkedList<MyMapNode<K, V>>[] buckets;
    private int size;

    /*
     * @name: myHashTable
     * @desc: constructor for the hash table.
     * @param: size - the size of the hash table.
     */
    public myHashTable(int size) {
        this.size = size;
        this.buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    /*
     * @name: getBucketIndex
     * @desc: gets the bucket index for a key.
     * @param: key - the key to get the bucket index for.
     * @return: the bucket index for the key.
     */

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % size;
    }

    /*
     * @name: get
     * @desc: gets the value for a key.
     * @param: key - the key to get the value for.
     * @return: the value for the key.
     */
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = buckets[index];
        for (MyMapNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null; // Key not found
    }

    /*
     * @name: put
     * @desc: puts a key-value pair into the hash table.
     * @param: key - the key to put into the hash table.
     * @param: value - the value to put into the hash table.
     */
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = buckets[index];
        for (MyMapNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                // Update existing key
                node.value = value;
                return;
            }
        }

        // Add new key-value pair
        bucket.add(new MyMapNode<>(key, value));
    }
    /*
     * @name: remove
     * @desc: removes a key-value pair from the hash table.
     * @param: key - the key to remove from the hash table.
     */
    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = buckets[bucketIndex];

        MyMapNode<K, V> toRemove = null;
        for (MyMapNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                toRemove = node;
                break;
            }
        }

        if (toRemove != null) {
            bucket.remove(toRemove);
        }
    }

    /*
     * @name: printHashTable
     * @desc: prints the hash table.
     */
    public void printHashTable() {
        for (int i = 0; i < size; i++) {
            LinkedList<MyMapNode<K, V>> bucket = buckets[i];
            System.out.print("Bucket " + i + ": ");
            for (MyMapNode<K, V> node : bucket) {
                System.out.print("(" + node.key + ", " + node.value + ") ");
            }
            System.out.println();
        }
    }
}
