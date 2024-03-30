package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.Sorts.*;

public class TestSorts {
    @Test
    void TestQuickSortInt () {
        // Arange - создание окружения,
        int[] array = new int[] {9, 18, 2, 4, 7, 5};
        int[] expected_result = new int[] {2, 4, 5, 7, 9, 18};
        int[] actual_result;

        // Act - действие
        Sorts.QuickSort(array, 0, array.length - 1);
        actual_result = array;

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result);
    }

    @Test
    void TestQuickSortDouble () {
        // Arange - создание окружения,
        double[] array = new double[] {9.123, 18.213, 2.24, 4.901, 7.77, 5.52};
        double[] expected_result = new double[] {2.24, 4.901, 5.52, 7.77, 9.123, 18.213};
        double[] actual_result;
        // Act - действие
        Sorts.QuickSort(array, 0, array.length - 1);
        actual_result = array;


      // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result);
    }


    @Test
    void TestMergeSortInt () {
        // Arange - создание окружения,
        int[] array = new int[] {9, 18, 2, 4, 7, 5};
        int[] expected_result = new int[] {2, 4, 5, 7, 9, 18};
        int[] actual_result;

        // Act - действие
        actual_result = Sorts.MergeSort(array);

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result);
    }

    @Test
    void TestMergeSortDouble () {
        // Arange - создание окружения,
        double[] array = new double[] {9.123, 18.213, 2.24, 4.901, 7.77, 5.52};
        double[] expected_result = new double[] {2.24, 4.901, 5.52, 7.77, 9.123, 18.213};
        double[] actual_result;

        // Act - действие
        actual_result = Sorts.MergeSort(array);

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result);
    }


    @Test
    void TestGnomeSortInt () {
        // Arange - создание окружения,
        int[] array = new int[] {9, 18, 2, 4, 7, 5};
        int[] expected_result = new int[] {2, 4, 5, 7, 9, 18};
        int[] actual_result;

        // Act - действие
        Sorts.GnomeSort(array);
        actual_result = array;

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result);
    }

    @Test
    void TestGnomeSortDouble () {
        // Arange - создание окружения,
        double[] array = new double[] {9.123, 18.213, 2.24, 4.901, 7.77, 5.52};
        double[] expected_result = new double[] {2.24, 4.901, 5.52, 7.77, 9.123, 18.213};
        double[] actual_result;

        // Act - действие
        Sorts.GnomeSort(array);
        actual_result = array;

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result);
    }


    @Test
    void TestSelectionSortInt () {
        // Arange - создание окружения,
        int[] array = new int[] {9, 18, 2, 4, 7, 5};
        int[] expected_result = new int[] {2, 4, 5, 7, 9, 18};
        int[] actual_result;

        // Act - действие
        Sorts.SelectionSort(array);
        actual_result = array;

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result);
    }

    @Test
    void TestSelectionSortDouble () {
        // Arange - создание окружения,
        double[] array = new double[] {9.123, 18.213, 2.24, 4.901, 7.77, 5.52};
        double[] expected_result = new double[] {2.24, 4.901, 5.52, 7.77, 9.123, 18.213};
        double[] actual_result;

        // Act - действие
        Sorts.SelectionSort(array);
        actual_result = array;

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result);
    }
}