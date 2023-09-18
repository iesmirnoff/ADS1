package com.iesmirnoff;

import org.junit.jupiter.api.Test;

import static com.iesmirnoff.DynArray.INCREASE_FACTOR;
import static com.iesmirnoff.DynArray.MIN_SIZE;
import static org.junit.jupiter.api.Assertions.*;


class DynArrayTest {

    @Test
    void testMakeArray_test_capacity_not_less_than_MIN_SIZE() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);

        dynArray.makeArray(8);

        assertEquals(dynArray.capacity, MIN_SIZE);
    }

    @Test
    void testCopyingConstructor_test_array_filled_correctly_when_source_less_than_MIN_SIZE() {
        Integer[] testSourceArray = {1, 2, 3,};
        Integer[] testResultArray = {1, 2, 3, null, null, null, null, null, null, null, null, null, null, null, null, null};

        DynArray<Integer> dynArray = new DynArray<>(Integer.class, testSourceArray);

        assertArrayEquals(dynArray.array, testResultArray);
        assertEquals(dynArray.capacity, MIN_SIZE);
        assertEquals(dynArray.count, testSourceArray.length);
    }

    @Test
    void testCopyingConstructor_test_array_filled_correctly_when_source_more_than_MIN_SIZE() {
        Integer[] testSourceArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};

        DynArray<Integer> dynArray = new DynArray<>(Integer.class, testSourceArray);

        assertArrayEquals(dynArray.array, testSourceArray);
        assertEquals(dynArray.capacity, testSourceArray.length);
        assertEquals(dynArray.count, testSourceArray.length);
    }

    @Test
    void testMakeArray_test_array_shrinks_when_new_capacity_less_than_count_original_count_less_than_MIN_SIZE() {
        Integer[] testSourceArray = {1, 2, 3,};
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, testSourceArray);
        Integer[] testResultArray = {1, 2, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

        int newCapacity = 2;
        dynArray.makeArray(newCapacity);

        assertArrayEquals(dynArray.array, testResultArray);
        assertEquals(MIN_SIZE, dynArray.capacity);
        assertEquals(newCapacity, dynArray.count);
    }

    @Test
    void testMakeArray_test_array_does_not_change_when_new_capacity_more_than_count_and_less_than_MIN_SIZE() {
        Integer[] testSourceArray = {1, 2, 3,};
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, testSourceArray);
        Integer[] testResultArray = {1, 2, 3, null, null, null, null, null, null, null, null, null, null, null, null, null};

        assertArrayEquals(dynArray.array, testResultArray);
        int newCapacity = 4;
        dynArray.makeArray(newCapacity);

        assertArrayEquals(dynArray.array, testResultArray);
        assertEquals(MIN_SIZE, dynArray.capacity);
        assertEquals(testSourceArray.length, dynArray.count);
    }

    @Test
    void testMakeArray_test_array_filled_correctly_when_new_capacity_more_than_count_original_count_more_than_MIN_SIZE() {
        Integer[] testSourceArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, testSourceArray);
        Integer[] testResultArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, null};

        int newCapacity = testResultArray.length;
        dynArray.makeArray(newCapacity);

        assertArrayEquals(dynArray.array, testResultArray);
        assertEquals(newCapacity, dynArray.capacity);
        assertEquals(testSourceArray.length, dynArray.count);
    }

    @Test
    void testMakeArray_test_array_shrinks_when_new_capacity_less_than_count_original_count_more_than_MIN_SIZE() {
        Integer[] testSourceArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, testSourceArray);
        Integer[] testResultArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};

        int newCapacity = testResultArray.length;
        dynArray.makeArray(newCapacity);

        assertArrayEquals(dynArray.array, testResultArray);
        assertEquals(newCapacity, dynArray.capacity);
        assertEquals(testResultArray.length, dynArray.count);
    }

    @Test
    void testMakeArray_test_array_shrinks_when_new_capacity_less_than_MIN_SIZE_original_count_more_than_MIN_SIZE() {
        Integer[] testSourceArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, testSourceArray);
        Integer[] testResultArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, null};

        int newCapacity = 15;
        dynArray.makeArray(newCapacity);

        assertArrayEquals(dynArray.array, testResultArray);
        assertEquals(DynArray.MIN_SIZE, dynArray.capacity);
        assertEquals(newCapacity, dynArray.count);
    }

    @Test
    void testGetItem_test_exception_thrown_when_index_less_than_0() {
        Integer[] testSourceArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, testSourceArray);

        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.getItem(-1));
    }

    @Test
    void testGetItem_test_exception_thrown_when_index_equal_or_more_than_count() {
        Integer[] testSourceArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, testSourceArray);

        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.getItem(dynArray.count));
    }

    @Test
    void testGetItem_test_successful() {
        Integer[] testSourceArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, testSourceArray);

        int testValue = dynArray.getItem(3);

        assertEquals(4, testValue);
    }

    @Test
    void testAppend_test_append_to_empty() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);

        assertEquals(0, dynArray.count);
        assertEquals(MIN_SIZE, dynArray.array.length);
        assertEquals(MIN_SIZE, dynArray.capacity);
        Integer[] initArray = { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null };
        assertArrayEquals(initArray, dynArray.array);

        int testValue = 1;
        dynArray.append(testValue);

        Integer[] testArray = { testValue, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null };
        assertArrayEquals(testArray, dynArray.array);
        assertEquals(1, dynArray.count);
        assertEquals(MIN_SIZE, dynArray.capacity);
    }

    @Test
    void testAppend_test_append_to_not_empty_less_than_capacity() {
        Integer[] initArray = { 1, 2, 3 };
        Integer[] initResultArray = { 1, 2, 3, null, null, null, null, null, null, null, null, null, null, null, null, null };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        assertEquals(initArray.length, dynArray.count);
        assertEquals(MIN_SIZE, dynArray.array.length);
        assertEquals(MIN_SIZE, dynArray.capacity);
        assertArrayEquals(initResultArray, dynArray.array);

        int testValue = 4;
        dynArray.append(testValue);

        Integer[] testArray = { 1, 2, 3, testValue, null, null, null, null, null, null, null, null, null, null, null, null };
        assertArrayEquals(testArray, dynArray.array);
        assertEquals(4, dynArray.count);
        assertEquals(MIN_SIZE, dynArray.capacity);
    }

    @Test
    void testAppend_test_append_to_equal_to_capacity() {
        Integer[] initArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        int capacityBeforeAppend = MIN_SIZE;
        int countBeforeAppend = initArray.length;

        assertEquals(countBeforeAppend, dynArray.count);
        assertEquals(capacityBeforeAppend, dynArray.array.length);
        assertEquals(capacityBeforeAppend, dynArray.capacity);
        assertArrayEquals(initArray, dynArray.array);

        int testValue = 17;
        dynArray.append(testValue);

        Integer[] testArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, testValue,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null };
        assertArrayEquals(testArray, dynArray.array);
        assertEquals(capacityBeforeAppend * INCREASE_FACTOR, dynArray.capacity);
        assertEquals(countBeforeAppend + 1, dynArray.count);
    }

    @Test
    void testInsert_test_insert_to_empty_at_0_index() {
        DynArray<Integer> dynArray = new DynArray<>(Integer.class);
        int testValue = 1;

        dynArray.insert(testValue, 0);

        int countAfterInsert = 1;
        Integer[] arrayAfterInsert = { testValue, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null };
        assertArrayEquals(arrayAfterInsert, dynArray.array);
        assertEquals(countAfterInsert, dynArray.count);
        assertEquals(MIN_SIZE, dynArray.capacity);
    }

    @Test
    void testInsert_test_insert_to_not_empty_at_0_index_less_than_capacity() {
        Integer[] initArray = { 2, 3 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        int testValue = 1;
        int indexToInsert = 0;

        dynArray.insert(testValue, indexToInsert);

        int countAfterInsert = 3;
        Integer[] arrayAfterInsert = { testValue, 2, 3, null, null, null, null, null, null, null, null, null, null, null, null, null };
        assertArrayEquals(arrayAfterInsert, dynArray.array);
        assertEquals(countAfterInsert, dynArray.count);
        assertEquals(MIN_SIZE, dynArray.capacity);
    }

    @Test
    void testInsert_test_insert_to_not_empty_in_middle_less_than_capacity() {
        Integer[] initArray = { 1, 2, 4 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        int testValue = 3;
        int indexToInsert = 2;

        dynArray.insert(testValue, indexToInsert);

        int countAfterInsert = 4;
        Integer[] arrayAfterInsert = { 1, 2, testValue, 4, null, null, null, null, null, null, null, null, null, null, null, null };
        assertArrayEquals(arrayAfterInsert, dynArray.array);
        assertEquals(countAfterInsert, dynArray.count);
        assertEquals(MIN_SIZE, dynArray.capacity);
    }

    @Test
    void testInsert_test_insert_to_not_empty_at_last_index_less_than_capacity() {
        Integer[] initArray = { 1, 2, 3 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        int testValue = 3;
        int indexToInsert = 2;

        dynArray.insert(testValue, indexToInsert);

        int countAfterInsert = 4;
        Integer[] arrayAfterInsert = { 1, 2, 3, testValue, null, null, null, null, null, null, null, null, null, null, null, null };
        assertArrayEquals(arrayAfterInsert, dynArray.array);
        assertEquals(countAfterInsert, dynArray.count);
        assertEquals(MIN_SIZE, dynArray.capacity);
    }

    @Test
    void testInsert_test_insert_to_not_empty_after_last_index_less_than_capacity() {
        Integer[] initArray = { 1, 2, 3 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        int testValue = 4;
        int indexToInsert = dynArray.count;

        dynArray.insert(testValue, indexToInsert);

        int countAfterInsert = 4;
        Integer[] arrayAfterInsert = { 1, 2, 3, testValue, null, null, null, null, null, null, null, null, null, null, null, null };
        assertArrayEquals(arrayAfterInsert, dynArray.array);
        assertEquals(countAfterInsert, dynArray.count);
        assertEquals(MIN_SIZE, dynArray.capacity);
    }

    @Test
    void testInsert_test_insert_to_not_empty_at_0_index_count_equal_to_capacity() {
        Integer[] initArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        int testValue = 0;
        int indexToInsert = 0;

        dynArray.insert(testValue, indexToInsert);

        int countAfterInsert = 17;
        Integer[] arrayAfterInsert = { testValue, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null };
        assertArrayEquals(arrayAfterInsert, dynArray.array);
        assertEquals(countAfterInsert, dynArray.count);
        assertEquals(MIN_SIZE * INCREASE_FACTOR, dynArray.capacity);
    }

    @Test
    void testInsert_test_insert_to_not_empty_in_middle_count_equal_to_capacity() {
        Integer[] initArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        int testValue = 3;
        int indexToInsert = 2;

        dynArray.insert(testValue, indexToInsert);

        int countAfterInsert = 17;
        Integer[] arrayAfterInsert = { 1, 2, testValue, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null };
        assertArrayEquals(arrayAfterInsert, dynArray.array);
        assertEquals(countAfterInsert, dynArray.count);
        assertEquals(MIN_SIZE * INCREASE_FACTOR, dynArray.capacity);
    }

    @Test
    void testInsert_test_insert_to_not_empty_at_last_index_count_equal_to_capacity() {
        Integer[] initArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        int testValue = 16;
        int indexToInsert = 15;

        dynArray.insert(testValue, indexToInsert);

        int countAfterInsert = 17;
        Integer[] arrayAfterInsert = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, testValue,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null };
        assertArrayEquals(arrayAfterInsert, dynArray.array);
        assertEquals(countAfterInsert, dynArray.count);
        assertEquals(MIN_SIZE * INCREASE_FACTOR, dynArray.capacity);
    }

    @Test
    void testInsert_test_insert_to_not_empty_after_last_index_count_equal_to_capacity() {
        Integer[] initArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        int testValue = 17;
        int indexToInsert = dynArray.count;

        dynArray.insert(testValue, indexToInsert);

        int countAfterInsert = 17;
        Integer[] arrayAfterInsert = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, testValue,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null };
        assertArrayEquals(arrayAfterInsert, dynArray.array);
        assertEquals(countAfterInsert, dynArray.count);
        assertEquals(MIN_SIZE * INCREASE_FACTOR, dynArray.capacity);
    }

    @Test
    void testInsert_test_throws_exception_when_index_less_than_0() {
        Integer[] initArray = { 1, 2, 3 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.getItem(-1));
    }

    @Test
    void testInsert_test_throws_exception_when_index_after_count() {
        Integer[] initArray = { 1, 2, 3 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.getItem(dynArray.count + 1));
    }

    @Test
    void testRemove_test_throws_exception_when_index_less_than_0() {
        Integer[] initArray = { 1, 2, 3 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.remove(-1));
    }

    @Test
    void testRemove_test_throws_exception_when_index_more_than_count() {
        Integer[] initArray = { 1, 2, 3 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        assertThrows(IndexOutOfBoundsException.class, () -> dynArray.remove(dynArray.count));
    }

    @Test
    void testRemove_test_remove_first_count_less_than_MIN_SIZE() {
        Integer[] initArray = { 1, 2, 3 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        int indexToRemove = 0;
        dynArray.remove(indexToRemove);

        Integer[] arrayAfterRemove = { 2, 3, null, null, null, null, null, null, null, null, null, null, null, null, null, null };
        int countAfterRemove = 2;
        assertArrayEquals(arrayAfterRemove, dynArray.array);
        assertEquals(countAfterRemove, dynArray.count);
        assertEquals(MIN_SIZE, dynArray.capacity);
    }

    @Test
    void testRemove_test_remove_middle_count_less_than_MIN_SIZE() {
        Integer[] initArray = { 1, 2, 3 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        int indexToRemove = 1;
        dynArray.remove(indexToRemove);

        Integer[] arrayAfterRemove = { 1, 3, null, null, null, null, null, null, null, null, null, null, null, null, null, null };
        int countAfterRemove = 2;
        assertArrayEquals(arrayAfterRemove, dynArray.array);
        assertEquals(countAfterRemove, dynArray.count);
        assertEquals(MIN_SIZE, dynArray.capacity);
    }

    @Test
    void testRemove_test_remove_last_count_less_than_MIN_SIZE() {
        Integer[] initArray = { 1, 2, 3 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);

        int indexToRemove = 2;
        dynArray.remove(indexToRemove);

        Integer[] arrayAfterRemove = { 1, 2, null, null, null, null, null, null, null, null, null, null, null, null, null, null };
        int countAfterRemove = 2;
        assertArrayEquals(arrayAfterRemove, dynArray.array);
        assertEquals(countAfterRemove, dynArray.count);
        assertEquals(MIN_SIZE, dynArray.capacity);
    }

    @Test
    void testRemove_test_array_shrinks_correctly_when_result_capacity_more_than_MIN_SIZE() {
        Integer[] initArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);
        int capacityBeforeRemove = 27;
        dynArray.makeArray(capacityBeforeRemove);

        int indexToRemove = 1;
        dynArray.remove(indexToRemove);

        Integer[] arrayAfterRemove = { 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, null, null, null, null, null };
        int countAfterRemove = 13;
        int capacityAfterRemove = MIN_SIZE + 2;
        assertArrayEquals(arrayAfterRemove, dynArray.array);
        assertEquals(countAfterRemove, dynArray.count);
        assertEquals(capacityAfterRemove, dynArray.capacity);
    }

    @Test
    void testRemove_test_array_shrinks_correctly_when_result_capacity_less_than_MIN_SIZE() {
        Integer[] initArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        DynArray<Integer> dynArray = new DynArray<>(Integer.class, initArray);
        int capacityBeforeRemove = 21;
        dynArray.makeArray(capacityBeforeRemove);

        int indexToRemove = 1;
        dynArray.remove(indexToRemove);

        Integer[] arrayAfterRemove = { 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, null, null, null, null, null, null };
        int countAfterRemove = 10;
        assertArrayEquals(arrayAfterRemove, dynArray.array);
        assertEquals(countAfterRemove, dynArray.count);
        assertEquals(MIN_SIZE, dynArray.capacity);
    }
}