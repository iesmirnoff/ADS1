package com.iesmirnoff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {

    @Test
    void test_get_non_existent() {
        String testKey = "key";
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(5, Integer.class);
        assertNull(dictionary.get(testKey));
    }

    @Test
    void test_get_existent() {
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(5, Integer.class);
        String testKey = "key";
        int testValue = 1;
        dictionary.put(testKey, testValue);
        assertEquals(testValue, dictionary.get(testKey));
    }

    @Test
    void test_is_key_non_existent() {
        String testKey = "key";
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(5, Integer.class);
        assertFalse(dictionary.isKey(testKey));
    }

    @Test
    void test_is_key_existent() {
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(5, Integer.class);
        String testKey = "key";
        int testValue = 1;
        dictionary.put(testKey, testValue);
        assertTrue(dictionary.isKey(testKey));
    }

    @Test
    void test_put_with_collision() {
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(5, Integer.class);
        String testKey1 = "key1";
        String testKey2 = "key2";
        int testValue1 = 1;
        int testValue2 = 2;
        int index = dictionary.hashFun(testKey2);
        dictionary.slots[index] = testKey1;
        dictionary.values[index] = testValue1;
        dictionary.put(testKey2, testValue2);
        assertTrue(dictionary.isKey(testKey1));
        assertTrue(dictionary.isKey(testKey2));
        assertEquals(testValue1, dictionary.get(testKey1));
        assertEquals(testValue2, dictionary.get(testKey2));
    }

    @Test
    void test_put_rewrite() {
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(5, Integer.class);
        String testKey = "key1";
        int testValue1 = 1;
        int testValue2 = 2;
        dictionary.put(testKey, testValue1);
        dictionary.put(testKey, testValue2);
        assertTrue(dictionary.isKey(testKey));
        assertEquals(testValue2, dictionary.get(testKey));
    }

    @Test
    void test_is_key_non_existent_in_not_empty() {
        NativeDictionary<Integer> dictionary = new NativeDictionary<>(5, Integer.class);
        String testKey1 = "key1";
        String testKey2 = "key2";
        String nonExistentKey = "nonExistentKey";
        int testValue1 = 1;
        int testValue2 = 2;
        dictionary.put(testKey1, testValue1);
        dictionary.put(testKey2, testValue2);
        assertTrue(dictionary.isKey(testKey1));
        assertTrue(dictionary.isKey(testKey2));
        assertEquals(testValue1, dictionary.get(testKey1));
        assertEquals(testValue2, dictionary.get(testKey2));
        assertFalse(dictionary.isKey(nonExistentKey));
    }

}