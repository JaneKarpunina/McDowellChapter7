package hashtable_with_linkedLists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableImplTest {

    HashTableImpl<KeyForHashTableTest, String> hashTable;

    @BeforeEach
    void setUp() {

        hashTable = new HashTableImpl<>(10);

        hashTable.put(new Node<>(new KeyForHashTableTest("qwe"), "asdvhg"));
        hashTable.put(new Node<>(new KeyForHashTableTest("qWE"), "asdvhg1"));
        hashTable.put(new Node<>(new KeyForHashTableTest("qwE"), "asdvhg2"));

        hashTable.put(new Node<>(new KeyForHashTableTest("pqweF"), "asdvhgqwe"));
        hashTable.put(new Node<>(new KeyForHashTableTest("PqWEF"), "asdvhg1asd"));
        hashTable.put(new Node<>(new KeyForHashTableTest("pqwEf"), "asdvhg1asdf"));

        hashTable.put(new Node<>(new KeyForHashTableTest("abc"), "asd"));
        hashTable.put(new Node<>(new KeyForHashTableTest("bca"), "asdv"));
        hashTable.put(new Node<>(new KeyForHashTableTest("Cba"), "aasdf"));


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void put() {

        System.out.println("first: ");

        for (Node<KeyForHashTableTest, String> node :
                hashTable.hashTable.get(new KeyForHashTableTest("QwE").hashCode() % hashTable.capacity)) {
            System.out.println("node key: " + node.getKey().key + ", node value: " + node.getValue());
        }

        hashTable.put(new Node<>(new KeyForHashTableTest("QwE"), "asdvhg1"));
        assertEquals(hashTable.hashTable.get(new KeyForHashTableTest("QwE").hashCode() % hashTable.capacity)
                .size(), 4);

        System.out.println("second: ");

        for (Node<KeyForHashTableTest, String> node :
                hashTable.hashTable.get(new KeyForHashTableTest("QwE").hashCode() % hashTable.capacity)) {
            System.out.println("node key: " + node.getKey().key + ", node value: " + node.getValue());
        }

        hashTable.put(new Node<>(new KeyForHashTableTest("qWE"), "new"));
        assertEquals(hashTable.hashTable.get(new KeyForHashTableTest("QwE").hashCode() % hashTable.capacity)
                .size(), 4);

        System.out.println("third: ");

        for (Node<KeyForHashTableTest, String> node :
                hashTable.hashTable.get(new KeyForHashTableTest("QwE").hashCode() % hashTable.capacity)) {
            System.out.println("node key: " + node.getKey().key + ", node value: " + node.getValue());
        }


    }

    @Test
    void get() {

        Node<KeyForHashTableTest, String> node = hashTable.get(new KeyForHashTableTest("PqWEF"));
        assertEquals(node.getValue(), "asdvhg1asd");

        node = hashTable.get(new KeyForHashTableTest("pqweF"));
        assertEquals(node.getValue(), "asdvhgqwe");

        node = hashTable.get(new KeyForHashTableTest("abc"));
        assertEquals(node.getValue(), "asd");

        node = hashTable.get(new KeyForHashTableTest("Cba"));
        assertEquals(node.getValue(), "aasdf");

    }

    @Test
    void remove() {

        System.out.println("first: ");

        for (Node<KeyForHashTableTest, String> node :
                hashTable.hashTable.get(new KeyForHashTableTest("QwE").hashCode() % hashTable.capacity)) {
            System.out.println("node key: " + node.getKey().key + ", node value: " + node.getValue());
        }

        hashTable.remove(new KeyForHashTableTest("qwe"));
        assertEquals(hashTable.hashTable.get(new KeyForHashTableTest("QwE").hashCode() % hashTable.capacity)
                .size(), 2);

        System.out.println("second: ");

        for (Node<KeyForHashTableTest, String> node :
                hashTable.hashTable.get(new KeyForHashTableTest("QwE").hashCode() % hashTable.capacity)) {
            System.out.println("node key: " + node.getKey().key + ", node value: " + node.getValue());
        }

        hashTable.remove(new KeyForHashTableTest("qwE"));
        assertEquals(hashTable.hashTable.get(new KeyForHashTableTest("QwE").hashCode() % hashTable.capacity)
                .size(), 1);

        System.out.println("third: ");

        for (Node<KeyForHashTableTest, String> node :
                hashTable.hashTable.get(new KeyForHashTableTest("QwE").hashCode() % hashTable.capacity)) {
            System.out.println("node key: " + node.getKey().key + ", node value: " + node.getValue());
        }

    }
}