import com.iesmirnoff.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StackTest {

    @Test
    void test_size_of_empty_stack() {
        Stack<Integer> stack = new Stack<>();

        assertEquals(0, stack.size());
    }

    @Test
    void test_size_of_not_empty_stack() {
        Integer[] testArray = new Integer[]{1, 2, 3};
        Stack<Integer> stack = new Stack<>(testArray);

        assertEquals(testArray.length, stack.size());
    }

    @Test
    void test_pop_from_empty_stack() {
        Stack<Integer> stack = new Stack<>();

        Integer poppedValue = stack.pop();

        assertNull(poppedValue);
    }

    @Test
    void test_pop_from_stack_of_one_element() {
        Integer[] testArray = new Integer[]{ 1 };
        Stack<Integer> stack = new Stack<>(testArray);

        Integer poppedValue = stack.pop();

        assertEquals(testArray[0], poppedValue);
        assertEquals(0, stack.size());
    }

    @Test
    void test_pop_from_stack_of_many_element() {
        Integer[] testArray = new Integer[]{ 1, 2 };
        Stack<Integer> stack = new Stack<>(testArray);

        Integer poppedValue = stack.pop();

        assertEquals(testArray[0], poppedValue);
        assertEquals(testArray.length - 1, stack.size());
    }

    @Test
    void test_push_to_empty_stack() {
        Stack<Integer> stack = new Stack<>();
        int pushedValue = 1;

        stack.push(pushedValue);

        assertEquals(1, stack.size());
        assertEquals(pushedValue, stack.pop());
    }

    @Test
    void test_push_to_not_empty_stack() {
        Integer[] testArray = new Integer[]{ 2 };
        Stack<Integer> stack = new Stack<>(testArray);
        int pushedValue = 1;

        stack.push(pushedValue);

        assertEquals(testArray.length + 1, stack.size());
        assertEquals(pushedValue, stack.pop());
    }

    @Test
    void test_peek_from_empty_stack() {
        Stack<Integer> stack = new Stack<>();

        Integer peekedValue = stack.peek();

        assertNull(peekedValue);
    }

    @Test
    void test_peek_from_not_empty_stack() {
        Integer[] testArray = new Integer[]{ 1, 2 };
        Stack<Integer> stack = new Stack<>(testArray);

        Integer peekedValue = stack.peek();

        assertEquals(testArray[0], peekedValue);
        assertEquals(testArray.length, stack.size());
    }
}