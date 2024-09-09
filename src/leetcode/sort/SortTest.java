package leetcode.sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {

    private Sort sort;

    @Before
    public void setUp() {
        sort = new Sort();
    }

    @Test
    public void testBubbleSortEmptyArray() {
        int[] array = {};
        int[] expected = {};
        assertArrayEquals(expected, sort.bubbleSort(array));
    }

    @Test
    public void testBubbleSortSingleElement() {
        int[] array = {1};
        int[] expected = {1};
        assertArrayEquals(expected, sort.bubbleSort(array));
    }

    @Test
    public void testBubbleSortAlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, sort.bubbleSort(array));
    }

    @Test
    public void testBubbleSortReverseSorted() {
        int[] array = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, sort.bubbleSort(array));
    }

    @Test
    public void testBubbleSortWithDuplicates() {
        int[] array = {3, 1, 2, 3, 2};
        int[] expected = {1, 2, 2, 3, 3};
        assertArrayEquals(expected, sort.bubbleSort(array));
    }

    @Test
    public void testSelectionSortEmptyArray() {
        int[] array = {};
        int[] expected = {};
        assertArrayEquals(expected, sort.selectionSort(array));
    }

    @Test
    public void testSelectionSortSingleElement() {
        int[] array = {1};
        int[] expected = {1};
        assertArrayEquals(expected, sort.selectionSort(array));
    }

    @Test
    public void testSelectionSortAlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, sort.selectionSort(array));
    }

    @Test
    public void testSelectionSortReverseSorted() {
        int[] array = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, sort.selectionSort(array));
    }

    @Test
    public void testSelectionSortWithDuplicates() {
        int[] array = {3, 1, 2, 3, 2};
        int[] expected = {1, 2, 2, 3, 3};
        assertArrayEquals(expected, sort.selectionSort(array));
    }

    @Test
    public void testInsertionSortEmptyArray() {
        int[] array = {};
        int[] expected = {};
        assertArrayEquals(expected, sort.insertionSort(array));
    }

    @Test
    public void testInsertionSortSingleElement() {
        int[] array = {1};
        int[] expected = {1};
        assertArrayEquals(expected, sort.insertionSort(array));
    }

    @Test
    public void testInsertionSortAlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, sort.insertionSort(array));
    }

    @Test
    public void testInsertionSortReverseSorted() {
        int[] array = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, sort.insertionSort(array));
    }

    @Test
    public void testInsertionSortWithDuplicates() {
        int[] array = {3, 1, 2, 3, 2};
        int[] expected = {1, 2, 2, 3, 3};
        assertArrayEquals(expected, sort.insertionSort(array));
    }

    @Test
    public void testMergeSortEmptyArray() {
        int[] array = {};
        int[] expected = {};
        assertArrayEquals(expected, sort.mergeSort(array));
    }

    @Test
    public void testMergeSortSingleElement() {
        int[] array = {1};
        int[] expected = {1};
        assertArrayEquals(expected, sort.mergeSort(array));
    }

    @Test
    public void testMergeSortAlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, sort.mergeSort(array));
    }

    @Test
    public void testMergeSortReverseSorted() {
        int[] array = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, sort.mergeSort(array));
    }

    @Test
    public void testMergeSortWithDuplicates() {
        int[] array = {3, 1, 2, 3, 2};
        int[] expected = {1, 2, 2, 3, 3};
        assertArrayEquals(expected, sort.mergeSort(array));
    }

    @Test
    public void testMergeSortWithNegativeNumbers() {
        int[] array = {-1, -3, 2, 0, 5, -2};
        int[] expected = {-3, -2, -1, 0, 2, 5};
        assertArrayEquals(expected, sort.mergeSort(array));
    }

    @Test
    public void testMergeSortLargeArray() {
        int[] array = {10, 5, 3, 8, 7, 6, 4, 2, 9, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expected, sort.mergeSort(array));
    }

    @Test
    public void testMergeSortArrayWithAllSameElements() {
        int[] array = {7, 7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7, 7};
        assertArrayEquals(expected, sort.mergeSort(array));
    }

    @Test
    public void testQuickSortEmptyArray() {
        int[] array = {};
        int[] expected = {};
        assertArrayEquals(expected, sort.quickSort(array));
    }

    @Test
    public void testQuickSortSingleElement() {
        int[] array = {1};
        int[] expected = {1};
        assertArrayEquals(expected, sort.quickSort(array));
    }

    @Test
    public void testQuickSortAlreadySorted() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, sort.quickSort(array));
    }

    @Test
    public void testQuickSortReverseSorted() {
        int[] array = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, sort.quickSort(array));
    }

    @Test
    public void testQuickSortWithDuplicates() {
        int[] array = {3, 1, 2, 3, 2};
        int[] expected = {1, 2, 2, 3, 3};
        assertArrayEquals(expected, sort.quickSort(array));
    }

    @Test
    public void testQuickSortWithNegativeNumbers() {
        int[] array = {-1, -3, 2, 0, 5, -2};
        int[] expected = {-3, -2, -1, 0, 2, 5};
        assertArrayEquals(expected, sort.quickSort(array));
    }

    @Test
    public void testQuickSortLargeArray() {
        int[] array = {10, 5, 3, 8, 7, 6, 4, 2, 9, 1};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expected, sort.quickSort(array));
    }

    @Test
    public void testQuickSortArrayWithAllSameElements() {
        int[] array = {7, 7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7, 7};
        assertArrayEquals(expected, sort.quickSort(array));
    }

}
