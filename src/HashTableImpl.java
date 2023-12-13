
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class  HashTableImpl<K, V> {

    List<LinkedList<Node<K, V>>> hashTable = new ArrayList<>();
    int capacity = 0;

    public HashTableImpl(int capacity) {
           this.capacity = capacity;
           init();
    }

    void init() {
        for (int i = 0; i < capacity; i++) {
            hashTable.add(new LinkedList<>());
        }
    }

    void put(Node<K, V> node) {

        int bucket = (node.getKey().hashCode()) % capacity;

        LinkedList<Node<K, V>> bucketList = hashTable.get(bucket);
        int index = -1;
        for (int i = 0; i < bucketList.size(); i++) {

            if (bucketList.get(i).getKey().equals(node.getKey())) {
                index = i;
                break;
            }

        }

        if (index > 0) {

            bucketList.remove(index);
            bucketList.add(index, node);
        }

        else {

            bucketList.add(node);
        }

    }

    Node<K, V> get(K key) {

        int bucket = (key.hashCode()) % capacity;

        LinkedList<Node<K, V>> bucketList = hashTable.get(bucket);

        List<Node<K, V>> found = bucketList.stream().filter(e -> e.getKey().equals(key))
                .collect(Collectors.toList());

        if (!found.isEmpty()) {

            return found.get(0);
        }

        else {

            return null;
        }


    }

    Node<K, V> remove(K key) {

        int bucket = (key.hashCode()) % capacity;

        LinkedList<Node<K, V>> bucketList = hashTable.get(bucket);

        List<Node<K, V>> found = bucketList.stream().filter(e -> e.getKey().equals(key))
                .collect(Collectors.toList());

        if (!found.isEmpty()) {

            Node<K, V> oldNode = found.get(0);

            bucketList.remove(oldNode);
            return oldNode;
        }

        else {

            return null;
        }

    }


}
