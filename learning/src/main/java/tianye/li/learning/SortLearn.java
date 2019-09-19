package tianye.li.learning;
/**
 * Created by litianye on 2019-08-30
 */


import javafx.util.Pair;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: learn_and_practice
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-08-30
 **/

public class SortLearn {
    public static void main(String[] args) {
        int[] arr = new int[200];
        Random random = new Random();
        for(int i=0; i<200; i+=2) {
            arr[i] = 100-i;
            arr[i+1] = i;
        }

        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void stream(int[] array) {
        Arrays.stream(array).sorted();
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = (start + end)/2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        mergePart(arr, start, mid, end);
    }

    private static void mergePart(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start;
        int j = mid+1;
        int k = 0;
        while (i<=mid && j<=end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }

            while(i <= mid) {
                temp[k++] = arr[i++];
            }

            while(j <= end) {
                temp[k++] = arr[j++];
            }

            for(int p=0; p<temp.length; p++) {
                arr[start + p] = temp[p];
            }
        }
    }

    private static void quickSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;
        triQuickSort(arr, 0, arr.length-1);
    }

    private static void triQuickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        Pair<Integer, Integer> pair = triQuickSortPart(arr, start, end);
        System.out.println(Arrays.toString(arr));
        triQuickSort(arr, start, pair.getKey()-1);
        triQuickSort(arr, pair.getValue(), end);
    }

    /**
     * (start, lt] < target
     * (lt, i) = target
     * (gt, end) > target
     */
    public static Pair<Integer, Integer> triQuickSortPart(int[] arr, int start, int end) {
        int target=arr[start];
        int lt=start, gt=end+1, i= start+1;
        while (i< gt) {
            if (arr[i] < target) {
                swap(arr, i, lt+1);
                i++;
                lt++;
            }else if (arr[i] > target){
                swap(arr, i, gt-1);
                gt--;
            }else {
                i++;
            }
        }
        swap(arr, start, lt);
        return new Pair<>(lt, gt);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int index = quickSortPart(arr, start, end);
        quickSort(arr, start, index-1);
        quickSort(arr, index+1, end);
    }

    private static int quickSortPart(int[] arr, int start, int end) {
        int i=start, target=arr[start];
        while (start<end) {
            while(start<end && arr[end] >=target) {
                end--;
            }
            while(start<end && arr[start] <=target) {
                start++;
            }
            swap(arr, start, end);
        }
        swap(arr, i, start);
        return i;
    }

    private static void bubbleSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=arr.length-1; j>i; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr,j,j-1);
                }
            }
        }
    }

    private static void selectSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int minIndex = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

//            if (minIndex != i)
            swap(arr, i, minIndex);
        }
    }

    private static void insertSort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int j=i;
            int target = arr[i];

            while(j>0 && target<arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }

            arr[j] = target;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
