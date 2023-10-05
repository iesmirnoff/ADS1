package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeCacheTest {

    @Test
    void test_displacement_many_collisions() {
        NativeCache<Integer> cache = new NativeCache<>(100, Integer.class);
        String testKey = "test key";
        Integer testValue = 1;
        for (int i = 0; i < 100; i++) {
            cache.put(testKey, testValue);
        }
        int counter = 0;
        for (int i = 0; i < cache.values.length; i++) {
            if (testValue.equals(cache.values[i])) {
                counter++;
            }
        }
        assertEquals(1, counter);
    }

    @Test
    void test_get_count() {
        NativeCache<Integer> cache = new NativeCache<>(100, Integer.class);
        String testKey = "test key";
        Integer testValue = 1;
        int testIndex = cache.put(testKey, testValue);
        int testCount = 100;
        for (int i = 0; i < testCount; i++) {
            cache.get(testKey);
        }
        assertEquals(testCount + 1, cache.hits[testIndex]);
    }
}