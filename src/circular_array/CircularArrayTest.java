package circular_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularArrayTest {

    CircularArray<Integer> circularArray;

    @BeforeEach
    void beforeEach() {
        circularArray = new CircularArray<>(10);
        circularArray.addFirst(1);
        circularArray.addFirst(5);
        circularArray.addFirst(3);

    }

    @Test
    void addFirst() {

        //CircularArray<Integer> circularArray = new CircularArray<>(10);
        circularArray.addFirst(1);
        circularArray.addFirst(5);
        circularArray.addFirst(3);
        assertEquals(6, circularArray.size());
        assertEquals(4, circularArray.first);
        System.out.println("iterate: ");
        for(Integer number : circularArray) {
            System.out.println(number);
        }
    }

    @Test
    void addLast() {

        circularArray.addLast(6);
        circularArray.addLast(5);
        assertEquals(5, circularArray.size());
        assertEquals(7, circularArray.first);
        assertEquals(3, circularArray.last);
        System.out.println("iterate: ");
        for(Integer number : circularArray) {
            System.out.println(number);
        }
    }

    @Test
    void getFirst() {

        assertEquals(3, circularArray.size());
        assertEquals(7, circularArray.first);
        assertEquals(3, circularArray.getFirst());

        System.out.println("iterate: ");
        for(Integer number : circularArray) {
            System.out.println(number);
        }

    }

    @Test
    void getLast() {

        assertEquals(3, circularArray.size());
        assertEquals(1, circularArray.last);
        assertEquals(1, circularArray.getLast());


        circularArray.addLast(6);
        circularArray.addLast(5);

        assertEquals(3, circularArray.last);
        assertEquals(5, circularArray.getLast());

        System.out.println("iterate: ");
        for(Integer number : circularArray) {
            System.out.println(number);
        }
    }

    @Test
    void getAtIndex() {

        circularArray.addLast(6);
        circularArray.addLast(5);

        assertEquals(3, circularArray.getAtIndex(0));
        assertEquals(5, circularArray.getAtIndex(1));

        assertEquals(6, circularArray.getAtIndex(3));
        assertEquals(5, circularArray.getAtIndex(4));
    }

    @Test
    void rotate() {

        circularArray.addLast(6);
        circularArray.addLast(5);

        System.out.println("iterate: ");
        for(Integer number : circularArray) {
            System.out.println(number);
        }

        assertEquals(7, circularArray.first);

        circularArray.rotate(3);

        System.out.println("iterate after rotation: ");
        for(Integer number : circularArray) {
            System.out.println(number);
        }

        assertEquals(0, circularArray.first);

        circularArray.addFirst(5);
        circularArray.addFirst(3);

        System.out.println("iterate after adding elements: ");
        for(Integer number : circularArray) {
            System.out.println(number);
        }

        assertEquals(8, circularArray.first);

    }
}