package com.iesmirnoff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void test_seek_slot_with_collisions_size_not_multiple_of_step() {
        int size = 7;
        String testValue = "test";
        HashTable hashTable = new HashTable(size, 3);
        int indexByHash = hashTable.hashFun(testValue);
        hashTable.slots[indexByHash] = testValue;
        for (int i = 0; i < size - 1; i++) {
            int newIndex = hashTable.seekSlot(testValue);
            hashTable.slots[newIndex] = testValue;
        }
        assertArrayEquals(new String[] { testValue, testValue, testValue, testValue, testValue, testValue, testValue, }, hashTable.slots);
    }

    @Test
    void test_seek_slot_with_collisions_size_multiple_of_step() {
        int size = 6;
        String testValue = "test";
        HashTable hashTable = new HashTable(size, 3);
        int indexByHash = hashTable.hashFun(testValue);
        hashTable.slots[indexByHash] = testValue;
        for (int i = 0; i < size - 1; i++) {
            int newIndex = hashTable.seekSlot(testValue);
            hashTable.slots[newIndex] = testValue;
        }
        assertArrayEquals(new String[] { testValue, testValue, testValue, testValue, testValue, testValue, }, hashTable.slots);
    }

    @Test
    void test_seek_slot_with_collisions_when_no_free_slots() {
        String testValue = "test";
        HashTable hashTable = new HashTable(2, 1);
        hashTable.slots[0] = testValue;
        hashTable.slots[1] = testValue;
        assertEquals(-1, hashTable.seekSlot(testValue));
    }

    @Test
    void test_put_in_one_element_empty() {
        HashTable hashTable = new HashTable(1, 1);
        String testValue = "test";
        hashTable.put(testValue);
        assertArrayEquals(new String[] { testValue, }, hashTable.slots);
    }

    @Test
    void test_put_in_many_elements_empty() {
        HashTable hashTable = new HashTable(2, 1);
        String testValue = "test";
        int index = hashTable.put(testValue);
        String[] result = new String[2];
        result[index] = testValue;
        assertArrayEquals(result, hashTable.slots);
    }

    @Test
    void test_put_in_many_elements_full() {
        HashTable hashTable = new HashTable(2, 1);
        String testValue = "test";
        hashTable.put(testValue);
        hashTable.put(testValue);
        int index = hashTable.put(testValue);
        assertEquals(-1, index);
    }

    @Test
    void test_find_in_empty() {
        HashTable hashTable = new HashTable(2, 1);
        String testValue = "test";
        assertEquals(-1, hashTable.find(testValue));
    }

    @Test
    void test_find_success() {
        HashTable hashTable = new HashTable(2, 1);
        String testValue = "test";
        int index = hashTable.put(testValue);
        assertEquals(index, hashTable.find(testValue));
    }
}