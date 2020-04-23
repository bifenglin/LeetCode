package sort;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-20 11:47
 **/
public class mergeSort {

    public static void main(String[] args) {
//        int[] arr = new int[]{5, 4,1,6,7};
        int[] arr = new int[]{5, 4,1,6,7};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr) {
        progress(arr, 0, arr.length-1);
    }

    static void progress(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        progress(arr, l, mid);
        progress(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    static void merge(int[] arr, int l, int mid, int r) {
        if (l >= r) {
            return;
        }
        int left = l;
        int right = mid + 1;
        int[] temp = new int[r - l + 1];
        int index = 0;
        while (left <= mid && right <= r) {
            if (arr[left] > arr[right]) {
                temp[index++] = arr[right++];
            } else {
                temp[index++] = arr[left++];
            }
        }
        while (left <= mid){
            temp[index++] = arr[left++];
        }
        while (right <= r){
            temp[index++] = arr[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[l+i] = temp[i];
        }
    }

}
