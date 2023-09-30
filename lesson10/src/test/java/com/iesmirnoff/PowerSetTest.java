package com.iesmirnoff;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {

    @Test
    void test_add_non_existent() {
        PowerSet set = new PowerSet();
        String testValue = "testValue";
        set.put(testValue);
        long count = Arrays.stream(set.slots).filter(Predicate.isEqual(testValue)).count();
        assertEquals(1, count);
    }

    @Test
    void test_add_existent() {
        PowerSet set = new PowerSet();
        String testValue = "testValue";
        set.put(testValue);
        set.put(testValue);
        long count = Arrays.stream(set.slots).filter(Predicate.isEqual(testValue)).count();
        assertEquals(1, count);
    }

    @Test
    void test_remove_non_existent() {
        PowerSet set = new PowerSet();
        String testValue = "testValue";
        assertFalse(set.remove(testValue));
    }

    @Test
    void test_remove_existent() {
        PowerSet set = new PowerSet();
        String testValue = "testValue";
        set.put(testValue);
        assertTrue(set.remove(testValue));
    }

    @Test
    void test_empty_intersection() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        String testValue1 = "testValue1";
        String testValue2 = "testValue2";
        set1.put(testValue1);
        set2.put(testValue2);
        assertEquals(0, set1.intersection(set2).size());
    }

    @Test
    void test_not_empty_intersection() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        String testValue1 = "testValue1";
        String testValue2 = "testValue2";
        set1.put(testValue1);
        set1.put(testValue2);
        set2.put(testValue2);
        assertEquals(1, set1.intersection(set2).size());
        assertTrue(set1.intersection(set2).get(testValue2));
    }

    @Test
    void test_empty_union() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        assertEquals(0, set1.union(set2).size());
    }

    @Test
    void test_not_empty_union() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        String testValue1 = "testValue1";
        String testValue2 = "testValue2";
        set1.put(testValue1);
        set2.put(testValue2);
        assertEquals(2, set1.union(set2).size());
        assertTrue(set1.union(set2).get(testValue1));
        assertTrue(set1.union(set2).get(testValue2));
    }

    @Test
    void test_empty_difference() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        String testValue1 = "testValue1";
        set1.put(testValue1);
        set2.put(testValue1);
        assertEquals(0, set1.difference(set2).size());
    }

    @Test
    void test_not_empty_difference() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        String testValue1 = "testValue1";
        String testValue2 = "testValue2";
        set1.put(testValue1);
        set1.put(testValue2);
        set2.put(testValue1);
        assertEquals(1, set1.difference(set2).size());
        assertTrue(set1.difference(set2).get(testValue2));
    }

    @Test
    void test_get_existent_from_not_empty() {
        PowerSet set = new PowerSet();
        String testValue1 = "testValue1";
        String testValue2 = "testValue2";
        set.put(testValue1);
        set.put(testValue2);
        assertTrue(set.get(testValue1));
    }

    @Test
    void test_get_non_existent_from_not_empty() {
        PowerSet set = new PowerSet();
        String testValue1 = "testValue1";
        String testValue2 = "testValue2";
        set.put(testValue1);
        assertTrue(set.get(testValue1));
        assertFalse(set.get(testValue2));
    }

    @Test
    void test_performance() {
        PowerSet set1 = new PowerSet();
        PowerSet set2 = new PowerSet();
        for (int i = 0; i < 20000; i++) {
            set1.put(String.valueOf(i));
        }
        for (int i = 0; i < 20000; i++) {
            set2.put(String.valueOf(i));
        }
        long timeBefore = System.currentTimeMillis();
        set1.intersection(set2);
        long timeAfter = System.currentTimeMillis();
        assertTrue(timeAfter - timeBefore < 2000);

        timeBefore = System.currentTimeMillis();
        set1.union(set2);
        timeAfter = System.currentTimeMillis();
        assertTrue(timeAfter - timeBefore < 2000);

        timeBefore = System.currentTimeMillis();
        set1.isSubset(set2);
        timeAfter = System.currentTimeMillis();
        assertTrue(timeAfter - timeBefore < 2000);

        timeBefore = System.currentTimeMillis();
        set1.difference(set2);
        timeAfter = System.currentTimeMillis();
        assertTrue(timeAfter - timeBefore < 2000);
    }

    @Test
    void test_get_existent_from_10000() {
        PowerSet set = new PowerSet();
        for (int i = 0; i < 10000; i++) {
            String value = String.format("testValue%s", i);
            set.put(value);
        }
        for (int i = 0; i < 10000; i++) {
            boolean exist = set.get(String.format("testValue%s", i));
            assertTrue(exist);
        }
    }
}