package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestSorts {
    @Test (groups = "positive")
    void testQuickSortInt() {
        // Arange - создание окружения
        int[] array = new int[] {9, 18, 2, 4, 7, 5};
        int[] expected_result = new int[] {2, 4, 5, 7, 9, 18};
        int[] actual_result;

        // Act - действие
        Sorts.quickSort(array, 0, array.length - 1);
        actual_result = array;

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result);
    }

    @Test (groups = "positive")
    void testQuickSortDouble() {
        // Arange - создание окружения
        final double delta = 1e-2;
        double[] array = new double[] {9.123, 18.213, 2.24, 4.901, 7.77, 5.52};
        double[] expected_result = new double[] {2.24, 4.901, 5.52, 7.77, 9.123, 18.213};
        double[] actual_result;

        // Act - действие
        Sorts.quickSort(array, 0, array.length - 1);
        actual_result = array;


      // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result, delta);
    }


    @Test (groups = "positive")
    void testMergeSortInt() {
        // Arange - создание окружения
        int[] array = new int[] {9, 18, 2, 4, 7, 5};
        int[] expected_result = new int[] {2, 4, 5, 7, 9, 18};
        int[] actual_result;

        // Act - действие
        actual_result = Sorts.mergeSort(array);

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result);
    }

    @Test (groups = "positive")
    void testMergeSortDouble() {
        // Arange - создание окружения
        final double delta = 1e-2;
        double[] array = new double[] {9.123, 18.213, 2.24, 4.901, 7.77, 5.52};
        double[] expected_result = new double[] {2.24, 4.901, 5.52, 7.77, 9.123, 18.213};
        double[] actual_result;

        // Act - действие
        actual_result = Sorts.mergeSort(array);

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result, delta);
    }


    @Test (groups = "positive")
    void testGnomeSortInt() {
        // Arange - создание окружения
        int[] array = new int[] {9, 18, 2, 4, 7, 5};
        int[] expected_result = new int[] {2, 4, 5, 7, 9, 18};
        int[] actual_result;

        // Act - действие
        Sorts.gnomeSort(array);
        actual_result = array;

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result);
    }

    @Test (groups = "positive")
    void testGnomeSortDouble() {
        // Arange - создание окружения
        final double delta = 1e-2;
        double[] array = new double[] {9.123, 18.213, 2.24, 4.901, 7.77, 5.52};
        double[] expected_result = new double[] {2.24, 4.901, 5.52, 7.77, 9.123, 18.213};
        double[] actual_result;

        // Act - действие
        Sorts.gnomeSort(array);
        actual_result = array;

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result, delta);
    }


    @Test (groups = "positive")
    void testSelectionSortInt() {
        // Arange - создание окружения
        int[] array = new int[] {9, 18, 2, 4, 7, 5};
        int[] expected_result = new int[] {2, 4, 5, 7, 9, 18};
        int[] actual_result;

        // Act - действие
        Sorts.selectionSort(array);
        actual_result = array;

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result);
    }

    @Test (groups = "positive")
    void testSelectionSortDouble() {
        // Arange - создание окружения
        final double delta = 1e-2;
        double[] array = new double[] {9.123, 18.213, 2.24, 4.901, 7.77, 5.52};
        double[] expected_result = new double[] {2.24, 4.901, 5.52, 7.77, 9.123, 18.213};
        double[] actual_result;

        // Act - действие
        Sorts.selectionSort(array);
        actual_result = array;

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result, delta);
    }



    @Test (groups = "negative", expectedExceptions = {IllegalArgumentException.class} )
    void testNegativeQuickSortInt() {
        // Arange - создание окружения
        int[] array = new int[] {9, 18, 2, 4, 7, 5};
        int[] expected_result = new int[] {2, 4, 5, 7, 9, 18};
        int[] actual_result;

        // Act - действие
        Sorts.quickSort(array, -1000, array.length - 1);
        actual_result = array;

        // Assert - сравнение
        Assert.assertNotEquals(actual_result, expected_result);
    }
}