import java.util.Objects;

public class KeyForHashTableTest {

    String key;

    public KeyForHashTableTest(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyForHashTableTest)) return false;
        KeyForHashTableTest that = (KeyForHashTableTest) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key.toLowerCase());
    }
}
