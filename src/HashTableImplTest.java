import static org.junit.jupiter.api.Assertions.*;

class HashTableImplTest {

    HashTableImpl<KeyForHashTableTest, String> hashTable = new HashTableImpl<>(10);

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

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

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }
}