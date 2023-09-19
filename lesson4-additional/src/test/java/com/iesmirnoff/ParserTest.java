package com.iesmirnoff;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void test_checkBrackets_with_closing_first() {
        String sequence = ")(";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_one_opening() {
        String sequence = "(";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_one_closing() {
        String sequence = ")";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_opening_first_one_eye() {
        String sequence = "(()";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_opening_last_one_eye() {
        String sequence = "()(";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_closing_last_one_eye() {
        String sequence = "())";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_opening_first_many_eyes_one_by_one() {
        String sequence = "(()()";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_opening_last_many_eyes_one_by_one() {
        String sequence = "()()(";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_closing_last_many_eyes_one_by_one() {
        String sequence = "()())";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_opening_many_eyes_bracket_between() {
        String sequence = "()(()";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_closing_many_eyes_bracket_between() {
        String sequence = "())()";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_closing_after_onion() {
        String sequence = "(()))";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_opening_after_onion() {
        String sequence = "(())(";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_opening_before_onion() {
        String sequence = "((())";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_opening_first_many_eyes_one_by_one_in_onion() {
        String sequence = "((()())";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_opening_last_many_eyes_one_by_one_in_onion() {
        String sequence = "(()()()";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_closing_last_many_eyes_one_by_one_in_onion() {
        String sequence = "(()()))";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_opening_many_eyes_bracket_between_in_onion() {
        String sequence = "(()(())";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_excess_closing_many_eyes_bracket_between_in_onion() {
        String sequence = "(())())";

        assertFalse(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_one_eye() {
        String sequence = "()";

        assertTrue(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_many_eyes() {
        String sequence = "()()";

        assertTrue(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_onion() {
        String sequence = "(())";

        assertTrue(Parser.checkBrackets(sequence));
    }

    @Test
    void test_checkBrackets_with_many_eyes_in_onion() {
        String sequence = "(()())";

        assertTrue(Parser.checkBrackets(sequence));
    }

    @Test
    void test_calculateExpression() {
        String expression = "8 2 + 5 * 9 + 1 - -116 / =";
        Integer result = Parser.calculateExpression(expression);
        assertEquals(2, result);
    }
}