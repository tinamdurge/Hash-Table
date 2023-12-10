

/*
 * @name: MyMapNode
 * @desc: used to create a node for the hash table.
 */

public class MyMapNode<K, V> {
    K key;
    V value;

    public MyMapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
