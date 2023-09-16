package com.iesmirnoff;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedList2Test {

    @Test
    void testCounting() {
        LinkedList2 list = new LinkedList2();
        assertEquals(list.count(), 0);

        list.addInTail(new Node(5));
        assertEquals(list.count(), 1);

        list.addInTail(new Node(7));
        assertEquals(list.count(), 2);
    }

    @Test
    void testSuccessfulFindingInOne() {
        LinkedList2 list = new LinkedList2();
        int testValue = 1;
        Node testNode = new Node(testValue);
        list.addInTail(testNode);

        Node foundNode = list.find(testValue);

        assertEquals(testNode, foundNode);
    }

    @Test
    void testSuccessfulFindingHeadInMany() {
        LinkedList2 list = new LinkedList2();
        int headValue = 1;
        int tailValue = 2;
        Node testNode = new Node(headValue);
        list.addInTail(testNode);
        list.addInTail(new Node(tailValue));

        Node foundNode = list.find(headValue);

        assertEquals(testNode, foundNode);
    }

    @Test
    void testSuccessfulFindingTailInMany() {
        LinkedList2 list = new LinkedList2();
        int headValue = 1;
        int tailValue = 2;
        list.addInTail(new Node(headValue));
        Node testNode = new Node(tailValue);
        list.addInTail(testNode);

        Node foundNode = list.find(tailValue);

        assertEquals(testNode, foundNode);
    }

    @Test
    void testSuccessfulFindingMiddleInMany() {
        LinkedList2 list = new LinkedList2();
        int headValue = 1;
        int middleValue = 2;
        int tailValue = 3;
        list.addInTail(new Node(headValue));
        Node testNode = new Node(middleValue);
        list.addInTail(testNode);
        list.addInTail(new Node(tailValue));

        Node foundNode = list.find(middleValue);

        assertEquals(testNode, foundNode);
    }

    @Test
    void testUnsuccessfulFindingInMany() {
        LinkedList2 list = new LinkedList2();
        int headValue = 1;
        int middleValue = 2;
        int tailValue = 3;
        list.addInTail(new Node(headValue));
        list.addInTail(new Node(middleValue));
        list.addInTail(new Node(tailValue));

        int valueNotInList = 4;
        Node foundNode = list.find(valueNotInList);

        assertNull(foundNode);
    }

    @Test
    void testUnsuccessfulFindingInEmpty() {
        LinkedList2 list = new LinkedList2();

        int valueNotInList = 1;
        Node foundNode = list.find(valueNotInList);

        assertNull(foundNode);
    }

    @Test
    void testFindingAllInEmptyList() {
        LinkedList2 list = new LinkedList2();
        int anyValue = 1;

        ArrayList<Node> found = list.findAll(anyValue);

        assertEquals(found.size(), 0);
    }

    @Test
    void testSuccessfulFindingAllInOneNodeList() {
        LinkedList2 list = new LinkedList2();
        int testValue = 1;
        list.addInTail(new Node(testValue));

        ArrayList<Node> found = list.findAll(testValue);

        assertEquals(found.get(0).value, testValue);
    }

    @Test
    void testUnsuccessfulFindingAllInOneNodeList() {
        LinkedList2 list = new LinkedList2();
        int testValue = 2;
        list.addInTail(new Node(testValue));

        int valueNotInList = 1;
        ArrayList<Node> found = list.findAll(valueNotInList);

        assertEquals(found.size(), 0);
    }

    @Test
    void testUnsuccessfulFindingAllInMany() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));

        int valueNotInList = 1;
        ArrayList<Node> found = list.findAll(valueNotInList);

        assertEquals(found.size(), 0);
    }

    @Test
    void testSuccessfulFindingOneNodeInMany() {
        LinkedList2 list = new LinkedList2();
        int testValue = 1;
        list.addInTail(new Node(testValue));
        list.addInTail(new Node(2));

        ArrayList<Node> found = list.findAll(testValue);

        assertEquals(found.get(0).value, testValue);
    }

    @Test
    void testSuccessfulFindingAllInMany() {
        LinkedList2 list = new LinkedList2();
        int testValue = 1;
        list.addInTail(new Node(testValue));
        list.addInTail(new Node(2));
        list.addInTail(new Node(testValue));

        ArrayList<Node> found = list.findAll(testValue);

        assertEquals(found.get(0).value, testValue);
        assertEquals(found.get(1).value, testValue);
    }

    @Test
    void testRemovingOneValueFromEmptyList() {
        LinkedList2 list = new LinkedList2();

        boolean removed = list.remove(1);

        assertNull(list.head);
        assertNull(list.tail);
        assertFalse(removed);
        assertEquals(list.count(), 0);
    }

    @Test
    void testSuccessfulRemovingOneValueFromOneElementList() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));

        boolean removed = list.remove(1);

        assertNull(list.head);
        assertNull(list.tail);
        assertTrue(removed);
        assertEquals(list.count(), 0);
    }

    @Test
    void testUnsuccessfulRemovingOneValueFromOneElementList() {
        LinkedList2 list = new LinkedList2();
        int headValue = 1;
        list.addInTail(new Node(headValue));
        int valueNotInList = 2;

        boolean removed = list.remove(valueNotInList);

        assertNull(list.find(valueNotInList));
        assertEquals(list.head, list.tail);
        assertEquals(list.head.value, headValue);
        assertFalse(removed);
        assertEquals(list.count(), 1);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void testRemovingHeadOneValueFromTwoElementsList() {
        LinkedList2 list = new LinkedList2();
        int headValue = 1;
        int tailValue = 2;
        list.addInTail(new Node(headValue));
        list.addInTail(new Node(tailValue));

        boolean removed = list.remove(headValue);

        assertNull(list.find(headValue));
        assertEquals(list.head, list.tail);
        assertEquals(list.head.value, tailValue);
        assertTrue(removed);
        assertEquals(list.count(), 1);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void testRemovingTailFromTwoElementsList() {
        LinkedList2 list = new LinkedList2();
        int headValue = 1;
        int tailValue = 2;
        list.addInTail(new Node(headValue));
        list.addInTail(new Node(tailValue));

        boolean removed = list.remove(tailValue);

        assertEquals(list.head, list.tail);
        assertEquals(list.head.value, headValue);
        assertNull(list.find(tailValue));
        assertTrue(removed);
        assertEquals(list.count(), 1);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void testSuccessfulRemovingOneValueInMiddleFromManyElementsList() {
        LinkedList2 list = new LinkedList2();
        int headValue = 1;
        int middleValue = 2;
        int tailValue = 3;
        list.addInTail(new Node(headValue));
        list.addInTail(new Node(middleValue));
        list.addInTail(new Node(tailValue));

        boolean removed = list.remove(middleValue);

        assertEquals(list.head.value, headValue);
        assertNull(list.find(middleValue));
        assertEquals(list.tail.value, tailValue);
        assertEquals(list.count(), 2);
        assertTrue(removed);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void testSuccessfulRemovingHeadFromManyElementsList() {
        LinkedList2 list = new LinkedList2();
        int headValue = 1;
        int middleValue = 2;
        int tailValue = 3;
        list.addInTail(new Node(headValue));
        list.addInTail(new Node(middleValue));
        list.addInTail(new Node(tailValue));

        boolean removed = list.remove(headValue);

        assertNull(list.find(headValue));
        assertEquals(list.head.value, middleValue);
        assertEquals(list.tail.value, tailValue);
        assertEquals(list.count(), 2);
        assertTrue(removed);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void testSuccessfulRemovingTailFromManyElementsList() {
        LinkedList2 list = new LinkedList2();
        int headValue = 1;
        int middleValue = 2;
        int tailValue = 3;
        list.addInTail(new Node(headValue));
        list.addInTail(new Node(middleValue));
        list.addInTail(new Node(tailValue));

        boolean removed = list.remove(tailValue);

        assertEquals(list.head.value, headValue);
        assertEquals(list.tail.value, middleValue);
        assertNull(list.find(tailValue));
        assertEquals(list.count(), 2);
        assertTrue(removed);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void testUnsuccessfulRemovingOneValueFromManyElementsList() {
        LinkedList2 list = new LinkedList2();
        int headValue = 1;
        int middleValue = 2;
        int tailValue = 3;
        list.addInTail(new Node(headValue));
        list.addInTail(new Node(middleValue));
        list.addInTail(new Node(tailValue));
        int valueNotInList = 10;

        boolean removed = list.remove(valueNotInList);
        assertEquals(list.head.value, headValue);
        assertEquals(list.tail.value, tailValue);
        assertEquals(list.count(), 3);
        assertFalse(removed);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void testSuccessfulRemovingHeadAndTailInMany() {
        LinkedList2 list = new LinkedList2();
        int testValue = 1;
        list.addInTail(new Node(testValue));
        list.addInTail(new Node(2));
        list.addInTail(new Node(testValue));

        list.removeAll(testValue);

        assertEquals(list.count(), 1);
        assertNull(list.find(testValue));
        assertEquals(list.head.value, 2);
        assertEquals(list.tail.value, 2);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void testSuccessfulRemovingMiddleInMany() {
        LinkedList2 list = new LinkedList2();
        int testValue = 2;
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));

        list.removeAll(testValue);

        assertNull(list.find(testValue));
        assertEquals(list.count(), 2);
        assertEquals(list.head.value, 1);
        assertEquals(list.tail.value, 3);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void testSuccessfulRemovingAllNodesInMany() {
        LinkedList2 list = new LinkedList2();
        int testValue = 1;
        list.addInTail(new Node(testValue));
        list.addInTail(new Node(testValue));
        list.addInTail(new Node(testValue));

        list.removeAll(testValue);

        assertEquals(list.count(), 0);
    }

    @Test
    void testUnsuccessfulRemovingManyInMany() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.removeAll(4);
        assertEquals(list.count(), 3);
        assertNull(list.head.prev);
        assertNull(list.tail.next);
    }

    @Test
    void testInsertAfterHeadInMiddle() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));

        Node nodeToInsert = new Node(4);
        list.insertAfter(list.head, nodeToInsert);

        assertEquals(list.count(), 4);
        assertEquals(list.head.next.value, 4);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void testInsertBeforeHead() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));

        Node nodeToInsert = new Node(4);
        list.insertAfter(null, nodeToInsert);

        assertEquals(list.count(), 4);
        assertEquals(list.head.value, 4);
        assertEquals(list.head.next.value, 1);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void testInsertAfterTail() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        Node tail = new Node(3);
        list.addInTail(tail);

        Node nodeToInsert = new Node(4);
        list.insertAfter(tail, nodeToInsert);

        assertEquals(list.count(), 4);
        assertEquals(list.tail.value, 4);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }

    @Test
    void testInsertInEmptyList() {
        LinkedList2 list = new LinkedList2();
        int testValue = 1;
        Node nodeToInsert = new Node(testValue);

        list.insertAfter(null, nodeToInsert);

        assertEquals(list.count(), 1);
        assertEquals(list.tail.value, testValue);
        assertEquals(list.head.value, testValue);
        assertNull(list.tail.next);
        assertNull(list.head.prev);
    }
}