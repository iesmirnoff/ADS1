package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {

    @Test
    void test_is_value() {
        String[] strings = new String[] { "0123456789", "1234567890", "2345678901", "3456789012", "4567890123",
                "5678901234", "6789012345", "7890123456", "8901234567", "9012345678" };
        BloomFilter bloomFilter = new BloomFilter(32);
        for (String string : strings) {
            bloomFilter.add(string);
        }
        for (String string : strings) {
            assertTrue(bloomFilter.isValue(string));
        }
    }

    @Test
    void test_is_not_value() {
        String[] strings = new String[] { "0123456789", "1234567890", "2345678901", "3456789012", "4567890123",
                "5678901234", "6789012345", "7890123456", "8901234567", "9012345678" };
        BloomFilter bloomFilter = new BloomFilter(32);
        for (String string : strings) {
            assertFalse(bloomFilter.isValue(string));
        }
    }
}