package com.iesmirnoff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

class QueueTest {

    @Test
    void test_size_of_empty() {
        Queue<Integer> queue = new Queue<>();
        assertEquals(0, queue.size());
    }

    @Test
    void test_enqueue_to_empty() {
        Queue<Integer> queue = new Queue<>();
        int testValue = 1;
        queue.enqueue(testValue);
        assertEquals(1, queue.size());
        assertEquals(testValue, queue.dequeue());
    }

    @Test
    void test_dequeue_from_empty() {
        Queue<Integer> queue = new Queue<>();
        Integer testValue = queue.dequeue();
        assertEquals(0, queue.size());
        assertNull(testValue);
    }

    @Test
    void test_size_after_dequeue_from_one_element() {
        Queue<Integer> queue = new Queue<>();
        Integer testValue = 1;
        queue.enqueue(testValue);

        queue.dequeue();

        assertEquals(0, queue.size());
    }

    @Test
    void test_enqueue_to_not_empty() {
        Queue<Integer> queue = new Queue<>();
        int testValue1 = 1;
        int testValue2 = 2;
        queue.enqueue(testValue1);
        queue.enqueue(testValue2);
        assertEquals(2, queue.size());
        assertEquals(testValue1, queue.dequeue());
    }

    @Test
    void test_rotate_empty() {
        Queue<Integer> queue = new Queue<>();
        int rotateQuantity = 5;
        queue.rotate(rotateQuantity);
        assertEquals(0, queue.size());
        assertNull(queue.dequeue());
    }

    @Test
    void test_rotate_one_element() {
        Queue<Integer> queue = new Queue<>();
        int rotateQuantity = 1;
        int testValue = 1;
        queue.enqueue(testValue);
        queue.rotate(rotateQuantity);
        assertEquals(1, queue.size());
        assertEquals(testValue, queue.dequeue());
    }

    @Test
    void test_rotate_many_element() {
        int testValue1 = 1;
        int rotateQuantity = 3;
        Queue<Integer> queue = new Queue<>(new Integer[] { testValue1, 4, 3, 2});
        queue.rotate(rotateQuantity);
        assertEquals(4, queue.size());
        assertEquals(testValue1, queue.dequeue());
    }
}