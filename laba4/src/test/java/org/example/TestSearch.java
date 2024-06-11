package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearch {
    @Test (groups = "search")
    void testBinarySearchInt() {
        // Arange - создание окружения
        int[] sorted_array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int expected_result = 7;
        int actual_result;

        // Act - действие
        actual_result = Search.binarySearch(sorted_array, 8);

        // Assert - сравнение
        Assert.assertEquals(actual_result, expected_result);
    }
}