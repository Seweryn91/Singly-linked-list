import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    @DisplayName("Test adding new elements")
    void addTest() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.add(5);
        linkedList.add(10);
        String expectedResult = "5 10";
        String actualResult = linkedList.toString();
        String expectedHead = "5";
        String actualHead = linkedList.head().toString();
        String expectedTail = "10";
        String actualTail = linkedList.tail().toString();

        assertEquals(expectedResult, actualResult);
        assertEquals(expectedHead, actualHead);
        assertEquals(expectedTail, actualTail);
    }

    @Test
    @DisplayName("Test removing elements with correct indexes")
    void removeTest_WithCorrectInput() {
        SinglyLinkedList linkedList = createList(10);
        linkedList.remove(0);
        linkedList.remove(5);
        String expectedResult = "1 2 3 4 5 7 8 9";
        String actualResult = linkedList.toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test removing elements with incorrect indexes")
    void removeTest_WithIncorrectInput() {
        SinglyLinkedList linkedList = createList(10);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> linkedList.remove(20));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> linkedList.remove(-1));
    }

    @Test
    @DisplayName("Test inserting value at correct index")
    void insertTest_WithCorrectInput() {
        SinglyLinkedList linkedList = createList(10);
        linkedList.insert(2, 67);
        linkedList.insert(3, 67);

        String expectedResult = "0 1 67 67 2 3 4 5 6 7 8 9";
        String actualResult = linkedList.toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test insertions at first and last indexes")
    void insertTest_firstAndLastIndex() {
        SinglyLinkedList linkedList = createList(10);
        linkedList.insert(9, 15);
        linkedList.insert(0, 33);

        String expectedResult = "33 0 1 2 3 4 5 6 7 8 15 9";
        String actualResult = linkedList.toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test inserting value on incorrect indexes")
    void insertTest_incorrectIndex() {
        SinglyLinkedList linkedList = createList(10);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> linkedList.insert(-1, 9));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> linkedList.insert(10, 9));
    }

    @Test
    @DisplayName("Test getting value from correct index")
    void getTest_correctIndex() {
        SinglyLinkedList linkedList = createList(10);
        String expectedResult = "3";
        String actualResult = linkedList.get(3).toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test getting value from incorrect index")
    void getTest_incorrectIndex() {
        SinglyLinkedList linkedList = createList(10);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> linkedList.get(10));
    }

    @Test
    @DisplayName("Test getting value from empty list")
    void getTest_fromEmptyList() {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> linkedList.get(0));
    }

    private SinglyLinkedList createList(int size) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        for(int i = 0; i < size; i++) {
            linkedList.add(i);
        }

        return linkedList;
    }
}