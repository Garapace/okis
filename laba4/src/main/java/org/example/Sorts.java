package org.example;

public class Sorts {
    public static void QuickSort (int[] array, int left, int right) {
        if (array.length == 0 || left > right) return;

        if (left < right) {
            int divide_index = Partition(array, left, right);

            QuickSort(array, left, divide_index - 1);
            QuickSort(array, divide_index, right);
        }
    }

    private static int Partition (int[] array, int left, int right) {
        int left_index = left;
        int right_index = right;

        int pivot = array[(left + right) / 2];
        while (left_index <= right_index) {

            while (array[left_index] < pivot) left_index++;
            while (array[right_index] > pivot) right_index--;

            if (left_index <= right_index) {
                Swap(array, left_index, right_index);
                left_index++;
                right_index--;
            }
        }
        return left_index;
    }

    public static int[] MergeSort (int[] array) {
        int[] temp;
        int[] CurrentArray = array;
        int[] CurrentDest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                Merge(CurrentArray, i, CurrentArray, i + size, CurrentDest, i, size);
            }
            temp = CurrentArray;
            CurrentArray = CurrentDest;
            CurrentDest = temp;

            size *= 2;
        }
        return CurrentArray;
    }

    private static void Merge (int[] array1, int array1_start, int[] array2, int array2_start,
                               int[] dest, int dest_start, int size) {
        int index1 = array1_start;
        int index2 = array2_start;

        int array1_end = Math.min(array1_start + size, array1.length);
        int array2_end = Math.min(array2_start + size, array2.length);

        int count = array1_end - array1_start + array2_end - array2_start;

        for (int i = dest_start; i < dest_start + count; i++) {
            if (index1 < array1_end && (index2 >= array2_end || array1[index1] < array2[index2])) {
                dest[i] = array1[index1];
                index1++;
            } else {
                dest[i] = array2[index2];
                index2++;
            }
        }
    }

    public static void GnomeSort (int[] array) {
        int index = 1;
        int pivot = 0;
        for (; pivot < array.length - 1;) {
            if (array[pivot] < array[pivot + 1]) {
                pivot = index;
                index++;
            } else {
                int temp = array[pivot];
                array[pivot] = array[pivot + 1];
                array[pivot + 1] = temp;
                pivot--;
                if (pivot < 0) {
                    pivot = index;
                    index++;
                }
            }
        }
    }

    public static void SelectionSort (int[] array) {
        for (int step = 0; step < array.length; step++) {
            int index = Min(array, step);
            Swap(array, step, index);
        }
    }

    private static int Min(int[] array, int start) {
        int min_index = start;
        int min_value = array[start];
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < min_value) {
                min_value = array[i];
                min_index = i;
            }
        }
        return min_index;
    }

    // =======================================================

    public static void QuickSort (double[] array, int left, int right) {
        if (array.length == 0 || left > right) return;

        if (left < right) {
            int divide_index = Partition(array, left, right);

            QuickSort(array, left, divide_index - 1);
            QuickSort(array, divide_index, right);
        }
    }

    private static int Partition (double[] array, int left, int right) {
        int left_index = left;
        int right_index = right;

        double pivot = array[(left + right) / 2];
        while (left_index <= right_index) {

            while (array[left_index] < pivot) left_index++;
            while (array[right_index] > pivot) right_index--;

            if (left_index <= right_index) {
                Swap(array, left_index, right_index);
                left_index++;
                right_index--;
            }
        }
        return left_index;
    }

    public static double[] MergeSort (double[] array) {
        double[] temp;
        double[] CurrentArray = array;
        double[] CurrentDest = new double[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                Merge(CurrentArray, i, CurrentArray, i + size, CurrentDest, i, size);
            }
            temp = CurrentArray;
            CurrentArray = CurrentDest;
            CurrentDest = temp;

            size *= 2;
        }
        return CurrentArray;
    }

    private static void Merge (double[] array1, int array1_start, double[] array2, int array2_start,
                               double[] dest, int dest_start, int size) {
        int index1 = array1_start;
        int index2 = array2_start;

        int array1_end = Math.min(array1_start + size, array1.length);
        int array2_end = Math.min(array2_start + size, array2.length);

        int count = array1_end - array1_start + array2_end - array2_start;

        for (int i = dest_start; i < dest_start + count; i++) {
            if (index1 < array1_end && (index2 >= array2_end || array1[index1] < array2[index2])) {
                dest[i] = array1[index1];
                index1++;
            } else {
                dest[i] = array2[index2];
                index2++;
            }
        }
    }

    public static void GnomeSort (double[] array) {
        int index = 1;
        int pivot = 0;
        for (; pivot < array.length - 1;) {
            if (array[pivot] < array[pivot + 1]) {
                pivot = index;
                index++;
            } else {
                double temp = array[pivot];
                array[pivot] = array[pivot + 1];
                array[pivot + 1] = temp;
                pivot--;
                if (pivot < 0) {
                    pivot = index;
                    index++;
                }
            }
        }
    }

    public static void SelectionSort (double[] array) {
        for (int step = 0; step < array.length; step++) {
            int index = Min(array, step);
            Swap(array, step, index);
        }
    }

    private static int Min(double[] array, int start) {
        int min_index = start;
        double min_value = array[start];
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < min_value) {
                min_value = array[i];
                min_index = i;
            }
        }
        return min_index;
    }

    private static void Swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void Swap(double[] array, int index1, int index2) {
        double temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
