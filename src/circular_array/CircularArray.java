package circular_array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CircularArray<T> implements Iterable<T> {

    List<T> array;

    int capacity;

    int first;
    int last;

    int startIndex;
    int size;

    public CircularArray(int capacity) {
        this.capacity = capacity;
        array = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            array.add(null);
        }
    }

    void addFirst(T element) {
        if (size == capacity) {
            return;
        }
        array.remove(first);
        array.add(first, element);
        if (first != last || size == 0) {
            if (first > 0) {
                first--;
            } else {
                first = capacity - 1;
            }
        }
        else {
            startIndex = first;
        }
        if (size == 0) {
            last++;
        }

        size++;

    }

    void addLast(T element) {

        if (size == capacity) {
            return;
        }

        array.remove(last);
        array.add(last, element);

        if (last != first) {
            last++;
        }
        else {
            startIndex = first + 1;
        }
        size++;

    }

    T getFirst() {
       if (size == capacity) {
           return array.get(startIndex);
       }

       return array.get(first + 1);

    }

    T getLast() {
       if (size == capacity) {
           return array.get(startIndex - 1);
       }

       return array.get(last - 1);
    }

    T getAtIndex(int index) {

        if (index > capacity - 1) return null;

        if (size == capacity) {

            if (startIndex  + index < capacity) {
              return array.get(startIndex  + index);
            }
            else {
              return array.get(startIndex + index - capacity);
            }
        }

        if (first + 1 + index < capacity) {
           return array.get(first + 1 + index);
        }
        else {
            return array.get(first + 1 + index - capacity);
        }

    }

    void rotate(int index) {

        if (size == capacity) {
            startIndex = startIndex + index;

        }

        if (index % capacity + first < capacity) {
            first = first + index % capacity;

        }
        else {
            first = index % capacity + first - capacity;
        }

        if (index % capacity + last < capacity) {
            last = last + index  % capacity;

        }
        else {
            last = index % capacity + last - capacity;
        }

    }

    Integer size() {
        return size;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < capacity;
            }

            @Override
            public T next() {

                T nextElement = getAtIndex(currentIndex);
                //T nextElement = array.get(currentIndex);
                currentIndex++;
                return nextElement;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }


}
