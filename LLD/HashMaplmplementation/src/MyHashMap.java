import java.util.Map;

public class MyHashMap<K, V> {
    private static final int INITIAL_SIZE = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public Entry[] hashTable;

    public MyHashMap() {
        hashTable = new Entry[INITIAL_SIZE];
    }

    public MyHashMap(int capacity) {
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    public int tableSizeFor(int cap) {
        int n = cap - 1; // cap - 1 to handle the case when cap is a power of 2.
        // h ^ (h >>> 16) is used to spread the bits of the hash code across the table size, so we want to make sure that the table size is a power of 2.
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        if(node == null) {
            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        } else {
            Entry previousNote = node;
            while(node != null) {
                if(node.key == key) {
                    node.value = value;
                    return;
                }
                previousNote = node;
                node = node.next;
            }
            Entry newNode = new Entry(key, value);
            previousNote.next = newNode;
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        while (node != null) {
            if(node.key.equals(key)) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }
}


class Entry<K, V> {
    public K key;
    public V value;
    public Entry next;

    Entry(K k, V v) {
        key = k;
        value = v;
    }
}