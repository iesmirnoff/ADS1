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
        int testValue1 = 1;
        int testValue2 = 2;
        Node testNode = new Node(testValue1);
        list.addInTail(testNode);
        list.addInTail(new Node(testValue2));

        Node foundNode = list.find(testValue1);

        assertEquals(testNode, foundNode);
    }

    @Test
    void testSuccessfulFindingTailInMany() {
        LinkedList2 list = new LinkedList2();
        int testValue1 = 1;
        int testValue2 = 2;
        list.addInTail(new Node(testValue1));
        Node testNode = new Node(testValue2);
        list.addInTail(testNode);

        Node foundNode = list.find(testValue2);

        assertEquals(testNode, foundNode);
    }

    @Test
    void testSuccessfulFindingMiddleInMany() {
        LinkedList2 list = new LinkedList2();
        int testValue1 = 1;
        int testValue2 = 2;
        int testValue3 = 3;
        list.addInTail(new Node(testValue1));
        Node testNode = new Node(testValue2);
        list.addInTail(testNode);
        list.addInTail(new Node(testValue3));

        Node foundNode = list.find(testValue2);

        assertEquals(testNode, foundNode);
    }

    @Test
    void testUnsuccessfulFindingInMany() {
        LinkedList2 list = new LinkedList2();
        int testValue1 = 1;
        int testValue2 = 2;
        int testValue3 = 3;
        list.addInTail(new Node(testValue1));
        list.addInTail(new Node(testValue2));
        list.addInTail(new Node(testValue3));

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

        assertFalse(removed);
        assertEquals(list.count(), 0);
        assertEquals(list.head.next, list.tail);
        assertEquals(list.tail.prev, list.head);
    }

    @Test
    void testSuccessfulRemovingOneValueFromOneElementList() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));

        boolean removed = list.remove(1);

        assertTrue(removed);
        assertEquals(list.count(), 0);
        assertEquals(list.head.next, list.tail);
        assertEquals(list.tail.prev, list.head);
    }

    @Test
    void testUnsuccessfulRemovingOneValueFromOneElementList() {
        LinkedList2 list = new LinkedList2();
        int testValue = 1;
        list.addInTail(new Node(testValue));
        int valueNotInList = 2;

        boolean removed = list.remove(valueNotInList);

        assertNull(list.find(valueNotInList));
        assertFalse(removed);
        assertEquals(list.count(), 1);
        assertEquals(list.head.next.value, testValue);
        assertEquals(list.tail.prev.value, testValue);
    }

    @Test
    void testRemovingOneValueAfterHeadFromTwoElementsList() {
        LinkedList2 list = new LinkedList2();
        int testValue1 = 1;
        int testValue2 = 2;
        list.addInTail(new Node(testValue1));
        list.addInTail(new Node(testValue2));

        boolean removed = list.remove(testValue1);

        assertNull(list.find(testValue1));
        assertEquals(list.head.next.value, testValue2);
        assertEquals(list.tail.prev.value, testValue2);
        assertTrue(removed);
        assertEquals(list.count(), 1);
    }

    @Test
    void testRemovingBeforeTailFromTwoElementsList() {
        LinkedList2 list = new LinkedList2();
        int testValue1 = 1;
        int testValue2 = 2;
        list.addInTail(new Node(testValue1));
        list.addInTail(new Node(testValue2));

        boolean removed = list.remove(testValue2);

        assertNull(list.find(testValue2));
        assertEquals(list.head.next.value, testValue1);
        assertEquals(list.tail.prev.value, testValue1);
        assertTrue(removed);
        assertEquals(list.count(), 1);
    }

    @Test
    void testSuccessfulRemovingOneValueInMiddleFromManyElementsList() {
        LinkedList2 list = new LinkedList2();
        int testValue1 = 1;
        int testValue2 = 2;
        int testValue3 = 3;
        list.addInTail(new Node(testValue1));
        list.addInTail(new Node(testValue2));
        list.addInTail(new Node(testValue3));

        boolean removed = list.remove(testValue2);

        assertNull(list.find(testValue2));
        assertEquals(list.count(), 2);
        assertTrue(removed);
        assertEquals(list.head.next.value, testValue1);
        assertEquals(list.tail.prev.value, testValue3);
        assertEquals(list.head.next.next.value, testValue3);
        assertEquals(list.tail.prev.prev.value, testValue1);
    }

    @Test
    void testUnsuccessfulRemovingOneValueFromManyElementsList() {
        LinkedList2 list = new LinkedList2();
        int testValue1 = 1;
        int testValue2 = 2;
        int testValue3 = 3;
        list.addInTail(new Node(testValue1));
        list.addInTail(new Node(testValue2));
        list.addInTail(new Node(testValue3));
        int valueNotInList = 10;

        boolean removed = list.remove(valueNotInList);

        assertEquals(list.count(), 3);
        assertFalse(removed);
        assertEquals(list.head.next.value, testValue1);
        assertEquals(list.head.next.next.value, testValue2);
        assertEquals(list.tail.prev.value, testValue3);
    }

    @Test
    void testSuccessfulRemovingManyInMany() {
        LinkedList2 list = new LinkedList2();
        int testValue = 1;
        list.addInTail(new Node(testValue));
        list.addInTail(new Node(2));
        list.addInTail(new Node(testValue));

        list.removeAll(testValue);

        assertEquals(list.count(), 1);
        assertNull(list.find(testValue));
        assertEquals(list.head.next.value, 2);
        assertEquals(list.tail.prev.value, 2);
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
        assertEquals(list.head.next.value, 1);
        assertEquals(list.head.next.next.value, 3);
        assertEquals(list.tail.prev.value, 3);
        assertEquals(list.tail.prev.prev.value, 1);
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
        assertEquals(list.head.next, nodeToInsert);
        assertEquals(nodeToInsert.prev, list.head);
        assertEquals(nodeToInsert.next.value, 1);
        assertEquals(list.find(1).prev, nodeToInsert);
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
        assertEquals(list.head.next, nodeToInsert);
        assertEquals(nodeToInsert.prev, list.head);
        assertEquals(nodeToInsert.next.value, 1);
        assertEquals(list.find(1).prev, nodeToInsert);
    }

    @Test
    void testInsertAfterLast() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        Node last = new Node(3);
        list.addInTail(last);

        Node nodeToInsert = new Node(4);
        list.insertAfter(last, nodeToInsert);

        assertEquals(list.count(), 4);
        assertEquals(list.tail.prev, nodeToInsert);
        assertEquals(nodeToInsert.next, list.tail);
        assertEquals(nodeToInsert.prev, last);
        assertEquals(last.next, nodeToInsert);
    }

    @Test
    void testInsertInEmptyList() {
        LinkedList2 list = new LinkedList2();
        int testValue = 1;
        Node nodeToInsert = new Node(testValue);

        list.insertAfter(null, nodeToInsert);

        assertEquals(list.count(), 1);
        assertEquals(list.head.next, nodeToInsert);
        assertEquals(list.tail.prev, nodeToInsert);
        assertEquals(nodeToInsert.prev, list.head);
        assertEquals(nodeToInsert.next, list.tail);
    }

    @Test
    void testClearing() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));

        list.clear();

        assertEquals(list.count(), 0);
        assertEquals(list.head.next, list.tail);
        assertEquals(list.tail.prev, list.head);
    }
}