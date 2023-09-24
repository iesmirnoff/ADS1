package com.iesmirnoff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderedListTest {

    @Test
    void test_count_empty_list() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        assertEquals(0, orderedList.count());
    }

    @Test
    void test_count_one_element_list() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(2);
        assertEquals(1, orderedList.count());
    }

    @Test
    void test_count_many_elements_list() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(1);
        orderedList.add(2);
        assertEquals(2, orderedList.count());
    }

    @Test
    void test_add_to_empty() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        Integer testValue = 1;
        orderedList.add(testValue);
        assertEquals(1, orderedList.count());
        assertEquals(orderedList.head, orderedList.tail);
        assertEquals(testValue, orderedList.head.value);
    }

    @Test
    void test_add_to_not_empty_in_head_ascending() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(2);
        orderedList.add(3);
        Integer testValue = 1;
        orderedList.add(testValue);
        assertEquals(3, orderedList.count());
        assertEquals(testValue, orderedList.head.value);
    }

    @Test
    void test_add_to_not_empty_in_tail_ascending() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(1);
        orderedList.add(2);
        Integer testValue = 3;
        orderedList.add(testValue);
        assertEquals(3, orderedList.count());
        assertEquals(testValue, orderedList.tail.value);
    }

    @Test
    void test_add_to_not_empty_in_middle_ascending() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(1);
        orderedList.add(3);
        Integer testValue = 2;
        orderedList.add(testValue);
        assertEquals(3, orderedList.count());
        assertEquals(testValue, orderedList.head.next.value);
    }

    @Test
    void test_add_to_not_empty_in_head_descending() {
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        orderedList.add(2);
        orderedList.add(1);
        Integer testValue = 3;
        orderedList.add(testValue);
        assertEquals(3, orderedList.count());
        assertEquals(testValue, orderedList.head.value);
    }

    @Test
    void test_add_to_not_empty_in_tail_descending() {
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        orderedList.add(3);
        orderedList.add(2);
        Integer testValue = 1;
        orderedList.add(testValue);
        assertEquals(3, orderedList.count());
        assertEquals(testValue, orderedList.tail.value);
    }

    @Test
    void test_add_to_not_empty_in_middle_descending() {
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        orderedList.add(3);
        orderedList.add(1);
        Integer testValue = 2;
        orderedList.add(testValue);
        assertEquals(3, orderedList.count());
        assertEquals(testValue, orderedList.head.next.value);
    }

    @Test
    void delete_from_empty() {
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        orderedList.delete(1);
        assertNull(orderedList.head);
        assertNull(orderedList.tail);
    }

    @Test
    void delete_from_one() {
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        Integer testValue = 1;
        orderedList.add(testValue);
        orderedList.delete(testValue);
        assertNull(orderedList.head);
        assertNull(orderedList.tail);
    }

    @Test
    void test_delete_from_head_ascending() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.delete(1);
        assertEquals(1, orderedList.count());
        assertEquals(2, orderedList.head.value);
        assertEquals(2, orderedList.tail.value);
    }

    @Test
    void test_delete_from_tail_ascending() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.delete(2);
        assertEquals(1, orderedList.count());
        assertEquals(1, orderedList.head.value);
        assertEquals(1, orderedList.tail.value);
    }

    @Test
    void test_delete_from_middle_ascending() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);
        orderedList.delete(2);
        assertEquals(2, orderedList.count());
        assertEquals(1, orderedList.head.value);
        assertEquals(3, orderedList.tail.value);
    }

    @Test
    void test_delete_from_head_descending() {
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        orderedList.add(2);
        orderedList.add(1);
        orderedList.delete(2);
        assertEquals(1, orderedList.count());
        assertEquals(1, orderedList.head.value);
        assertEquals(1, orderedList.tail.value);
    }

    @Test
    void test_delete_from_tail_descending() {
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        orderedList.add(2);
        orderedList.add(1);
        orderedList.delete(1);
        assertEquals(1, orderedList.count());
        assertEquals(2, orderedList.head.value);
        assertEquals(2, orderedList.tail.value);
    }

    @Test
    void test_delete_from_middle_descending() {
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        orderedList.add(3);
        orderedList.add(2);
        orderedList.add(1);
        orderedList.delete(2);
        assertEquals(2, orderedList.count());
        assertEquals(3, orderedList.head.value);
        assertEquals(1, orderedList.tail.value);
    }

    @Test
    void test_find_in_empty() {
        OrderedList<Integer> orderedList = new OrderedList<>(false);
        assertNull(orderedList.find(1));
    }

    @Test
    void test_find_head() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);
        assertEquals(1, orderedList.find(1).value);
    }

    @Test
    void test_find_tail() {
        OrderedList<Integer> orderedList = new OrderedList<>(true);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);
        assertEquals(3, orderedList.find(3).value);
    }
}