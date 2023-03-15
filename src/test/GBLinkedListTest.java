package test;

import gb.linkedList.GBLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GBLinkedListTest {

    @Test
    void addFirstTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.addFirst(10);
        assertEquals(1, expectedTest.size());
        expectedTest.addFirst(15);
        expectedTest.addFirst(1);
        expectedTest.addFirst(33);
        assertEquals(33, expectedTest.get(0));
        assertEquals(1, expectedTest.get(1));
        assertEquals(15, expectedTest.get(2));
        assertEquals(10, expectedTest.get(3));
        assertEquals(4, expectedTest.size());
    }

    @Test
    void addFirstNegativeTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.addFirst(10);
        expectedTest.addFirst(15);
        expectedTest.addFirst(1);
        expectedTest.addFirst(33);
        assertNotEquals(10, expectedTest.get(0));
        assertNotEquals(33, expectedTest.get(1));
        assertNotEquals(10, expectedTest.get(2));
        assertNotEquals(15, expectedTest.get(3));
    }

    @Test
    void addLastTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.addLast(17);
        expectedTest.addLast(25);
        expectedTest.addLast(56);
        assertEquals(56, expectedTest.get(expectedTest.size() - 1));
        assertEquals(25, expectedTest.get(1));
        assertEquals(17, expectedTest.get(0));

    }

    @Test
    void addLastNegativeTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.addLast(17);
        expectedTest.addLast(25);
        expectedTest.addLast(56);
        assertNotEquals(17, expectedTest.get(expectedTest.size() - 1));
        assertNotEquals(56, expectedTest.get(1));
        assertNotEquals(25, expectedTest.get(0));
    }
    @Test
    void addByIndexTest(){
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.add(0, 18);
        assertEquals(1, expectedTest.size());
        expectedTest.add(1, 24);
        expectedTest.add(2, 14);
        assertEquals(18, expectedTest.get(0));
        assertEquals(24, expectedTest.get(1));
        assertEquals(14, expectedTest.get(2));
    }
    @Test
    void addByIndexNegativeTest(){
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.add(0, 18);
        assertNotEquals(0, expectedTest.size());
        expectedTest.add(1, 24);
        expectedTest.add(2, 14);
        assertNotEquals(10, expectedTest.get(0));
        assertNotEquals(25, expectedTest.get(1));
        assertNotEquals(15, expectedTest.get(2));
    }

    @Test
    void removeTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.add(10);
        expectedTest.add(44);
        expectedTest.add(88);
        expectedTest.add(13);
        expectedTest.add(9);
        assertEquals(5, expectedTest.size());
        expectedTest.remove(2);
        assertEquals(4, expectedTest.size());
    }

    @Test
    void removeNegativeTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.add(10);
        expectedTest.add(44);
        expectedTest.add(88);
        expectedTest.add(13);
        expectedTest.add(9);
        assertEquals(5, expectedTest.size());
        expectedTest.remove(2);
        assertNotEquals(5, expectedTest.size());
    }

    @Test
    void getByIndexTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.add(34);
        expectedTest.add(10);
        expectedTest.add(89);
        assertEquals(34, expectedTest.get(0));
        assertEquals(10, expectedTest.get(1));
        assertEquals(89, expectedTest.get(2));
    }

    @Test
    void getByIndexNegativeTest() {
        GBLinkedList<Integer> expectedTest = new GBLinkedList<>();
        expectedTest.add(34);
        expectedTest.add(10);
        expectedTest.add(89);
        assertNotEquals(10, expectedTest.get(0));
        assertNotEquals(10, expectedTest.get(2));
        assertNotEquals(34, expectedTest.get(1));
    }

    @Test
    void sizeTest() {
        GBLinkedList expectedTest = new GBLinkedList();
        expectedTest.add(15);
        expectedTest.add(20);
        expectedTest.add(11);
        assertEquals(3, expectedTest.size());
    }

    @Test
    void sizeNegativeTest() {
        GBLinkedList expectedTest = new GBLinkedList();
        expectedTest.add(15);
        expectedTest.add(20);
        expectedTest.add(11);
        assertNotEquals(4, expectedTest.size());
    }

}