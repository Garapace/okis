package org.example;

public class Search {
    public static int binarySearch(int[] sorted_array, int target) {
        int left_index = 0;
        int right_index =  sorted_array.length - 1;

        while (left_index <= right_index) {
            int middle_index = left_index + (right_index - left_index) / 2; // чтобы избежать переполнения, когда размера массива слишком большой
            int current = sorted_array[middle_index];

            if (current == target) {
                return middle_index;
            } else if (current < target) {
                left_index = middle_index + 1;
            } else {
                right_index = middle_index - 1;
            }
        }
        return -1;
    }
}