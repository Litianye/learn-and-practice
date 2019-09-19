package tianye.learn.practice.base;/**
 * Created by litianye on 2019-03-29
 */


/**
 * @program: learn_and_practice
 *
 * @description: 3.29
 * heap adjust
 * quick sort
 * binary search
 *
 * @author: litianye
 *
 * @create: 2019-03-29
 **/

public class bytedance {
    public static void main(String[] args) {
        int[] test = {1,2,4,5,7,9,11,15,19,22,35,63,124};
        int[] test2 = {123,214,523,23,124,13,235,125,235,323,23,4,56346,3464,53663,45636};
//        System.out.println(binarySearch(test, 20));
        mergeSort(test2, 0, test2.length-1);
        print(test2);
    }

    private static int binarySearch(int[] arr, int target) {
        int i = 0;
        int j = arr.length-1;
        int mid = (i+j)/2;
        while (i < j) {
            if (arr[mid] > target) {
                j = mid-1;
                mid = (i+j)/2;
            }else if (arr[mid] < target) {
                i = mid+1;
                mid = (i+j)/2;
            }else {
                return mid;
            }
        }
        return 0;
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left >= right)
            return ;

        int mid = (left + right)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;

        while (i<=mid && j<=right) {
            if (arr[i]<=arr[j]) {
                tmp[k++] = arr[i++];
            }else {
                tmp[k++] = arr[j++];
            }
        }

        while (i<=mid) {
            tmp[k++] = arr[i++];
        }

        while(j <= right) {
            tmp[k++] = arr[j++];
        }

        for(int p=0; p<tmp.length; p++) {
            arr[left + p] = tmp[p];
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start>=end) return;
        int index = part(arr, start, end);
        quickSort(arr, start, index-1);
        quickSort(arr, index+1, end);
    }

    private static int part(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int flag = arr[start];
        while (right>left) {
            while (right>left && arr[right] >= flag) {
                right --;
            }
            while (right>left && arr[left] <= flag) {
                left ++;
            }
            swap(arr, left, right);
        }
        swap(arr, start, left);
        return left;
    }

    private static void heapSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;

        for (int i=arr.length/2; i>=0; i--) {
            adjustHeap(arr, i, arr.length-1);
        }

        for (int i=arr.length-1; i>=0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i-1);
        }
    }

    private static void adjustHeap(int[] arr, int i, int end) {
        int root = arr[i];
        for (int k=2*i+1; k<=end; k=k*2) {
            if (k+1<end && arr[k] < arr[k+1]) k++;
            if (arr[k] > root) {
                swap(arr, i, k);
                i = k;
            }else {
                break;
            }
        }
    }

    private static void swap (int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void print(int[] arr) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int a: arr) {
            stringBuffer.append(a).append(",");
        }
        System.out.println(stringBuffer.toString());
    }
}
