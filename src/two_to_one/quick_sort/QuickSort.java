package two_to_one.quick_sort;

import java.util.Random;

public class QuickSort {
    private QuickSort(){}

    public static <E extends Comparable<E>> void  sort(E[] arr){
        sort(arr,0,arr.length - 1);
    }
    private static <E extends Comparable<E>> void  sort(E[] arr,int l, int r){
        if (l >= r) return;
        int p = partition(arr,l,r);
        sort(arr,l, p -1);
        sort(arr,p, r);
    }
    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r){

        int p = l + (new Random().nextInt( r - l + 1));
        swap(arr,l,p);

        //arr[l + 1...j] < v,arr[j+1...i] >= v
        int j = l;

        for (int i = l + 1; i <= r ; i++) {
            if (arr[i].compareTo(arr[l]) < 0){
                j ++;
                swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        return j;
    }
    public static <E extends Comparable<E>> void  sort2ways(E[] arr){
        sort2ways(arr,0,arr.length - 1);
    }
    private static <E extends Comparable<E>> void  sort2ways(E[] arr,int l, int r){
        if (l >= r) return;
        int p = partition2(arr,l,r);
        sort2ways(arr,l, p -1);
        sort2ways(arr,p, r);
    }
    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r){

        int p = l + (new Random().nextInt( r - l + 1));
        swap(arr,l,p);

        //arr[l +1 .... i -1]<= v; arr[j+1...r] >=v
        int i  = l + 1, j = r;
        while (true){
            while (i <= j && arr[i].compareTo(arr[l]) < 0)
                i++;
            while (j >= i && arr[j].compareTo(arr[l]) > 0)
                j--;
            if (i >= j)break;
            swap(arr,i,j);
            i++;
            j++;
        }
        swap(arr,i,j);
        return j;
    }


    public static <E extends Comparable<E>> void  sort3ways(E[] arr){
        sort3ways(arr,0,arr.length - 1);
    }
    private static <E extends Comparable<E>> void  sort3ways(E[] arr,int l, int r){
        if (l >= r) return;
        int p = l + (new Random().nextInt( r - l + 1));
        swap(arr,l,p);

        int lt = l, i = l +1,gt = r +1;
        while (i < gt){
            if (arr[i].compareTo(arr[l]) < 0){
                lt ++;
                swap(arr,i,lt);
                i++;
            }else  if (arr[i].compareTo(arr[l]) > 0){
                gt--;
                swap(arr,i,gt);
            }else {
                i++;
            }
        }
        swap(arr,l,lt);
        sort3ways(arr,l,lt - 1);
        sort3ways(arr,gt,r);
    }


    private static<E> void swap(E[] arr, int i, int j) {
        E t  = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
