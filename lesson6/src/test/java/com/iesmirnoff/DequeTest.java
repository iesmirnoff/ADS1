package com.iesmirnoff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    void test_size_of_empty_deque() {
        Deque<Integer> deque = new Deque<>();

        assertEquals(0, deque.size());
    }

    @Test
    void test_size_of_not_empty_deque() {
        Deque<Integer> deque = new Deque<>(new Integer[] { 1 });

        assertEquals(1, deque.size());
    }

    @Test
    void test_remove_front_from_empty() {
        Deque<Integer> deque = new Deque<>();

        assertNull(deque.removeFront());
    }

    @Test
    void test_remove_tail_from_empty() {
        Deque<Integer> deque = new Deque<>();

        assertNull(deque.removeTail());
    }

    @Test
    void test_add_to_front_to_empty() {

        Deque<Integer> deque = new Deque<>();
        int testValue = 1;

        deque.addFront(testValue);

        assertEquals(1, deque.size());
        assertEquals(testValue, deque.removeFront());
    }

    @Test
    void test_add_to_tail_to_empty() {

        Deque<Integer> deque = new Deque<>();
        int testValue = 1;

        deque.addTail(testValue);

        assertEquals(1, deque.size());
        assertEquals(testValue, deque.removeFront());
    }

    @Test
    void test_add_to_front_to_not_empty() {

        Deque<Integer> deque = new Deque<>(new Integer[] { 1 });
        int testValue = 2;

        deque.addFront(testValue);

        assertEquals(2, deque.size());
        assertEquals(testValue, deque.removeFront());
    }

    @Test
    void test_add_to_tail_to_not_empty() {

        Deque<Integer> deque = new Deque<>(new Integer[] { 1 });
        int testValue = 2;

        deque.addTail(testValue);

        assertEquals(2, deque.size());
        assertEquals(testValue, deque.removeTail());
    }

    @Test
    void test_add_to_front_remove_tail_of_not_empty() {

        int testValue = 2;
        Deque<Integer> deque = new Deque<>(new Integer[] { testValue });

        deque.addFront(1);

        assertEquals(2, deque.size());
        assertEquals(testValue, deque.removeTail());
    }

    @Test
    void test_add_to_tail_remove_front_of_not_empty() {

        int testValue = 1;
        Deque<Integer> deque = new Deque<>(new Integer[] { testValue });

        deque.addTail(2);

        assertEquals(2, deque.size());
        assertEquals(testValue, deque.removeFront());
    }

    @Test
    void test_palindrome_with_even_length() {
        Deque<Integer> deque = new Deque<>(new Integer[] { 1, 1 });

        assertTrue(deque.checkPalindrome());
    }

    @Test
    void test_not_palindrome_with_even_length() {
        Deque<Integer> deque = new Deque<>(new Integer[] { 1, 2 });

        assertFalse(deque.checkPalindrome());
    }

    @Test
    void test_not_palindrome_with_odd_length() {
        Deque<Integer> deque = new Deque<>(new Integer[] { 1, 2, 3 });

        assertFalse(deque.checkPalindrome());
    }

    @Test
    void test_palindrome_with_even_length_null_values() {
        Deque<Integer> deque = new Deque<>(new Integer[] { null, null });

        assertTrue(deque.checkPalindrome());
    }

    @Test
    void test_not_palindrome_with_even_length_null_values() {
        Deque<Integer> deque = new Deque<>(new Integer[] { 1, null });

        assertFalse(deque.checkPalindrome());
    }

    @Test
    void test_not_palindrome_with_odd_length_null_values() {
        Deque<Integer> deque = new Deque<>(new Integer[] { 1, 2, null });

        assertFalse(deque.checkPalindrome());
    }

    @Test
    void test_palindrome_with_odd_length() {
        Deque<Integer> deque = new Deque<>(new Integer[] { 1, 2, 1 });

        assertTrue(deque.checkPalindrome());
    }

    @Test
    void test_palindrome_with_odd_length_null_values() {
        Deque<Integer> deque = new Deque<>(new Integer[] { null, 2, null });

        assertTrue(deque.checkPalindrome());
    }
}