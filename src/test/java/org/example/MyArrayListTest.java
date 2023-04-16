package org.example;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyArrayListTest {

    @Test
    void testAddAndGet() {
        // Given
        MyArrayList<Integer> list = new MyArrayList<>();
        // When
        list.add(1);
        list.add(2);
        list.add(3);
        // Then
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testAddWithIndex() {
        // Given
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(3);
        // When
        list.add(1, 2);
        // Then
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testAddWithIndexEx() {
        // Given
        MyArrayList<Integer> list = new MyArrayList<>();
        // When
        list.add(0,2);
        // Then
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));

    }


    @Test
    void testRemove() {
        // Given
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // When
        list.remove(1);
        // Then
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    void testSet() {
        // Given
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        // When
        list.set(1, 3);
        // Then
        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
    void testSetEx() {
        // Given
        MyArrayList<Integer> list = new MyArrayList<>();
        // Then
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(5, 10));
    }

    @Test
    void testSize() {
        // Given
        MyArrayList<Integer> list = new MyArrayList<>();
        assertEquals(0, list.size());
        // When
        list.add(1);
        // Then
        assertEquals(1, list.size());
        // When
        list.add(2);
        // Then
        assertEquals(2, list.size());
    }

    @Test
    void testQuickSort() {
        // Given
        MyArrayList<Integer> list = new MyArrayList<>();
        // When
        list.addAll(5, 2, 7, 1, 8, 3);
        list.quickSort(0, list.size() - 1, Comparator.naturalOrder());
        // Then
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(5, list.get(3));
        assertEquals(7, list.get(4));
        assertEquals(8, list.get(5));
    }
}

